package com.sng.gdrs.model.service;

import java.util.List;
import java.util.Map;

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
	public boolean raWrite(RecruitDto dto) {
		logger.info("[raWrite - {}]", dto);
		return iDao.raWrite(dto) > 0 ? true : false;
	}

	@Override
	public boolean raModify(RecruitDto dto) {
		logger.info("[raModify - {}]", dto);
		return iDao.raModify(dto) > 0 ? true : false;
	}

	@Override
	public boolean raDelFlag(int seq) {
		logger.info("[raDelFlag - {}]", seq);
		return iDao.raDelFlag(seq) > 0 ? true : false;
	}

	@Override
	public boolean raStatus(int seq) {
		logger.info("[raStatus - {}]", seq);
		return iDao.raStatus(seq) > 0 ? true : false;
	}

	@Override
	public List<RecruitDto> raAllList() {
		logger.info("[raAllList]");
		return iDao.raAllList();
	}
	
	@Override
	public List<RecruitDto> raAdminList(Map<String, Object> map) {
		logger.info("[raAdminList]");
		return iDao.raAdminList(map);
	}

	@Override
	public List<RecruitDto> raAdminSearch() {
		logger.info("[raAdminSearch]");
		return iDao.raAdminSearch();
	}

	@Override
	public List<RecruitDto> raUserList(Map<String, Object> map) {
		logger.info("[raUserList]");
		return iDao.raUserList(map);
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

	@Override
	public int raAdminAllCount(Map<String, Object> map) {
		logger.info("[raAdminAllCount]");
		return iDao.raAdminAllCount(map);
	}

	@Override
	public int raUserAllCount(Map<String, Object> map) {
		logger.info("[raUserAllCount]");
		return iDao.raUserAllCount(map);
	}

	@Override
	public List<RecruitDto> raUserListNoPage() {
		logger.info("[raUserListNoPage]");
		return iDao.raUserListNoPage();
	}

}
