package com.sng.gdrs.model.dao;

import java.util.Map;

import com.sng.gdrs.dto.UserInfoDto;

public interface IUserInfoDao {

//	로그인
	public UserInfoDto umLogin(Map<String, Object> map);
	
//	회원가입
	public boolean umSignUp(UserInfoDto dto);
	
//	이메일 중복검사
	public boolean umDuplicate(String eamil);
	
//	이메일 인증
	public boolean umConfirm(Map<String, Object> map);
	
//	내정보확인
	public UserInfoDto umMyPage(String email);
	
//	내정보변경
	public boolean umModify(Map<String, Object> map);
	
//	회원탈퇴
	public boolean umDelflag(Map<String, Object> map);
	
//	아이디로 로그인
	public UserInfoDto umEmailSecurity(String email);
	
//	비밀번호 확인
	public String umPwSecurity(String email);
	
}
