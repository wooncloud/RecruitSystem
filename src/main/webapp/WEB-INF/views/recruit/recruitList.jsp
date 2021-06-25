<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/header.jsp" %>
    <link rel="stylesheet" href="./css/recruit.css">
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center">
            <div>
                <a href="./recruitInsertForm.do" class="btn btn-primary">공고작성</a>
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
                    <input type="text" id="search" class="form-control" placeholder="검색..">
                    <input type="button" id="btnSearch" class="btn btn-outline-secondary" value="검색">
                </div>
            </div>
        </div>
        <div class="recruit-list">
            <c:forEach var="dto" items="${lists }" varStatus="vs">
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
                            <div>
                            	${dto.employ }
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

<%@include file="/footer.jsp" %>