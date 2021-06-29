package com.sng.gdrs.model.service;

import java.util.List;

import com.sng.gdrs.dto.AppConfirmDto;

public interface IAppConfirmService {

	// 지원자 전체 조회
	public List<AppConfirmDto> acAllList();

	// 지원자가 선택한 공고에 지원서를 제출하면 추가 지원자 리스트에 추가

	// 선택한 공고의 지원자를 모두 조회

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
