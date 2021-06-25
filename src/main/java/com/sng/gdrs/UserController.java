package com.sng.gdrs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sng.gdrs.dto.UserInfoDto;
import com.sng.gdrs.model.service.IUserInfoService;

@Controller
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserInfoService iuService;
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("[loginForm] : 로그인 페이지로 이동 요청");
		return "user/loginForm";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpSession session, HttpServletResponse response) throws IOException {	
		logger.debug("[T] 로그인 값전달 테스트 : {}", map);
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
				
		UserInfoDto userInfoDto = iuService.umLogin(map);
		if(userInfoDto==null) {
			logger.info("[login] : 로그인 실패");
			out.println("<script>alert('잘못된 아이디 또는 비밀번호 입니다.'); location.href='./loginForm.do'</script>");
			out.flush();
			
//			return "redirect:/loginForm.do";
			return null;
			
		}else{
			logger.info("[login] : 로그인 성공");
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

		logger.info("[logout] : 로그아웃 요청"+obj);
		
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value ="/signupAgree.do", method = RequestMethod.GET )
	public String signupAgree() {
		logger.info("[signupAgree] : 회원가입 약관동의 페이지로 이동 요청");
		
		return "user/signupAgree";
	}
	
	@RequestMapping(value ="/signupForm.do", method = RequestMethod.GET )
	public String signupForm() {
		logger.info("[signupForm] : 회원가입 페이지로 이동 요청");
		
		return "user/signupForm";
	}
	
	@RequestMapping(value = "/duplication.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> duplication(String chkEmail) {
		logger.info("[test] : 입력한 중복검사 요청 아이디 : {}", chkEmail);
		Map<String, Boolean> map = new HashMap<>();
		boolean isc = false;
		String checkEmail = iuService.umDuplicate(chkEmail);
		logger.info("[duplication] : 아이디 중복여부 확인 {}", checkEmail);
		if(checkEmail==null) {
			isc = true;
		}
		map.put("isc", isc);
		return map;
	}
	
	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	public String signUpTest(UserInfoDto dto, HttpServletResponse response) throws IOException {
		logger.debug("[T] 회원가입 값 확인 : {}", dto);
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		
		boolean isc = iuService.umSignUp(dto);
		if(isc) {
			out.println("<script>alert('회원가입을 환영합니다.이메일 인증을 진행해 주세요.'); location.href='./loginForm.do'</script>");
			out.flush();
		}else if(!isc){
			out.println("<script>alert('회원가입 실패.'); location.href='./signupForm.do'</script>");
			out.flush();
		}
		
		return null;
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
		
		logger.info("[myInfo] : 회원 정보 조회 페이지 이동 요청 : {}", dto);
		
		return "user/myInfo";
	}
	
	@RequestMapping(value = "/umDelFlag.do", method = RequestMethod.POST)
	public String umDelFlag(UserInfoDto udto, HttpSession session, HttpServletResponse response)  {
					

		
		
		return null;
	}
	
	

}