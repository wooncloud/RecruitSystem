package com.sng.gdrs.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sng.gdrs.dto.RecruitDto;

@Repository
public class RecruitDaoImpl implements IRecruitDao {

	private final String NS = "com.sng.gdrs.model.dao.IRecruitDao.";
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int raWrite(RecruitDto dto) {
		return sqlSession.insert(NS + "raWrite", dto);
	}

	@Override
	public int raModify(RecruitDto dto) {
		return sqlSession.update(NS + "raModify", dto);
	}

	@Override
	public int raDelFlag(int seq) {
		return sqlSession.update(NS + "raDelFlag", seq);
	}

	@Override
	public int raStatus(int seq) {
		return sqlSession.update(NS + "raStatus", seq);
	}

	@Override
	public List<RecruitDto> raAdminList(Map<String, Object> map) {
		return sqlSession.selectList(NS + "raAdminList", map);
	}

	@Override
	public List<RecruitDto> raAdminSearch() {
		return sqlSession.selectList(NS + "raAdminSearch");
	}

	@Override
	public List<RecruitDto> raUserList(Map<String, Object> map) {
		return sqlSession.selectList(NS + "raUserList", map);
	}

	@Override
	public List<RecruitDto> raUserSearch() {
		return sqlSession.selectList(NS + "raUserSearch");
	}

	@Override
	public RecruitDto raDetail(int seq) {
		return sqlSession.selectOne(NS + "raDetail", seq);
	}

	@Override
	public int raAdminAllCount(Map<String, Object> map) {
		return sqlSession.selectOne(NS + "raAdminAllCount", map);
	}

	@Override
	public int raUserAllCount(Map<String, Object> map) {
		return sqlSession.selectOne(NS + "raUserAllCount", map);
	}

}
