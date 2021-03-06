package com.sng.gdrs.model.service;

import java.util.Map;

import com.sng.gdrs.dto.UserInfoDto;

public interface IUserInfoService {

//	로그인
	public UserInfoDto umLogin(Map<String, Object> map);

//	회원가입
	public boolean umSignUp(UserInfoDto dto);

//	이메일 중복검사
	public String umDuplicate(String chkEmail);

//	이메일 인증
	public boolean umConfirm(Map<String, Object> map);

//	내정보확인
	public UserInfoDto umMyPage(String email);

//	변경전 기존 비밀번호 확인
	public UserInfoDto umUserCheck(Map<String, Object> map);

//	내정보변경
	public boolean umModify(UserInfoDto dto);

//	회원탈퇴
	public boolean umDelflag(UserInfoDto dto);

//	아이디로 로그인
	public UserInfoDto umEmailSecurity(String email);

//	비밀번호 확인
	public String umPwSecurity(String email);

}
