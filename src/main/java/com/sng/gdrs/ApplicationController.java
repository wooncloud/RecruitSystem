package com.sng.gdrs;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sng.gdrs.comm.Util;
import com.sng.gdrs.dto.AppDetailDto;
import com.sng.gdrs.dto.ApplicationDto;
import com.sng.gdrs.dto.UserInfoDto;
import com.sng.gdrs.model.service.IApplicationService;

@Controller
public class ApplicationController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IApplicationService iAppService;
	
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
		
		model.addAttribute("adDto", adDto);
		
		
		// 개인데이터 
		return "application/myApplication";
	}
}
