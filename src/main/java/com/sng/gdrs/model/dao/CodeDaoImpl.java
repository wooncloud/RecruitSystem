package com.sng.gdrs.model.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sng.gdrs.dto.CodeDto;

@Repository
public class CodeDaoImpl implements ICodeDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ICodeDao iDao;
	
	@Override
	public List<CodeDto> selectCodeAll() {
		logger.info("selectCodeAll 코드전체 조회");
		return iDao.selectCodeAll();
	}

	@Override
	public List<CodeDto> selectCodeType(String codetype) {
		logger.info("selectCodeType 코드 카테고리 조회 : {}", codetype);
		return iDao.selectCodeType(codetype);
	}

	@Override
	public CodeDto selectCodeOne(String codeid) {
		logger.info("selectCodeOne 코드 아이디로 조회 : {}", codeid);
		return iDao.selectCodeOne(codeid);
	}

}
