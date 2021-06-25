package com.sng.gdrs;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sng.gdrs.comm.Util;
import com.sng.gdrs.dto.CodeDto;
import com.sng.gdrs.dto.RecruitDto;
import com.sng.gdrs.model.service.ICodeService;
import com.sng.gdrs.model.service.IRecruitService;

@Controller
public class RecruitController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRecruitService iService;
	@Autowired
	private ICodeService codeService;

	/**
	 * 채용공고 리스트 보기
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/recruitList.do", method = RequestMethod.GET)
	public String recruitList(@RequestParam Map<String, Object> param, HttpSession session, Model model) {
		logger.info("[recruitList] : 채용공고 화면으로 이동");
		session.setAttribute("UserEmail", "kckt66@naver.com");
		
		List<RecruitDto> lists = iService.raUserList(param);
		List<CodeDto> emp = codeService.selectCodeType("EMP");
		JSONArray empJson = Util.ConvertCodeToJson(emp);
		model.addAttribute("lists", lists);
		model.addAttribute("emp", emp);
		model.addAttribute("empJson", empJson);

		return "recruit/recruitList";
	}

	/**
	 * 채용공고 상세보기 화면 이동
	 * 
	 * @param seq
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/recruitDetail.do", method = RequestMethod.GET)
	public String recruitDetail(String seq, Model model) {
		logger.info("[recruitDetail] : 채용공고 상세조회 화면으로 이동");

		RecruitDto dto = iService.raDetail(Integer.parseInt(seq));
		model.addAttribute("dto", dto);
		
		JSONArray emp = Util.ConvertCodeToJson(codeService.selectCodeType("EMP"));
		JSONArray rcs = Util.ConvertCodeToJson(codeService.selectCodeType("RCS"));
		
		model.addAttribute("emp", emp);
		model.addAttribute("rcs", rcs);

		return "recruit/recruitDetail";
	}

	/**
	 * 채용공고 신규작성 화면으로 이동
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/recruitInsertForm.do", method = RequestMethod.GET)
	public String recruitInsertForm(Model model) {
		logger.info("[recruitInsertForm] : 채용공고 신규작성 화면으로 이동");

		List<CodeDto> emp = codeService.selectCodeType("EMP");
		List<CodeDto> rcs = codeService.selectCodeType("RCS");
		model.addAttribute("emp", emp);
		model.addAttribute("rcs", rcs);

		return "recruit/recruitInsert";
	}

	/**
	 * 채용공고 신규작성 프로세스
	 * 
	 * @param param
	 * @param resp
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping(value = "/recruitInsert.do", method = RequestMethod.POST)
	public void recruitInsert(@RequestParam Map<String, Object> param, HttpServletResponse resp) throws ParseException, IOException {
		logger.info("[recruitInsert] : 채용공고 신규작성 프로세스");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		RecruitDto rDto = new RecruitDto();
		rDto.setTitle((String) param.get("title"));
		rDto.setEmploy((String) param.get("employ"));
		rDto.setStatus((String) param.get("status"));
		rDto.setContent((String) param.get("content"));
		rDto.setStartterm(sdf.parse((String) param.get("startterm")));
		if (((String) param.get("endterm")).equals("")) {
			rDto.setEndterm(null);
		} else {
			rDto.setEndterm(sdf.parse((String) param.get("endterm")));
		}

		// writer 임시
		rDto.setWriter("dntjdgh02@naver.com");

		boolean isc = iService.raWrite(rDto);
		if (isc) {
			Util.PrintWriterMsg(resp, "작성이 완료 되었습니다.", "recruitDetail.do?seq=" + rDto.getSeq());
		} else {
			Util.PrintWriterMsg(resp, "문제가 발생했습니다.\\n 관리자에게 문의하세요.", "recruitInsertForm.do");
		}
	}

	/**
	 * 채용공고 삭제 프로세스
	 * 
	 * @param seq
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value = "/recruitDelete.do", method = RequestMethod.GET)
	public void recruitDelete(String seq, HttpServletResponse resp) throws IOException {
		logger.info("[recruitDelete] : 채용공고 삭제 프로세스 (delflag = 'Y')");

		boolean isc = iService.raDelFlag(Integer.parseInt(seq));
		if (isc) {
			Util.PrintWriterMsg(resp, "삭제가 완료 되었습니다.", "./recruitList.do");
		} else {
			Util.PrintWriterMsg(resp, "문제가 발생했습니다.\\n 관리자에게 문의하세요.", "./recruitList.do");
		}
	}

	/**
	 * 채용공고 수정 화면으로 이동
	 * 
	 * @param seq
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/recruitModifyForm.do", method = RequestMethod.GET)
	public String recruitModifyForm(String seq, Model model) {
		logger.info("[recruitModifyForm] : 채용공고 수정 화면으로 이동");

		RecruitDto rDto = iService.raDetail(Integer.parseInt(seq));
		model.addAttribute("dto", rDto);

		List<CodeDto> emp = codeService.selectCodeType("EMP");
		List<CodeDto> rcs = codeService.selectCodeType("RCS");
		model.addAttribute("emp", emp);
		model.addAttribute("rcs", rcs);

		return "recruit/recruitModify";
	}

	/**
	 * 채용공고 수정 프로세스
	 * 
	 * @param param
	 * @param resp
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping(value = "/recruitModify.do", method = RequestMethod.POST)
	public void recruitModify(@RequestParam Map<String, Object> param, HttpServletResponse resp) throws ParseException, IOException {
		logger.info("[recruitModify] : 채용공고 수정 프로세스");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		RecruitDto rDto = new RecruitDto();
		rDto.setSeq(Integer.parseInt((String) param.get("seq")));
		rDto.setTitle((String) param.get("title"));
		rDto.setEmploy((String) param.get("employ"));
		rDto.setStatus((String) param.get("status"));
		rDto.setContent((String) param.get("content"));
		rDto.setStartterm(sdf.parse((String) param.get("startterm")));
		if (((String) param.get("endterm")).equals("")) {
			rDto.setEndterm(null);
		} else {
			rDto.setEndterm(sdf.parse((String) param.get("endterm")));
		}

		// writer 임시
		rDto.setWriter("dntjdgh02@naver.com");

		boolean isc = iService.raModify(rDto);
		if (isc) {
			Util.PrintWriterMsg(resp, "수정이 완료 되었습니다.", "recruitDetail.do?seq=" + rDto.getSeq());
		} else {
			Util.PrintWriterMsg(resp, "문제가 발생했습니다.\\n 관리자에게 문의하세요.", "recruitDetail.do?seq=" + rDto.getSeq());
		}
	}
}
