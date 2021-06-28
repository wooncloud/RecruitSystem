package com.sng.gdrs.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sng.gdrs.dto.AdminInfoDto;
import com.sng.gdrs.model.dao.IAdminInfoDao;

@Service
public class AdminInfoServiceImpl implements IAdminInfoService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAdminInfoDao aDao;

	// 관리자 회원가입
	@Override
	public boolean adminSignUp(AdminInfoDto dto) {
		logger.info("adminSignUp 회원가입 : {} ", dto);
		return aDao.adminSignUp(dto);
	}

}
