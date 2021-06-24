package com.sng.gdrs.model.service;

import java.util.List;

import com.sng.gdrs.dto.CodeDto;

public interface ICodeService {
	public List<CodeDto> selectCodeAll();

	public List<CodeDto> selectCodeType(String codetype);

	public CodeDto selectCodeOne(String codeid);
}
