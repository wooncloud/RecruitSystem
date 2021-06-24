package com.sng.gdrs.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sng.gdrs.dto.RecruitDto;
import com.sng.gdrs.model.dao.IRecruitDao;

@Service
public class RecruitService implements IRecruitService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRecruitDao iDao;

	@Override
	public int raWrite(RecruitDto dto) {
		logger.info("[raWrite - {}]", dto);
		return iDao.raWrite(dto);
	}

	@Override
	public int raModify(RecruitDto dto) {
		logger.info("[raModify - {}]", dto);
		return iDao.raModify(dto);
	}

	@Override
	public int raDelFlag(int seq) {
		logger.info("[raDelFlag - {}]", seq);
		return iDao.raDelFlag(seq);
	}

	@Override
	public int raStatus(int seq) {
		logger.info("[raStatus - {}]", seq);
		return iDao.raStatus(seq);
	}

	@Override
	public List<RecruitDto> raAdminList() {
		logger.info("[raAdminList]");
		return iDao.raAdminList();
	}

	@Override
	public List<RecruitDto> raAdminSearch() {
		logger.info("[raAdminSearch]");
		return iDao.raAdminSearch();
	}

	@Override
	public List<RecruitDto> raUserList() {
		logger.info("[raUserList]");
		return iDao.raUserList();
	}

	@Override
	public List<RecruitDto> raUserSearch() {
		logger.info("[raUserSearch]");
		return iDao.raUserSearch();
	}

	@Override
	public RecruitDto raDetail(int seq) {
		logger.info("[raDetail - {}]", seq);
		return iDao.raDetail(seq);
	}

}