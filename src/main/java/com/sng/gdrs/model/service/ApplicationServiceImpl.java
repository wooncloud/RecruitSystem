package com.sng.gdrs.model.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sng.gdrs.dto.AppDetailDto;
import com.sng.gdrs.dto.ApplicationDto;
import com.sng.gdrs.dto.CareerDto;
import com.sng.gdrs.dto.CertificateDto;
import com.sng.gdrs.dto.EducationDto;
import com.sng.gdrs.dto.ProjectExpDto;
import com.sng.gdrs.model.dao.IApplicationDao;

@Service
public class ApplicationServiceImpl implements IApplicationService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IApplicationDao dao;
	
	@Override
	public boolean apSave(ApplicationDto dto) {
		logger.info("[apSave - {}]", dto);
		return dao.apSave(dto) > 0 ? true : false;
	}

	@Override
	public boolean apModify(ApplicationDto dto) {
		logger.info("[apModify - {}]", dto);
		return dao.apModify(dto) > 0 ? true : false;
	}

	@Override
	public boolean apDelete(int seq) {
		logger.info("[apDelete - {}]", seq);
		return dao.apDelete(seq) > 0 ? true : false;
	}

	@Override
	public boolean apApply(Map<String, Object> map) {
		logger.info("[apApply - {}]", map);
		return dao.apApply(map) > 0 ? true : false;
	}

	@Override
	public AppDetailDto apDetail(String email) {
		logger.info("[apDetail - {}]", email);
		return dao.apDetail(email);
	}

	@Override
	public boolean apInsertCareer(CareerDto dto) {
		logger.info("[apInsertCareer - {}]", dto);
		return dao.apInsertCareer(dto) > 0 ? true : false;
	}

	@Override
	public boolean apDeleteCareer(int seq) {
		logger.info("[apDeleteCareer - {}]", seq);
		return dao.apDeleteCareer(seq) > 0 ? true : false;
	}

	@Override
	public boolean apModifyCareer(CareerDto dto) {
		logger.info("[apModifyCareer - {}]", dto);
		return dao.apModifyCareer(dto) > 0 ? true : false;
	}

	@Override
	public boolean apInsertProject(ProjectExpDto dto) {
		logger.info("[apInsertProject - {}]", dto);
		return dao.apInsertProject(dto) > 0 ? true : false;
	}

	@Override
	public boolean apDeleteProject(int seq) {
		logger.info("[apDeleteProject - {}]", seq);
		return dao.apDeleteProject(seq) > 0 ? true : false;
	}

	@Override
	public boolean apModifyProject(ProjectExpDto dto) {
		logger.info("[apModifyProject - {}]", dto);
		return dao.apModifyProject(dto) > 0 ? true : false;
	}

	@Override
	public boolean apInsertLicense(CertificateDto dto) {
		logger.info("[apInsertLicense - {}]", dto);
		return dao.apInsertLicense(dto) > 0 ? true : false;
	}

	@Override
	public boolean apModifyLicense(int seq) {
		logger.info("[apModifyLicense - {}]", seq);
		return dao.apModifyLicense(seq) > 0 ? true : false;
	}

	@Override
	public boolean apDeleteLicense(CertificateDto dto) {
		logger.info("[apDeleteLicense - {}]", dto);
		return dao.apDeleteLicense(dto) > 0 ? true : false;
	}

	@Override
	public boolean apInsertEdu(EducationDto dto) {
		logger.info("[apInsertEdu - {}]", dto);
		return dao.apInsertEdu(dto) > 0 ? true : false;
	}

	@Override
	public boolean apModifyEdu(int seq) {
		logger.info("[apModifyEdu - {}]", seq);
		return dao.apModifyEdu(seq) > 0 ? true : false;
	}

	@Override
	public boolean apDeleteEdu(EducationDto dto) {
		logger.info("[apDeleteEdu - {}]", dto);
		return dao.apDeleteEdu(dto) > 0 ? true : false;
	}

	@Override
	public int apApplyCheck(String email) {
		logger.info("[apApplyCheck - {}]", email);
		return dao.apApplyCheck(email);
	}

}
