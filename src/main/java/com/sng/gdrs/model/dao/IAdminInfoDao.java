package com.sng.gdrs.model.dao;

import com.sng.gdrs.dto.AdminInfoDto;

public interface IAdminInfoDao {

	/**
	 * 회원가입
	 * 
	 * @param dto
	 * @return
	 */
	public boolean adminSignUp(AdminInfoDto dto);
	
}
