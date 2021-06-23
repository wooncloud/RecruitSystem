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
	 * @param eamil
	 * @return
	 */
	public boolean umDuplicate(String eamil);

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
	 * 내정보변경
	 * 
	 * @param map
	 * @return
	 */
	public boolean umModify(Map<String, Object> map);

	/**
	 * 회원탈퇴
	 * 
	 * @param map
	 * @return
	 */
	public boolean umDelflag(Map<String, Object> map);

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
