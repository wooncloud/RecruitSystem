package com.sng.gdrs.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sng.gdrs.model.dao.IAppConfirmDao;

@Service
public class AppConfirmServiceImpl implements IAppConfirmService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAppConfirmDao dao;

}
