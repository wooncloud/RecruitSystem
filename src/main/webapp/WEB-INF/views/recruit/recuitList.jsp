<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@include file="/header.jsp" %>

    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center">
            <div>
                <input type="button" value="공고작성" class="btn btn-primary">
            </div>
            <div class="d-flex justify-content-between">
                <div class="mx-1">
                    <select id="emp" class="form-control">
                        <option value="0">고용구분 선택..</option>
                        <option value="1">option1</option>
                        <option value="2">option2</option>
                        <option value="3">option3</option>
                    </select>
                </div>
                <div class="mx-1">
                    <input type="text" id="search" class="form-control" placeholder="검색..">
                </div>
            </div>
        </div>
        <div class="recuit-list">
			<c:forEach var="dto" items="${lists }" varStatus="vs">
	            <div class="card my-2">
	                <div class="card-body d-flex justify-content-between">
	                    <div class="d-flex flex-column">
	                        <div>
	                            <h5>${dto.title}</h5>
	                        </div>
	                        <div>${dto.startterm} ~ ${endterm}</div>
	                    </div>
	                    <div>
	                        <div>${dto.employ }</div>
	                    </div>
	                </div>
	            </div>
			</c:forEach>
        </div>
    </div>

<%@include file="/footer.jsp" %>