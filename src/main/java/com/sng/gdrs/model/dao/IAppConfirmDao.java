package com.sng.gdrs.model.dao;

import java.util.List;
import java.util.Map;

import com.sng.gdrs.dto.AppConfirmJoinDto;
import com.sng.gdrs.dto.CareerDto;
import com.sng.gdrs.dto.CertificateDto;
import com.sng.gdrs.dto.EducationDto;
import com.sng.gdrs.dto.ProjectExpDto;

public interface IAppConfirmDao {
	
	/**
	 * 지원자 전체 조회
	 * 
	 * @return
	 */
	public List<AppConfirmJoinDto> acAllList(Map<String, Object> map);

	/**
	 * 지원자 수 조회
	 * 
	 * @param map
	 * @return
	 */
	public int acAllListsCount(Map<String, Object> map);
	
	/**
	 * 지원자가 선택한 공고에 지원서를 제출하면 추가 지원자 리스트에 추가
	 * 
	 * @param map
	 * @return
	 */
	public int acUserInsert(Map<String, Object> map);
	
	/**
	 *  선택한 공고의 지원자를 모두 조회
	 * 
	 * @param map
	 * @return
	 */
	public List<AppConfirmJoinDto> acSelAllList(Map<String, Object> map);
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public int acSelAllListsCount(Map<String, Object> map);
	
	/**
	 * 선택한 지원자 상세보기
	 * 
	 * @param email
	 * @return
	 */
	public AppConfirmJoinDto acAdminDetail(String email);
	
	/**
	 * 지원자 상세보기 경력정보
	 * 
	 * @param seq
	 * @return
	 */
	public CareerDto acAdminDetailCareer(int seq);
	
	/**
	 * 지원자 상세보기 프로젝트 경험
	 * 
	 * @param seq
	 * @return
	 */
	public ProjectExpDto acAdminDetailPjt(int seq);
	
	/**
	 * 지원자 상세보기 자격증, 수상정보
	 * 
	 * @param seq
	 * @return
	 */
	public CertificateDto acAdminDetailCert(int seq);
	
	/**
	 * 지원자 상세보기 학력정보
	 * 
	 * @param seq
	 * @return
	 */
	public EducationDto acAdminDetailEdu(int seq);
	
	/**
	 * 선택한 지원자의 채용 진행단계 변경 
	 * 
	 * @param seq
	 * @return
	 */
	public int acStep(int seq);
	
	/**
	 * 선택한 지원자의 채용 결과 변경
	 * 
	 * @param 
	 * @return
	 */
	public int acResult(int seq);
	
	/**
	 * 관리자가 여러 지원자를 다중 선택하여 일괄적으로 진행 결과를 변경
	 * 
	 * @param seqs
	 * @return
	 */
	public boolean acMultiStep(List<String> seqs);
	
	/**
	 * 관리자가 여러 지원자를 다중 선택하여 일괄적으로 채용 결과를 변경
	 * 
	 * @param seqs
	 * @return
	 */
	public boolean acMultiResult(List<String> seqs);
	
	/**
	 * 관리자가 특정 지원자의 주석을 추가
	 * 
	 * @param seq
	 * @return
	 */
	public int acComment(int seq);

}
