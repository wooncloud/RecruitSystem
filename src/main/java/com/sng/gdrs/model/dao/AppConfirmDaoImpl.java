package com.sng.gdrs.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sng.gdrs.dto.AppConfirmJoinDto;
import com.sng.gdrs.dto.CareerDto;
import com.sng.gdrs.dto.CertificateDto;
import com.sng.gdrs.dto.EducationDto;
import com.sng.gdrs.dto.ProjectExpDto;


@Repository
public class AppConfirmDaoImpl implements IAppConfirmDao {

	private final String NS = "com.sng.gdrs.model.dao.IAppConfirmDao.";
	
	@Autowired 
	private SqlSessionTemplate sqlSession;

	// 지원자 전체 조회
	@Override
	public List<AppConfirmJoinDto> acAllList(Map<String, Object> map) {
					
		return sqlSession.selectList(NS+"acAllLists", map);
	}
	
	// 지원자 수 조회
	@Override
	public int acAllListsCount(Map<String, Object> map) {
		
		return sqlSession.selectOne(NS+"acAllListsCount", map);
	}

	// 지원자가 선택한 공고에 지원서를 제출하면 추가 지원자 리스트에 추가
	@Override
	public int acUserInsert(Map<String, Object> map) {
		
		return sqlSession.insert(NS+"acUserInsert", map);
	}
	
	// 선택한 공고의 지원자를 모두 조회
	@Override
	public List<AppConfirmJoinDto> acSelAllList(Map<String, Object> map) {

		return sqlSession.selectList(NS+"acSelectList", map);
	}
	
	// 선택한 공고의 지원자 수 조회
	@Override
	public int acSelAllListsCount(Map<String, Object> map) {
	
		return sqlSession.selectOne(NS+"acSelectListsCount", map);
	}

	//----------------------------------------------------------------------------------------------부터 확인 후 끝나면 삭제
	// 선택한 지원자 상세보기
	@Override
	public AppConfirmJoinDto acAdminDetail(String email) {
		 
		return sqlSession.selectOne(NS+"acAdminDetail", email);
	}

	// 지원자 상세보기 경력정보
	@Override
	public CareerDto acAdminDetailCareer(int seq) {
		 
		return sqlSession.selectOne(NS+"acAdminDetailCareer", seq);
	}

	// 지원자 상세보기 프로젝트 경험
	@Override
	public ProjectExpDto acAdminDetailPjt(int seq) {
		 
		return sqlSession.selectOne(NS+"acAdminDetailPjt", seq);
	}

	// 지원자 상세보기 자격증, 수상정보
	@Override
	public CertificateDto acAdminDetailCert(int seq) {
		 
		return sqlSession.selectOne(NS+"acAdminDetailCert", seq);
	}

	// 지원자 상세보기 학력정보
	@Override
	public EducationDto acAdminDetailEdu(int seq) {
		 
		return sqlSession.selectOne(NS+"acAdminDetailEdu", seq);
	}

	// 선택한 지원자의 채용 진행단계 변경
	@Override
	public int acStep(int seq) {
		 
		return sqlSession.update(NS+"acStep", seq);
	}

	// 선택한 지원자의 채용 결과 변경
	@Override
	public int acResult(int seq) {
		 
		return sqlSession.update(NS+"acResult", seq);
	}

	// 관리자가 여러 지원자를 다중 선택하여 일괄적으로 진행 결과를 변경
	@Override
	public boolean acMultiStep(List<String> seqs) {
		 int n = sqlSession.update(NS+"acMultiStep", seqs);
		 return (n>0)?true:false;
	}

	// 관리자가 여러 지원자를 다중 선택하여 일괄적으로 채용 결과를 변경
	@Override
	public boolean acMultiResult(List<String> seqs) {
		 int n = sqlSession.update(NS+"acMultiResult", seqs);
		 return (n>0)?true:false;
	}

	// 관리자가 특정 지원자의 주석을 추가
	@Override
	public int acComment(int seq) {
		 
		return sqlSession.update(NS+"acComment", seq);
	}

	
	
	
}
