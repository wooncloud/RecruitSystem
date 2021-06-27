package com.sng.gdrs.model.dao;

import java.util.Map;

import com.sng.gdrs.dto.UserInfoDto;

public interface IUserInfoDao {

	/**
	 * 로그인
	 * 
	 * @param map
	 * @return
	 */
	public UserInfoDto umLogin(Map<String, Object> map);

	/**
	 * 회원가입
	 * 
	 * @param dto
	 * @return
	 */
	public boolean umSignUp(UserInfoDto dto);

	/**
	 * 이메일 중복검사
	 * 
	 * @param chkEmail
	 * @return
	 */
	public String umDuplicate(String chkEmail);

	/**
	 * 이메일 인증
	 * 
	 * @param map
	 * @return
	 */
	public boolean umConfirm(Map<String, Object> map);

	/**
	 * 내정보확인
	 * 
	 * @param email
	 * @return
	 */
	public UserInfoDto umMyPage(String email);

	/**
	 * 변경전 기존 비밀번호 확인
	 * @param map
	 * @return
	 */
	public UserInfoDto umUserCheck(Map<String, Object> map);
	
	/**
	 * 내정보변경
	 * 
	 * @param dto
	 * @return
	 */
	public boolean umModify(UserInfoDto dto);

	/**
	 * 회원탈퇴
	 * 
	 * @param dto
	 * @return
	 */
	public boolean umDelflag(UserInfoDto dto);

	/**
	 * 아이디로 로그인
	 * 
	 */
	public UserInfoDto umEmailSecurity(String email);

	/**
	 * 비밀번호 확인
	 * 
	 */
	public String umPwSecurity(String email);

}
