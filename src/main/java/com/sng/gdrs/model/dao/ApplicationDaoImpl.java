package com.sng.gdrs.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sng.gdrs.dto.AppDetailDto;
import com.sng.gdrs.dto.ApplicationDto;
import com.sng.gdrs.dto.CareerDto;
import com.sng.gdrs.dto.CertificateDto;
import com.sng.gdrs.dto.EducationDto;
import com.sng.gdrs.dto.ProjectExpDto;

@Repository
public class ApplicationDaoImpl implements IApplicationDao {

	private final String NS = "com.sng.gdrs.model.dao.IApplicationDao.";
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int apSave(ApplicationDto dto) {
		return sqlSession.insert(NS + "apSave", dto);
	}

	@Override
	public int apModify(ApplicationDto dto) {
		return sqlSession.update(NS + "apModify", dto);
	}

	@Override
	public int apDelete(int seq) {
		return sqlSession.update(NS + "apDelete", seq);
	}

	@Override
	public int apApply(Map<String, Object> map) {
		return sqlSession.update(NS + "apApply", map);
	}

	@Override
	public AppDetailDto apDetail(String email) {
		return sqlSession.selectOne(NS + "apDetail", email);
	}

	@Override
	public int apInsertCareer(CareerDto dto) {
		return sqlSession.insert(NS + "apInsertCareer", dto);
	}

	@Override
	public int apDeleteCareer(int seq) {
		return sqlSession.delete(NS + "apDeleteCareer", seq);
	}

	@Override
	public int apModifyCareer(CareerDto dto) {
		return sqlSession.update(NS + "apModifyCareer", dto);
	}

	@Override
	public int apInsertProject(ProjectExpDto dto) {
		return sqlSession.insert(NS + "apInsertProject", dto);
	}

	@Override
	public int apDeleteProject(int seq) {
		return sqlSession.delete(NS + "apDeleteProject", seq);
	}

	@Override
	public int apModifyProject(ProjectExpDto dto) {
		return sqlSession.update(NS + "apModifyProject", dto);
	}

	@Override
	public int apInsertLicense(CertificateDto dto) {
		return sqlSession.insert(NS + "apInsertLicense", dto);
	}

	@Override
	public int apModifyLicense(int seq) {
		return sqlSession.update(NS + "apModifyLicense", seq);
	}

	@Override
	public int apDeleteLicense(CertificateDto dto) {
		return sqlSession.delete(NS + "apDeleteLicense", dto);
	}

	@Override
	public int apInsertEdu(EducationDto dto) {
		return sqlSession.insert(NS + "apInsertEdu", dto);
	}

	@Override
	public int apModifyEdu(int seq) {
		return sqlSession.update(NS + "apModifyEdu", seq);
	}

	@Override
	public int apDeleteEdu(EducationDto dto) {
		return sqlSession.delete(NS + "apDeleteEdu", dto);
	}

	@Override
	public int apApplyCheck(String email) {
		return sqlSession.selectOne(NS + "apApplyCheck", email);
	}

}
