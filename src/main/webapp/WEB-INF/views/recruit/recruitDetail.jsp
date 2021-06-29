<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/header.jsp" %>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.min.css" />
	<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
	<script type="text/javascript" src="./js/recruit.js"></script>
	<div class="container my-5">
		<div class="card">
			<div class="card-header d-flex align-items-center justify-content-between">
				<div class="w-25 px-3 text-start">
					<input type="button" class="btn btn-secondary btn-lg" value="목록" onclick="location.href='./recruitList.do'">
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
						<div id="employ" class="ms-3 me-1 badge bg-light text-dark">${dto.employ}</div>
						<div id="status" class="mx-1 badge">${dto.status}</div>
					</div>
				</div>
				<div class="w-25 px-3 text-end">
					<c:if test="${sessionScope.userInfoDto.email ne null && sessionScope.auth eq 'user' }">				
						<input type="button" class="btn btn-success btn-lg" value="지원하기" onclick="">
					</c:if>
				</div>
			</div>
			<div class="card-body">
				<div id="viewer"></div>
			</div>
			<c:if test="${sessionScope.userInfoDto.email ne null && sessionScope.auth eq 'admin'}">
				<div class="card-footer d-flex align-items-center justify-content-between">
					<div>	
						<a href="./recruitModifyForm.do?seq=${dto.seq}" class="mx-1 btn btn-success">공고 수정</a>
						<input type="button" value="공고 삭제" id="delete" class="mx-1 btn btn-danger" onclick="recruitDetail.delete('${dto.seq}')">
					</div>
					<div>
						<a href="#" class="mx-1 btn btn-secondary">해당 공고 지원자 목록 조회</a>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
	<script type="text/javascript">
		window.onload = function(){
			let content = `${dto.content}`;
			recruitDetail.init(content);
		}

		let empCode = ${emp};
		let rcsCode = ${rcs};
	</script>

<%@include file="/footer.jsp" %>