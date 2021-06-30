package com.sng.gdrs.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sng.gdrs.dto.AppConfirmJoinDto;
import com.sng.gdrs.model.dao.IAppConfirmDao;

@Service
public class AppConfirmServiceImpl implements IAppConfirmService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAppConfirmDao dao;

	// 지원자 전체 조회
	@Override
	public List<AppConfirmJoinDto> acAllList(Map<String, Object> map) {
		logger.info("[acUserList]");
		return dao.acAllList(map);
	}

	//지원자 전체 수 조회
	@Override
	public int acAllListsCount(Map<String, Object> map) {
		logger.info("[acAllListsCount]");
		return dao.acAllListsCount(map);
	}

	// 지원자가 선택한 공고에 지원서를 제출하면 추가 지원자 리스트에 추가
	
	// 선택한 공고의 지원자를 모두 조회
	@Override
	public List<AppConfirmJoinDto> acSelAllList(Map<String, Object> map) {
		logger.info("[acSelAllList]");
		return dao.acSelAllList(map);
	}
	
	// 선택한 공고의 지원자 수 조회
	@Override
	public int acSelAllListsCount(Map<String, Object> map) {
		logger.info("[acSelAllListsCount]");
		return dao.acSelAllListsCount(map);
	}
	


	// 선택한 지원자 상세보기

	// 지원자 상세보기 경력정보

	// 지원자 상세보기 프로젝트 경험

	// 지원자 상세보기 자격증, 수상정보

	// 지원자 상세보기 학력정보

	// 선택한 지원자의 채용 진행단계 변경

	// 선택한 지원자의 채용 진행단계 변경

	// 선택한 지원자의 채용 결과 변경

	// 관리자가 여러 지원자를 다중 선택하여 일괄적으로 진행 결과를 변경

	// 관리자가 여러 지원자를 다중 선택하여 일괄적으로 채용 결과를 변경

	// 관리자가 특정 지원자의 주석을 추가

}
