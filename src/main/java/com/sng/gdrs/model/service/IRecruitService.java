package com.sng.gdrs.model.service;

import java.util.List;
import java.util.Map;

import com.sng.gdrs.dto.RecruitDto;

public interface IRecruitService {

	/**
	 * 관리자 - 채용공고 작성
	 * 
	 * @param dto
	 * @return
	 */
	public boolean raWrite(RecruitDto dto);

	/**
	 * 관리자 - 채용공고 수정
	 * 
	 * @param dto
	 * @return
	 */
	public boolean raModify(RecruitDto dto);

	/**
	 * 관리자 - 채용공고 삭제
	 * 
	 * @param seq
	 * @return
	 */
	public boolean raDelFlag(int seq);

	/**
	 * 관리자 - 채용공고 상태 수정
	 * 
	 * @param seq
	 * @return
	 */
	public boolean raStatus(int seq);

	/**
	 * 채용공고 목록 전체 조회(페이징x)
	 * 
	 * @return
	 */
	public List<RecruitDto> raAllList();
	
	/**
	 * 관리자 - 채용공고 목록 조회
	 * 
	 * @return
	 */
	public List<RecruitDto> raAdminList(Map<String, Object> map);

	/**
	 * 관리자 - 채용공고 검색
	 * 
	 * @return
	 */
	public List<RecruitDto> raAdminSearch();

	/**
	 * 지원자 - 채용공고 목록 조회
	 * 
	 * @return
	 */
	public List<RecruitDto> raUserList(Map<String, Object> map);

	/**
	 * 지원자 - 채용공고 검색
	 * 
	 * @return
	 */
	public List<RecruitDto> raUserSearch();

	/**
	 * 채용공고 상세 조회
	 * 
	 * @param seq
	 * @return
	 */
	public RecruitDto raDetail(int seq);

	/**
	 * 관리자 - 채용공고 전체 글 갯수 조회
	 * 
	 * @return
	 */
	public int raAdminAllCount(Map<String, Object> map);

	/**
	 * 지원자 채용공고 글 갯수 조회
	 * 
	 * @return
	 */
	public int raUserAllCount(Map<String, Object> map);
}
