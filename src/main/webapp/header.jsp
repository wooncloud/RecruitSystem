<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <!-- CSS -->
    <!-- bootstrap CSS -->
    <link href="./css/init.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/common.css" rel="stylesheet">
	
    <!-- JS -->
    <!-- jQuery -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
    <!-- bootstrap JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- swal2 -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
    <script type="text/javascript" src="./js/common.js"></script>

    <title>GDRS</title>
</head>
<body>
    <header>
        <nav class="nav-base-frame">
            <div class="nav-menu d-flex-center">
                <div class="logo">
                    <!-- <img src="/img/logo.jpg" alt="logo"> -->
                    <!-- 아래는 임시로고 -->
                    <a href="./index.jsp" class="temp-logo">GDRS</a>
                </div>
                <div class="nav-menu-list">
                    <ul class="d-flex-center">
                        <li><a href="./recuitList.do">채용공고</a></li>
                        <li><a href="./myApplicaion.do">내 지원서</a></li>
                        <li><a href="./result.do">지원결과 확인</a></li>
                        <li><a href="./applyList.do">지원자 목록 조회</a></li>
                    </ul>
                </div>
            </div>
            <div class="nav-user d-flex-center">
            <c:if test="${userInfoDto.email == null}">
                <div class="d-flex-center">
                    <a href="./loginForm.do">로그인</a>
                    <a href="./signupAgree.do">회원가입</a>
                </div>
            </c:if>
            <c:if test="${userInfoDto.email != null}">
                <div class="d-flex-center">
                    <span> ${userInfoDto.name} 님 안녕하세요.</span>
                    <a href="./myInfo.do">내 정보</a>
                    <a href="./logout.do">로그아웃</a>
                </div>
            </c:if>    
            </div>
        </nav>
    </header>
    <div class="header-space"></div>
    <section>

