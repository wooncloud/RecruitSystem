package com.sng.gdrs;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sng.gdrs.dto.ApplicationDto;
import com.sng.gdrs.model.service.IApplicationService;

@RestController
public class ApplicationRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IApplicationService iAppService;
	private final String errorMsg = "저장에 실패했습니다.\n다시 시도하거나 관리자에게 문의하세요..";
	
	@RequestMapping(value = "/application/changeTitle.do", method = RequestMethod.POST)
	public Map<String, String> changeTitle(String seq, String title) {
		logger.info("changeTitle title : {}", title);
		
		ApplicationDto dto = new ApplicationDto();
		dto.setSeq(Integer.parseInt(seq));
		dto.setTitle(title);
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		boolean isc = iAppService.apModify(dto);
		if(isc) {
			retMap.put("state", "success");
			retMap.put("msg", "지원서 제목이 저장 되었습니다.");
			return retMap;			
		}else {
			retMap.put("state", "error");
			retMap.put("msg", errorMsg);
			return retMap;
		}
	}
	
	@RequestMapping(value = "/application/changeIntroduce.do", method = RequestMethod.POST)
	public Map<String, String> changeIntroduce(String seq, String introduce) {
		logger.info("changeIntroduce introduce : {}", introduce);
		
		ApplicationDto dto = new ApplicationDto();
		dto.setSeq(Integer.parseInt(seq));
		dto.setIntroduce(introduce);
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		boolean isc = iAppService.apModify(dto);
		if(isc) {
			retMap.put("state", "success");
			retMap.put("msg", "자기소개서가 저장 되었습니다.");
			return retMap;			
		}else {
			retMap.put("state", "error");
			retMap.put("msg", errorMsg);
			return retMap;
		}
	}
	

	@RequestMapping(value = "/application/changeRecruitSeq.do", method = RequestMethod.POST)
	public Map<String, String> changeRecruitSeq(String seq, String recruitSeq) {
		logger.info("changeRecruitSeq recruitSeq : {}", recruitSeq);
		
		ApplicationDto dto = new ApplicationDto();
		dto.setSeq(Integer.parseInt(seq));
		dto.setRecruit_seq(Integer.parseInt(recruitSeq));
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		boolean isc = iAppService.apModify(dto);
		if(isc) {
			retMap.put("state", "success");
			retMap.put("msg", "선택한 채용공고로 변경 되었습니다.");
			return retMap;			
		}else {
			retMap.put("state", "error");
			retMap.put("msg", errorMsg);
			return retMap;
		}
	}
}
