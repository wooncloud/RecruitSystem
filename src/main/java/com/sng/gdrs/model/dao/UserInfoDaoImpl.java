package com.sng.gdrs.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sng.gdrs.dto.UserInfoDto;

@Repository
public class UserInfoDaoImpl implements IUserInfoDao {
	
	private final String NS = "com.sng.gdrs.model.dao.IUserInfoDao.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

//	로그인
	@Override
	public UserInfoDto umLogin(Map<String, Object> map) {
		UserInfoDto dto = null;
		
//		암호화된 password를 Spring Security의 maches를 통해 분석 후 정합여부 판단
		String dbPassword = sqlSession.selectOne(NS+"umPwSecurity", map.get("email"));
		if(passwordEncoder.matches((String)map.get("password"), dbPassword)) {
			dto = sqlSession.selectOne(NS+"umEmailSecurity", map.get("email"));
		}
		
		return dto;
	}

//	회원가입
	@Override
	public boolean umSignUp(UserInfoDto dto) {
		String enPassword = passwordEncoder.encode(dto.getPassword());
		dto.setPassword(enPassword);
		System.out.println("암호화 된 비밀번호 확인 : "+dto.getPassword());
		
		int n = sqlSession.insert(NS+"umSignUp", dto);
		return (n>0)?true:false;
	}

//	이메일 중복검사
	@Override
	public boolean umDuplicate(String email) {
		int n = sqlSession.selectOne(NS+"umDuplicate", email);
		return (n>0)?true:false;
	}
	
//	이메일 인증
	@Override
	public boolean umConfirm(Map<String, Object> map) {
		int n = sqlSession.update(NS+"umConfirm", map);
		return (n>0)?true:false;
	}
	
//	내정보확인
	@Override
	public UserInfoDto umMyPage(String email) {
		
		return sqlSession.selectOne(NS+"umMyPage", email);
	}
	
//	내정보변경
	@Override
	public boolean umModify(Map<String, Object> map) {
		int n = sqlSession.update(NS+"umModify", map);
		return (n>0)?true:false;
	}
	
//	회원탈퇴
	@Override
	public boolean umDelflag(Map<String, Object> map) {
		int n = sqlSession.update(NS+"umDelflag", map);
		return (n>0)?true:false;
	}
	
//	아이디로 로그인
	@Override
	public UserInfoDto umEmailSecurity(String email) {
		
		return sqlSession.selectOne(NS+"umEmailSecurity", email);
	}
	
//	비밀번호 확인
	@Override
	public String umPwSecurity(String email) {
		
		return sqlSession.selectOne(NS+"umPwSecurity", email);
	}

	

	

	

	
}
