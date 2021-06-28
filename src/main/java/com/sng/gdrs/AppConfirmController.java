package com.sng.gdrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppConfirmController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/applyList.do", method = RequestMethod.GET)
	public String applyList() {
		logger.info("[applyList] : 관리자 - 지원자 목록 조회 페이지로 이동");
		
		
		
		return "admin/applyList";
	}
}
