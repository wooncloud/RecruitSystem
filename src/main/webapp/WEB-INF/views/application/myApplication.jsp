<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/header.jsp" %>

	<link rel="stylesheet" href="./css/application.css" />
	<div class="container my-5">
		<div class="application-header">
			<div class="card">
				<div class="card-body">
					<div class="header-content">
						<div>
							<div><h4>지원자 : ${adDto.name}</h4></div>
							<div>${adDto.phone}</div>
							<div>${adDto.email}</div>
						</div>
						<div>
							<div class="d-flex-center">
								<input type="button" value="임시저장" class="mx-1 btn btn-warning">
								<input type="button" value="미리보기" class="mx-1 btn btn-secondary">
								<input type="button" value="지원하기" class="mx-1 btn btn-primary">
							</div>
						</div>
						<input type="hidden" name="seq" value="${adDto.aDto.seq}">
					</div>
				</div>
			</div>
		</div>
		<div class="application-section">
			<div class="app-part">
				<div class="app-part-title">
					<h4>지원서 제목</h4>
					<div></div>
				</div>
				<div class="app-part-body">
					<input type="text" class="form-control form-control-lg " value="${adDto.aDto.title}" placeholder="지원서 제목 입력..">
				</div>
			</div>
			<div class="app-part">	
				<div class="app-part-title">
					<h4>경력 정보</h4>
					<div></div>
				</div>
				<div class="app-part-body">
					<div>리스트</div>
				</div>
			</div>
			<div class="app-part">	
				<div class="app-part-title">
					<h4>프로젝트 경험</h4>
					<div></div>
				</div>
				<div class="app-part-body">
					<div>리스트</div>
				</div>
			</div>
			<div class="app-part">	
				<div class="app-part-title">
					<h4>자기소개</h4>
					<div></div>
				</div>
				<div class="app-part-body">
					<textarea name="" cols="30" rows="10" class="form-control">${adDto.aDto.introduce}</textarea>
					<div>글자수 세기</div>
				</div>
			</div>
			<div class="app-part">	
				<div class="app-part-title">
					<h4>포트폴리오</h4>
					<div></div>
				</div>
				<div class="app-part-body">
					<div class="input-group">
						<span class="input-group-text">포트폴리오 URL</span>
						<input type="text" class="form-control" placeholder="포트폴리오 URL을 입력...">
						<span class="input-group-text">첨부파일</span>
						<input type="file" class="form-control" placeholder="포트폴리오 첨부파일을 입력...">
					</div>
				</div>
			</div>
			<div class="app-part">	
				<div class="app-part-title">
					<h4>학력정보</h4>
					<div></div>
				</div>
				<div class="app-part-body">
					
				</div>
			</div>
			<div class="app-part">	
				<div class="app-part-title">
					<h4>자격증 및 수상 정보</h4>
					<div></div>
				</div>
				<div class="app-part-body">
					
				</div>
			</div>
			<div class="app-part">	
				<div class="app-part-title">
					<h4>병역, 보훈, 장애 정보</h4>
					<div></div>
				</div>
				<div class="app-part-body">
					
				</div>
			</div>
		</div>
	</div>

<%@include file="/footer.jsp" %>