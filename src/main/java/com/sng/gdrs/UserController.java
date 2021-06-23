package com.sng.gdrs;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sng.gdrs.dto.UserInfoDto;
import com.sng.gdrs.model.service.IUserInfoService;

@Controller
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserInfoService iuService;
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("로그인 페이지로 이동 확인");
		return "user/loginForm";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(Model model, Map<String, Object> map) {
		logger.info("로그인 테스트 : {}", map);
		UserInfoDto uDto = iuService.umLogin(map);
		if(uDto==null) {
			System.out.println("로그인실패");
		}else {
			logger.info("로그인 값 : {}", uDto);;
			model.addAttribute("uDto" ,uDto);
	
		}
		
		return null;
	}

}
