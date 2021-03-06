package com.sng.gdrs.model.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sng.gdrs.dto.UserInfoDto;
import com.sng.gdrs.model.dao.IUserInfoDao;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserInfoDao iDao;

//	로그인
	@Override
	public UserInfoDto umLogin(Map<String, Object> map) {
		logger.info("umLogin 로그인 : {} ", map);
		return iDao.umLogin(map);
	}

//	회원가입
	@Override
	public boolean umSignUp(UserInfoDto dto) {
		logger.info("umSignUp 회원가입 : {} ", dto);
		return iDao.umSignUp(dto);
	}

//	이메일 중복검사
	@Override
	public String umDuplicate(String chkEamil) {
		logger.info("umDuplicate 이메일 중복 검사 : {} ", chkEamil);
		return iDao.umDuplicate(chkEamil);
	}

//	이메일 인증
	@Override
	public boolean umConfirm(Map<String, Object> map) {
		logger.info("umConfirm 이메일 인증 : {}", map);
		return iDao.umConfirm(map);
	}

//	내정보확인
	@Override
	public UserInfoDto umMyPage(String email) {
		logger.info("umMyPage 내정보 확인 : {}", email);
		return iDao.umMyPage(email);
	}

//	변경전 기존 비밀번호 확인
//	로그인
	@Override
	public UserInfoDto umUserCheck(Map<String, Object> map) {
		logger.info("umLogin 로그인 : {} ", map);
		return iDao.umLogin(map);
	}

//	내정보변경
	@Override
	public boolean umModify(UserInfoDto dto) {
		logger.info("umModify 지원자 정보 변경 : {}", dto);
		return iDao.umModify(dto);
	}

//	회원탈퇴
	@Override
	public boolean umDelflag(UserInfoDto dto) {
		logger.info("umDelflag 지원자 회원 탈퇴 : {}", dto);
		return iDao.umDelflag(dto);
	}

//	아이디로 로그인
	@Override
	public UserInfoDto umEmailSecurity(String email) {
		logger.info("umEmailSecurity 이메일로 로그인 : {}", email);
		return iDao.umEmailSecurity(email);
	}

//	비밀번호 확인
	@Override
	public String umPwSecurity(String email) {
		logger.info("umPwSecurity 비밀번호 확인 : {}", email);
		return iDao.umPwSecurity(email);
	}

}
