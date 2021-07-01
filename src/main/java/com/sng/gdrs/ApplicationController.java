package com.sng.gdrs;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sng.gdrs.comm.Util;
import com.sng.gdrs.dto.AppDetailDto;
import com.sng.gdrs.dto.ApplicationDto;
import com.sng.gdrs.dto.ApplicationRestDto;
import com.sng.gdrs.dto.CodeDto;
import com.sng.gdrs.dto.RecruitDto;
import com.sng.gdrs.dto.UserInfoDto;
import com.sng.gdrs.model.dao.ICodeDao;
import com.sng.gdrs.model.service.IApplicationService;
import com.sng.gdrs.model.service.ICodeService;
import com.sng.gdrs.model.service.IRecruitService;

@Controller
public class ApplicationController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IApplicationService iAppService;
	@Autowired
	private ICodeService iCodeService;
	@Autowired
	private IRecruitService iRecruitService;
	
	/**
	 * myApplicaion : 내 지원서 화면으로 이동
	 */
	@RequestMapping(value = "/myApplicaion.do", method = RequestMethod.GET)
	public String myApplicaion(Model model, HttpSession session, HttpServletResponse resp) {
		logger.info("[myApplicaion] : 내 지원서 화면으로 이동");
		
		// 세션 데이터
		UserInfoDto userDto =(UserInfoDto)session.getAttribute("userInfoDto");
		AppDetailDto adDto = iAppService.apDetail(userDto.getEmail());
		
		System.out.println(adDto);
		
		// 지원서가 없으면 새로 만들어 저장해둔다.
		if (adDto == null) {
			ApplicationDto apDto = new ApplicationDto();
			apDto.setEmail(userDto.getEmail());
			apDto.setTitle(userDto.getName() + "의 지원서");
			apDto.setIntroduce(userDto.getName() + "의 자기소개서");
			
			if(!iAppService.apSave(apDto)) {
				return "redirect:/error.do";
			}
		}
		
		// 지원가능한 공고 가져오기
		List<RecruitDto> rDto = iRecruitService.raUserListNoPage();
		
		// 코드 가져오기
		List<CodeDto> adbCode = iCodeService.selectCodeType("ADB");
		List<CodeDto> gdsCode = iCodeService.selectCodeType("GDS");
		List<CodeDto> mstCode = iCodeService.selectCodeType("MST");
		List<CodeDto> datCode = iCodeService.selectCodeType("DAT");
		
		model.addAttribute("adDto", adDto);
		model.addAttribute("rDto", rDto);
		model.addAttribute("ADB", adbCode);
		model.addAttribute("GDS", gdsCode);
		model.addAttribute("MST", mstCode);
		model.addAttribute("DAT", datCode);
		
		
		
		// 개인데이터 
		return "application/myApplication";
	}
	
	@RequestMapping(value = "/saveApplicaion.do", method = RequestMethod.POST)
	@ResponseBody
	public String saveApplicaion(@RequestBody ApplicationRestDto dto) {
		logger.info("[saveApplicaion] : 내 지원서 저장");
		
		System.out.println(dto);
		
		
		
		return "test";
	}
}
