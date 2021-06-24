package com.sng.gdrs;

import java.util.Map;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("로그인 페이지로 이동 요청");
		return "user/loginForm";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpSession session) {	
		logger.debug("로그인 테스트 : {}", map);
		UserInfoDto userInfoDto = iuService.umLogin(map);
		if(userInfoDto==null) {
			logger.info("로그인 실패");
			return "redirect:/loginForm.do";
		}else if(userInfoDto.getEmailcheck()=="N") {
			logger.info("로그인 실패");
			return "redirect:/loginForm.do";
		}else{
			logger.info("로그인 성공");
			//로그인에 성공하면 userInfoDto을 session에 담는다
			session.setAttribute("userInfoDto", userInfoDto);
			
			System.out.println(userInfoDto);
			
		}	
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {  
		Object obj = session.getAttribute("userInfoDto");
		if(obj != null) {
			// session에서 userInfoDto를 가져와서 null이 아니라면 remove 한다
			session.removeAttribute("userInfoDto");
		}

		logger.info("로그아웃 요청"+obj);
		
		return "redirect:/index.jsp";
	}
	
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
	
	@RequestMapping(value = "/myInfo.do", method = RequestMethod.GET)
	public String myInfo(HttpSession session, Model model) {
		
		// 세션에서 이메일정보를 가져와 자신의 정보를 조회
		UserInfoDto udto = (UserInfoDto)session.getAttribute("userInfoDto");
		String email = udto.getEmail();
		UserInfoDto dto = iuService.umMyPage(email);
		System.out.println(email+"--------email값확인중 --------------");
		System.out.println(dto+"--------dto값확인중 --------------");
		model.addAttribute("dto" ,dto);
		
		logger.info("회원 정보 조회 페이지 이동 요청 : {}", dto);
		
		return "user/myInfo";
	}
	
	

}