package com.sng.gdrs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sng.gdrs.dto.AppConfirmDto;
import com.sng.gdrs.model.service.IAppConfirmService;

@Controller
public class AppConfirmController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAppConfirmService iaService;

	@RequestMapping(value = "/applyList.do", method = RequestMethod.GET)
	public String applyList(Model model) {
		logger.info("[applyList] : 관리자 - 지원자 목록 조회 페이지로 이동");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<AppConfirmDto> AppConfirm = iaService.acAllList();
		model.addAttribute("AppConfirm", AppConfirm);
		
		return "admin/applyList";
	}
}
