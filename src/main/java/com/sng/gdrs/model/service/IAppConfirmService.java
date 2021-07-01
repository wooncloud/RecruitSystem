package com.sng.gdrs.model.service;

import java.util.List;
import java.util.Map;

import com.sng.gdrs.dto.AppConfirmJoinDto;
import com.sng.gdrs.dto.CareerDto;
import com.sng.gdrs.dto.CertificateDto;
import com.sng.gdrs.dto.EducationDto;
import com.sng.gdrs.dto.ProjectExpDto;


public interface IAppConfirmService {

	// 지원자 전체 조회
	public List<AppConfirmJoinDto> acAllList(Map<String, Object> map);
	// 지원자 전체 수 조회
	public int acAllListsCount(Map<String, Object> map);

	// 지원자가 선택한 공고에 지원서를 제출하면 추가 지원자 리스트에 추가
	public int acUserInsert(Map<String, Object> map);

	// 선택한 공고의 지원자를 모두 조회
	public List<AppConfirmJoinDto> acSelAllList(Map<String, Object> map);
	
	//선택한 공고의 지원자 수 조회
	public int acSelAllListsCount(Map<String, Object> map);

	// 선택한 지원자 상세보기
	public AppConfirmJoinDto acAdminDetail(String email);

	// 지원자 상세보기 경력정보
	public CareerDto acAdminDetailCareer(int seq);

	// 지원자 상세보기 프로젝트 경험
	public ProjectExpDto acAdminDetailPjt(int seq);

	// 지원자 상세보기 자격증, 수상정보
	public CertificateDto acAdminDetailCert(int seq);

	// 지원자 상세보기 학력정보
	public EducationDto acAdminDetailEdu(int seq);

	// 선택한 지원자의 채용 진행단계 변경
	public int acStep(int seq);

	// 선택한 지원자의 채용 결과 변경
	public int acResult(int seq);

	// 관리자가 여러 지원자를 다중 선택하여 일괄적으로 진행 결과를 변경
	public boolean acMultiStep(List<String> seqs);

	// 관리자가 여러 지원자를 다중 선택하여 일괄적으로 채용 결과를 변경
	public boolean acMultiResult(List<String> seqs);

	// 관리자가 특정 지원자의 주석을 추가
	public int acComment(int seq);
	
}
