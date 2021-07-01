package com.sng.gdrs.model.service;

import java.util.Map;

import com.sng.gdrs.dto.AppDetailDto;
import com.sng.gdrs.dto.ApplicationDto;
import com.sng.gdrs.dto.CareerDto;
import com.sng.gdrs.dto.CertificateDto;
import com.sng.gdrs.dto.EducationDto;
import com.sng.gdrs.dto.ProjectExpDto;

public interface IApplicationService {
	/**
	 * 지원서 저장 - 지원자가 자신의 작성중인 지원서를 저장
	 */
	public boolean apSave(ApplicationDto dto);

	/**
	 * 지원서 수정 - 지원자가 자신이 저장했던 지원서를 수정
	 */
	public boolean apModify(ApplicationDto dto);

	/**
	 * 지원서 삭제 - 지원자가 자신이 저장했던 지원서를 삭제
	 */
	public boolean apDelete(int seq);

	/**
	 * 지원서 제출 - 지원자가 자신이 저장한 지원서를 제출
	 */
	public boolean apApply(Map<String, Object> map);

	/**
	 * 내 지원서 조회 - 지원자가 자신이 저장하거나 제출한 지원서를 조회
	 */
	public AppDetailDto apDetail(String email);

	/**
	 * 경력정보 추가 - 지원자가 자신의 경력 정보를 추가
	 */
	public boolean apInsertCareer(CareerDto dto);

	/**
	 * 경력정보 삭제 - 지원자가 자신의 경력정보를 삭제
	 */
	public boolean apDeleteCareer(int seq);

	/**
	 * 경력정보 수정 - 지원자가 자신의 경력정보를 수정
	 */
	public boolean apModifyCareer(CareerDto dto);

	/**
	 * 프로젝트경험 추가 - 지원자가 자신의 프로젝트 경험을 추가
	 */
	public boolean apInsertProject(ProjectExpDto dto);

	/**
	 * 프로젝트경험 삭제 - 지원자가 자신의 프로젝트 경험을 삭제
	 */
	public boolean apDeleteProject(int seq);

	/**
	 * 프로젝트경험 수정 - 지원자가 자신의 프로젝트 경험을 수정
	 */
	public boolean apModifyProject(ProjectExpDto dto);

	/**
	 * 자격증, 수상정보 추가 - 지원자가 자신의 자격증 및 수상정보를 추가
	 */
	public boolean apInsertLicense(CertificateDto dto);

	/**
	 * 자격증, 수상정보 수정 - 지원자가 자신의 자격증 및 수상정보를 수정
	 */
	public boolean apModifyLicense(int seq);

	/**
	 * 자격증, 수상정보 삭제 - 지원자가 자신의 자격증 및 수상정보를 삭제
	 */
	public boolean apDeleteLicense(CertificateDto dto);

	/**
	 * 학력정보 추가 - 지원자가 자신의 학력정보 추가
	 */
	public boolean apInsertEdu(EducationDto dto);

	/**
	 * 학력정보 수정 - 지원자가 자신의 학력정보 수정
	 */
	public boolean apModifyEdu(int seq);

	/**
	 * 학력정보 삭제 - 지원자가 자신의 학력정보 삭제
	 */
	public boolean apDeleteEdu(EducationDto dto);

	/**
	 * 지원서 제출 여부 조회 - 지원자가 지원서를 제출하기 전에 지원 여부를 확인
	 */
	public int apApplyCheck(String email);
}
