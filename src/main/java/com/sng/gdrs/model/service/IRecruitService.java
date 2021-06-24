package com.sng.gdrs.model.service;

import java.util.List;

import com.sng.gdrs.dto.RecruitDto;

public interface IRecruitService {

//	관리자 - 채용공고 작성
	public int raWrite(RecruitDto dto);

//	관리자 - 채용공고 수정
	public int raModify(RecruitDto dto);

//	관리자 - 채용공고 삭제
	public int raDelFlag(int seq);

//	관리자 - 채용공고 상태 수정
	public int raStatus(int seq);

//	관리자 - 채용공고 목록 조회
	public List<RecruitDto> raAdminList();

//	관리자 -  채용공고 검색
	public List<RecruitDto> raAdminSearch();

//	지원자 - 채용공고 목록 조회
	public List<RecruitDto> raUserList();

//	지원자 - 채용공고 검색
	public List<RecruitDto> raUserSearch();

//	채용공고 상세 조회
	public RecruitDto raDetail(int seq);
}
