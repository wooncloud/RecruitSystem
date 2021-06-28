package com.sng.gdrs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sng.gdrs.dto.AdminInfoDto;
import com.sng.gdrs.model.service.IAdminInfoService;

@Controller
public class AdminController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAdminInfoService iaService;
	
	@RequestMapping(value ="/doyouknowjelly.do", method = RequestMethod.GET )
	public String signupForm() {
		logger.info("[signupForm] : 관리자 계정 생성 페이지로 이동 요청");
		
		return "admin/asignupForm";
	}
	
	@RequestMapping(value = "/asignUp.do", method = RequestMethod.POST)
	public String asignUp(AdminInfoDto dto, HttpServletResponse response) throws IOException {	
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		
		boolean isc = iaService.adminSignUp(dto);
		if(isc) {
			out.println("<script>alert('관리자 계정 생성 완료.'); location.href='./loginForm.do'</script>");
			out.flush();
		}else if(!isc){
			out.println("<script>alert('관리자 계정 생성 실패.'); location.href='./asignUp.do'</script>");
			out.flush();
		}
		
		return null;
	}
	
}
