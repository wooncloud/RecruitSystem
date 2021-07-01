package com.sng.gdrs;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sng.gdrs.comm.Util;
import com.sng.gdrs.dto.UserInfoDto;
import com.sng.gdrs.model.service.IUserInfoService;

@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserInfoService iuService;

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("[loginForm] : 로그인 페이지로 이동 요청");
		return "user/loginForm";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpSession session, HttpServletResponse response)
			throws IOException {
		logger.debug("[T] 로그인 값전달 테스트 : {}", map);
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();

		UserInfoDto userInfoDto = iuService.umLogin(map);
		if (userInfoDto == null) {
			logger.info("[login] : 로그인 실패");
			out.println("<script>alert('잘못된 아이디 또는 비밀번호 입니다.'); location.href='./loginForm.do'</script>");
			out.flush();

			return null;

		} else {
			logger.info("[login] : 로그인 성공");
			// 로그인에 성공하면 userInfoDto을 session에 담는다
			session.setAttribute("userInfoDto", userInfoDto);
			
			// 유저가 관리자인지 확인후 AUTH session 등록
			if(userInfoDto.getEmailcheck().equalsIgnoreCase("ADMIN")) {
				session.setAttribute("auth", "admin");
			}
			else {
				session.setAttribute("auth", "user");
			}
			
			// 이메일 체크 확인
			String emailChk = userInfoDto.getEmailcheck();
			if(emailChk.equalsIgnoreCase("N")) {
				// 이메일 체크가 되어있지 않으면 이메일 인증 화면으로 이동시킨다.
				Util.PrintWriterMsg(response, "이메일 인증이 되어있지 않습니다.\\n이메일을 인증해 주세요.", "./myInfo.do");
			}
			
			return "redirect:/index.jsp";
		}
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		Object obj = session.getAttribute("userInfoDto");
		if (obj != null) {
			// session에서 userInfoDto를 가져와서 null이 아니라면 remove 한다
			session.removeAttribute("userInfoDto");
			session.removeAttribute("auth");
		}

		logger.info("[logout] : 로그아웃 요청" + obj);

		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/signupAgree.do", method = RequestMethod.GET)
	public String signupAgree() {
		logger.info("[signupAgree] : 회원가입 약관동의 페이지로 이동 요청");

		return "user/signupAgree";
	}

	@RequestMapping(value = "/signupForm.do", method = RequestMethod.GET)
	public String signupForm() {
		logger.info("[signupForm] : 회원가입 페이지로 이동 요청");

		return "user/signupForm";
	}

	@RequestMapping(value = "/duplication.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> duplication(String chkEmail) {
		logger.info("[duplication] : 입력한 중복검사 요청 아이디 : {}", chkEmail);
		
		Map<String, Boolean> map = new HashMap<>();
		boolean isc = false;
		String checkEmail = iuService.umDuplicate(chkEmail);
		
		logger.info("[duplication] : 아이디 중복여부 확인 {}", checkEmail);
		
		// null이 나오면 DB에 없음으로 사용가능
		if (checkEmail == null) {
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
		if (isc) {
			out.println("<script>alert('회원가입을 환영합니다.이메일 인증을 진행해 주세요.'); location.href='./loginForm.do'</script>");
			out.flush();
		} else if (!isc) {
			out.println("<script>alert('회원가입 실패.'); location.href='./signupForm.do'</script>");
			out.flush();
		}

		return null;
	}

	@RequestMapping(value = "/myInfo.do", method = RequestMethod.GET)
	public String myInfo(HttpSession session, Model model) {

		// 세션에서 이메일정보를 가져와 자신의 정보를 조회
		UserInfoDto udto = (UserInfoDto) session.getAttribute("userInfoDto");
		String email = udto.getEmail();
		UserInfoDto dto = iuService.umMyPage(email);
		model.addAttribute("dto", dto);

		logger.info("[myInfo] : 회원 정보 조회 페이지 이동 요청 : {}", dto);

		return "user/myInfo";
	}

	@RequestMapping(value = "/passwordChk.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> pwCheck(String pwCheck, HttpSession session) {
		UserInfoDto uidto = (UserInfoDto) session.getAttribute("userInfoDto");
		logger.debug("[T] : 디티오 확인 : {}", uidto);
		String emailChk = uidto.getEmail();
		logger.debug("[T] : 입력한 이메일 확인 : {}", emailChk);

		Map<String, Object> map = new HashMap<>();
		map.put("email", emailChk);
		map.put("password", pwCheck);

		Map<String, Boolean> bmap = new HashMap<>();
		boolean isc = false;
		UserInfoDto udto = iuService.umUserCheck(map);
		if (udto != null) {
			isc = true;
			logger.info("[passwordChk] : 기존비밀번호 확인 성공 : {}", isc);
		}
		bmap.put("isc", isc);

		return bmap;
	}

	@RequestMapping(value = "/pwChange.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> passwordChange(String pwChange, HttpSession session) {
		UserInfoDto dto = (UserInfoDto) session.getAttribute("userInfoDto");
		dto.setPassword(pwChange);

		Map<String, Boolean> bmap = new HashMap<>();
		boolean isc = false;
		boolean isc2 = iuService.umModify(dto);
		if (isc2 == true) {
			isc = true;
			logger.info("[passwordChange] : 비밀번호 변경 성공 : {}", isc);
		} else {
			logger.info("[passwordChange] : 비밀번호 변경 실패 : {}", isc);
		}
		bmap.put("isc", isc);

		return bmap;
	}

	@RequestMapping(value = "/umDelFlag.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> umDelFlag(HttpSession session) {
		logger.info("[umDelFlag] : 회원 계정 삭제 요청 : ");
		UserInfoDto dto = (UserInfoDto) session.getAttribute("userInfoDto");
		dto.setDelflag("Y");
		Map<String, Boolean> map = new HashMap<>();
		boolean isc = false;
		boolean isc2 = iuService.umDelflag(dto);
		if (isc2 == true) {
			isc = true;
			logger.info("[passwordChange] : 회원계정 삭제 성공 : {}", isc);
		} else {
			logger.info("[passwordChange] : 회원계정 삭제 실패 : {}", isc);
		}
		map.put("isc", isc);

		return map;
	}

	@RequestMapping(value = "/emailChk.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> emailChk(HttpSession session) {
		UserInfoDto dto = (UserInfoDto) session.getAttribute("userInfoDto");
		String email = dto.getEmail();
		logger.info("[T] : 세션의 이메일 확인 테스트 : {}", email);

		String ran = Util.randomVal();
		logger.info("[T] : 난수 발생 테스트 : {}", ran);

		// 메일의 내용을 전송하기 위한 객체 MimeMessage
		MimeMessage message = mailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom("dlrjtjd0615@gmail.com"); // 보내는 사람의 이메일
			messageHelper.setTo(email); // 받을 사람 이메일
			messageHelper.setSubject("GDRS 이메일 인증 메일입니다."); // 메일의 제목
			messageHelper.setText("이메일 인증의 입력란에 다음 인증키를 입력해 주세요.<br> 인증키 : " + ran, true);

			mailSender.send(message);

		} catch (MessagingException e) {

			e.printStackTrace();
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("emailcheck", ran);

		Map<String, Boolean> bmap = new HashMap<>();
		boolean isc = false;
		boolean isc2 = iuService.umConfirm(map);
		if (isc2 == true) {
			isc = true;
			logger.info("[emailChk] : 이메일 인증번호 발행 성공 : {}", isc);
		} else {
			logger.info("[emailChk] : 이메일 인증번호 발행 실패 : {}", isc);
		}
		bmap.put("isc", isc);

		return bmap;
	}

	@RequestMapping(value = "/emailChkOk.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> emailChkOk(HttpSession session, String emailChk) {
		UserInfoDto dto = (UserInfoDto) session.getAttribute("userInfoDto");
		String email = dto.getEmail();
		UserInfoDto uDto = iuService.umEmailSecurity(email);
		String emailcheck = uDto.getEmailcheck();

		Map<String, Boolean> bmap = new HashMap<>();

		if (emailcheck.equals(emailChk)) {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("email", email);
			map.put("emailcheck", "Y");

			boolean isc = false;
			boolean isc2 = iuService.umConfirm(map);
			if (isc2 == true) {
				isc = true;
				logger.info("[emailChkOk] : 이메일 인증 성공 : {}", isc);
			} else {
				logger.info("[emailChkOk] : 이메일 인증 실패 : {}", isc);
			}
			bmap.put("isc", isc);

		}

		return bmap;
	}

}