package com.sng.gdrs.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sng.gdrs.dto.CodeDto;

@Service
public class CodeServiceImpl implements ICodeService {

	private final String NS = "com.sng.gdrs.model.dao.ICodeDao.";
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CodeDto> selectCodeAll() {
		return sqlSession.selectList(NS + "selectCodeAll");
	}

	@Override
	public List<CodeDto> selectCodeType(String codetype) {
		return sqlSession.selectList(NS + "selectCodeType", codetype);
	}

	@Override
	public CodeDto selectCodeOne(String codeid) {
		return sqlSession.selectOne(NS + "selectCodeOne", codeid);
	}

}
