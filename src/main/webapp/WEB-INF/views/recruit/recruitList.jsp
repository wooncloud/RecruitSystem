<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/header.jsp" %>
    <link rel="stylesheet" href="./css/recruit.css">
    <script type="text/javascript" src="./js/recruit.js"></script>
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center">
            <div>
            	<c:if test="${sessionScope.userInfoDto.email ne null && sessionScope.auth eq 'admin' }">
	                <a href="./recruitInsertForm.do" class="btn btn-primary">공고작성</a>
            	</c:if>
            </div>
            <div class="d-flex justify-content-between">
                <div class="mx-1">
					<select id="emp" class="form-select" style="width: 170px;">
						<option value="">고용구분 선택..</option>
						<c:forEach var="e" items="${emp}">
							<option value="${e.codeid}">${e.codename}</option>
						</c:forEach>
					</select>
				</div>
                <div class="mx-1 input-group">
                    <input type="text" id="search" class="form-control" placeholder="제목 검색..">
                    <input type="button" id="btnSearch" class="btn btn-outline-secondary" value="검색">
                </div>
            </div>
        </div>
        <div class="recruit-list">
            <c:forEach var="dto" items="${lists}" varStatus="vs">
            	<c:if test="${sessionScope.auth eq 'admin'}">
            	</c:if>
                <div class="card my-2">
                    <div class="card-body d-flex justify-content-between">
                        <div class="d-flex flex-column">
                            <div>
                                <a href="./recruitDetail.do?seq=${dto.seq}" class="recruit-title">
                                    <h5>${dto.title}</h5>
                                </a>
                            </div>
                            <div class="d-flex align-items-center">
                                <fmt:formatDate value="${dto.startterm}" pattern="yyyy. MM. dd." />
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
                        </div>
                        <div class="d-flex align-items-center">
                            <div id="employ" class="mx-5">
                            	${dto.employ}
                            </div>
                            <div id="status" class="mx-5 badge fs-6">
                            	${dto.status}
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
			<ul class="pagination">
				<c:if test="${page.startPage > page.countPage}">
					<li class="page-item">
						<a class="page-link" href="./recruitList.do?page=${page.startPage - 1}">
							<span>&laquo;</span>
						</a>
					</li>
				</c:if>
				<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
					<li class="page-item ${num eq page.page ? 'active' : ''}">
						<a class="page-link" href="./recruitList.do?page=${num}">${num}</a>
					</li>	
				</c:forEach>
				<c:if test="${page.endPage < page.totalPage}">
					<li class="page-item">
						<a class="page-link" href="./recruitList.do?page=${page.endPage + 1}">
							<span>&raquo;</span>
						</a>
					</li>
				</c:if>
			</ul>
	</div>
    </div>
    <script type="text/javascript">
        window.onload = recruitList.init;
        let empCode = ${empJson}
        let rcsCode = ${rcsJson}
    </script>

<%@include file="/footer.jsp" %>