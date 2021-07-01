package com.sng.gdrs.model.dao;

import java.util.List;
import java.util.Map;

import com.sng.gdrs.dto.RecruitDto;

public interface IRecruitDao {

	/**
	 * 관리자 - 채용공고 작성
	 * 
	 * @param dto
	 * @return
	 */
	public int raWrite(RecruitDto dto);

	/**
	 * 관리자 - 채용공고 수정
	 * 
	 * @param dto
	 * @return
	 */
	public int raModify(RecruitDto dto);

	/**
	 * 관리자 - 채용공고 삭제
	 * 
	 * @param seq
	 * @return
	 */
	public int raDelFlag(int seq);

	/**
	 * 관리자 - 채용공고 상태 수정
	 * 
	 */
	public int raStatus(int seq);

	/**
	 * 관리자 - 채용공고 목록 조회
	 * 
	 */
	public List<RecruitDto> raAdminList(Map<String, Object> map);

	/**
	 * 관리자 - 채용공고 검색
	 * 
	 */
	public List<RecruitDto> raAdminSearch();
	
	/**
	 * 관리자 - 채용공고 전체 글 갯수 조회
	 * @return
	 */
	public int raAdminAllCount(Map<String, Object> map);

	/**
	 * 지원자 - 채용공고 목록 조회
	 * 
	 */
	public List<RecruitDto> raUserList(Map<String, Object> map);

	/**
	 * 지원자 - 채용공고 검색
	 * 
	 */
	public List<RecruitDto> raUserSearch();

	/**
	 * 채용공고 상세 조회
	 * 
	 */
	public RecruitDto raDetail(int seq);

	/**
	 * 지원자 채용공고 글 갯수 조회
	 * @return
	 */
	public int raUserAllCount(Map<String, Object> map);
	
	public List<RecruitDto> raUserListNoPage();
}
