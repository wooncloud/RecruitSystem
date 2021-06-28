package com.sng.gdrs.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sng.gdrs.dto.AdminInfoDto;

@Repository
public class AdminInfoDaoImpl implements IAdminInfoDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean adminSignUp(AdminInfoDto dto) {
		String enPassword = passwordEncoder.encode(dto.getPassword());
		dto.setPassword(enPassword);
		
		int n = sqlSession.insert("com.sng.gdrs.model.dao.IAdminInfoDao.adminSignUp", dto);
		return (n>0)?true:false;
	}

}
