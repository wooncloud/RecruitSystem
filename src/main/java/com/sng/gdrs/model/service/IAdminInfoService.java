package com.sng.gdrs.model.service;

import com.sng.gdrs.dto.AdminInfoDto;

public interface IAdminInfoService {
	
	//회원가입
	public boolean adminSignUp(AdminInfoDto dto);

}
