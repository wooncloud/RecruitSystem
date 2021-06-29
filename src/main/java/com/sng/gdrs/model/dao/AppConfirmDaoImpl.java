package com.sng.gdrs.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppConfirmDaoImpl implements IAppConfirmDao {

	private final String NS = "com.sng.gdrs.model.dao.IAppConfirmDao.";
	
	@Autowired 
	private SqlSessionTemplate sqlSession;
	
}
