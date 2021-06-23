package com.sng.gdrs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {
	
	@RequestMapping(value = "/error404.do", method = RequestMethod.GET)
	public String error404() {
		return "error/Error404";
	}
	
	@RequestMapping(value = "/error500.do", method = RequestMethod.GET)
	public String error500() {
		return "error/Error500";
	}
	
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public String error() {
		return "error/Error";
	}
}
