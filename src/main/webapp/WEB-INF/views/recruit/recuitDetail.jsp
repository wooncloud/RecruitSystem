<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/header.jsp" %>

	<div class="container my-5">
		<div class="card">
			<div class="card-header d-flex align-items-center justify-content-between">
				<div class="w-25 px-3 text-start">
					<input type="button" class="btn btn-secondary btn-lg" value="목록" onclick="history.back(-1)">
				</div>
				<div class="w-75">
					<div class="text-center fw-bold">
						<h3>${dto.title}</h3>
					</div>
					<div class="d-flex align-items-center justify-content-center">
						<div class="mx-4">
							모집기간 : 
							<fmt:formatDate value="${dto.startterm}" pattern="yyyy. MM. dd."/>
							~
							<c:choose>
								<c:when test="${dto.endterm eq null}">
									<!-- 종료 일자가 없다면 '채용시 마감' 이라는 글을 넣어준다. -->
									<span>&nbsp;채용시 마감</span>
								</c:when>
								<c:otherwise>
									<!-- 종료 일자가 있다면 마감 일자를 넣어줌. -->
									<fmt:formatDate value="${dto.endterm}" pattern="yyyy. MM. dd." />
								</c:otherwise>
							</c:choose>
						</div>
						<div class="mx-4 badge bg-secondary">${dto.employ}</div>
					</div>
				</div>
				<div class="w-25 px-3 text-end">
					<input type="button" class="btn btn-success btn-lg" value="지원하기" onclick="">
				</div>
			</div>
			<div class="card-body">
				${dto.content}
			</div>
			<div class="card-footer d-flex">
				<input type="button" class="mx-1 btn btn-success" value="공고 수정">
				<input type="button" class="mx-1 btn btn-secondary" value="해당 공고 지원자 목록 조회">
				<input type="button" class="mx-1 btn btn-danger" value="공고 삭제">
			</div>
		</div>
	</div>

<%@include file="/footer.jsp" %>