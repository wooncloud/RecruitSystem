package com.sng.gdrs;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/recuitList.do", method = RequestMethod.GET)
	public String recuitList(HttpSession session, Model model) {
		logger.info("[recuitList] : 채용공고 화면으로 이동");
		session.setAttribute("UserEmail", "kckt66@naver.com");
		
		List<RecruitDto> lists = iService.raUserList();
		List<CodeDto> emp = codeService.selectCodeType("EMP");
		
		model.addAttribute("lists", lists);
		model.addAttribute("emp", emp);
		
		return "recruit/recuitList";
	}
	
	@RequestMapping(value = "/recuitDetail.do", method = RequestMethod.GET)
	public String recuitDetail(String seq, Model model) {
		logger.info("[recuitDetail] : 채용공고 상세조회 화면으로 이동");
		
		RecruitDto dto = iService.raDetail(Integer.parseInt(seq));		
		model.addAttribute("dto", dto);
		
		List<CodeDto> emp = codeService.selectCodeType("EMP");
		model.addAttribute("emp", emp);
		
		return "recruit/recuitDetail";
	}
	
	@RequestMapping(value = "/recuitInsertForm.do", method = RequestMethod.GET)
	public String recuitInsertForm(Model model) {
		logger.info("[recuitInsertForm] : 채용공고 신규작성 화면으로 이동");
		
		List<CodeDto> emp = codeService.selectCodeType("EMP");
		model.addAttribute("emp", emp);
		
		return "recruit/recuitInsert";
	}
	
}
