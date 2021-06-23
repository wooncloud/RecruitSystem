package com.sng.gdrs;

import java.util.HashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sng.gdrs.dto.UserInfoDto;
import com.sng.gdrs.model.service.IUserInfoService;

@Controller
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserInfoService iuService;
	
	@RequestMapping(value ="/signupForm.do", method = RequestMethod.GET )
	public String signupForm() {
		logger.info("회원가입 페이지로 이동 요청");
		
		return "user/signupForm";
	}
	
//	테스트 끝나면 약관동의 넣고 테스트 에서 회원가입으로 변경예정
	
	@RequestMapping(value = "/signUpTest.do", method = RequestMethod.POST)
	public String signUpTest(UserInfoDto dto) {
		logger.info("회원가입 값 확인 : {}", dto);
		boolean isc = iuService.umSignUp(dto);
		
		return isc?"redirect:/loginForm.do":"redirect:/signupForm.do";
	}
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("로그인 페이지로 이동 요청");
		return "user/loginForm";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, Model model) {	
		logger.info("로그인 테스트 : {}", map);
		UserInfoDto uDto = iuService.umLogin(map);
		if(uDto==null) {
			logger.info("로그인 실패");
		}else {
			logger.info("로그인 성공");
	
			model.addAttribute("uDto" ,uDto);
			
		}
		
		return "redirect:/loginForm.do";
	}

}