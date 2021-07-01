package com.sng.gdrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.json.simple.JSONArray;
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
import com.sng.gdrs.dto.AppConfirmJoinDto;
import com.sng.gdrs.dto.CodeDto;
import com.sng.gdrs.dto.Paging;
import com.sng.gdrs.dto.RecruitDto;
import com.sng.gdrs.model.service.IAppConfirmService;
import com.sng.gdrs.model.service.ICodeService;
import com.sng.gdrs.model.service.IRecruitService;

@Controller
public class AppConfirmController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAppConfirmService iaService;
	
	@Autowired IRecruitService irService;
	
	@Autowired
	private ICodeService codeService;

	@RequestMapping(value = "/appConfirmList.do", method = RequestMethod.GET)
	public String applyList(@RequestParam Map<String, Object> param, Model model) {
		logger.info("[applyList] : 관리자 - 지원자 목록 조회 페이지로 이동");
		
		// 페이징 해보는중
		Paging page = new Paging();
		String strIdx = (String)param.get("page");
		if(strIdx == null) {
			strIdx = "1";
		}
		
		int idx = Integer.parseInt(strIdx);
		int allPageCnt = 0;
		
		allPageCnt =iaService.acAllListsCount(param);
		
		Util.defaultPagingSetting(page, allPageCnt); // 페이징 dto 셋팅
		
		page.setPage(idx);
		page.setStartPage(idx);
		page.setEndPage(page.getCountPage());
		
		param.put("first", page.getPage() * page.getCountList() - (page.getCountList() - 1));
		param.put("last", page.getPage() * page.getCountList());
		
		// 볼 수 있는 글의 총 갯수
		List<AppConfirmJoinDto> lists = iaService.acAllList(param);
		
		//공고 목록 조회 옵션
		List<RecruitDto> rlists = irService.raAllList();
		
		List<CodeDto> stp = codeService.selectCodeType("STP");
		List<CodeDto> rst = codeService.selectCodeType("RST");
		JSONArray stpJson = Util.ConvertCodeToJson(stp);
		JSONArray rstJson = Util.ConvertCodeToJson(rst);
		
		model.addAttribute("lists", lists);
		model.addAttribute("page", page);
		model.addAttribute("rlists", rlists);
		model.addAttribute("stp", stp);
		model.addAttribute("rst", rst);
		model.addAttribute("stpJson", stpJson);
		model.addAttribute("rstJson", rstJson);
		
		
		return "admin/applyList";
	}
	
	@RequestMapping(value = "/selAppConfirmList.do", method = RequestMethod.GET)
	public String selApplyList(@RequestParam Map<String, Object> param, Model model, int seq ) {
		logger.info("[selApplyList] : 선택한 공고 지원자 목록 조회 페이지로 이동");
		
		param.put("seq", seq);
		
		// 페이징 해보는중
		Paging page = new Paging();
		String strIdx = (String)param.get("page");
		if(strIdx == null) {
			strIdx = "1";
		}
		
		int idx = Integer.parseInt(strIdx);
		int allPageCnt = 0;
		
		allPageCnt =iaService.acSelAllListsCount(param);
		
		Util.defaultPagingSetting(page, allPageCnt); // 페이징 dto 셋팅
		
		page.setPage(idx);
		page.setStartPage(idx);
		page.setEndPage(page.getCountPage());
		
		param.put("first", page.getPage() * page.getCountList() - (page.getCountList() - 1));
		param.put("last", page.getPage() * page.getCountList());
		
		// 볼 수 있는 글의 총 갯수
		List<AppConfirmJoinDto> lists = iaService.acSelAllList(param);
		
		//공고 목록 조회 옵션
		List<RecruitDto> rlists = irService.raAllList();
		
		List<CodeDto> stp = codeService.selectCodeType("STP");
		List<CodeDto> rst = codeService.selectCodeType("RST");
		JSONArray stpJson = Util.ConvertCodeToJson(stp);
		JSONArray rstJson = Util.ConvertCodeToJson(rst);
		
		model.addAttribute("lists", lists);
		model.addAttribute("page", page);
		model.addAttribute("rlists", rlists);
		model.addAttribute("stp", stp);
		model.addAttribute("rst", rst);
		model.addAttribute("stpJson", stpJson);
		model.addAttribute("rstJson", rstJson);
		
		return "admin/applyList";
	}
	
	@RequestMapping(value = "/acChangeStep.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> acChangeStepBtn(ArrayList<String> chkVal, String steps){
		logger.info("[acMultiBtn] : 선택한 지원자의 진행단계를 선택한 진행 단계로 변경");
		logger.info("[acMultiBtn] : @@@@@@@@@@chkVal@@@@@@@@@@ : {}", chkVal);
		logger.info("[acMultiBtn] : @@@@@@@@@@steps@@@@@@@@@@ : {}", steps);
//		Map<String, Boolean> bmap = new HashMap<>();
//		
//		boolean isc = false;
//		boolean isc2 = iaService.acMultiStep(chkVal);
//		if (isc2 == true) {
//			isc = true;
//			logger.info("[acMultiBtn] : 진행 단계로 변경 성공 : {}", isc);
//		} else {
//			logger.info("[acMultiBtn] : 진행 단계로 변경 실패 : {}", isc);
//		}
//		bmap.put("isc", isc);
		
//		return bmap;
		return null;
	}
	
	
	
	
}
