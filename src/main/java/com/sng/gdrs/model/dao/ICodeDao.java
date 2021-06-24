package com.sng.gdrs.model.dao;

import java.util.List;

import com.sng.gdrs.dto.CodeDto;

public interface ICodeDao {
	public List<CodeDto> selectCodeAll();

	public List<CodeDto> selectCodeType(String codetype);

	public CodeDto selectCodeOne(String codeid);
}
