<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/header.jsp" %>

<h1>회원가입 폼 TEST중입니다.</h1>

<form action="./signUpTest.do" method="post" >
	<div id="info">
		<div id="leftinfo">회원가입</div>
		<div id="centerInfo">
			<input type="text" id="email" name="email" placeholder="이메일" required >
			<span id="result"></span><br>
			<input type="password" id="password" name="password" placeholder="비밀번호" required><br>
			<input type="password" id="passwordChk" name="passwordChk" placeholder="비밀번호 확인" required><br>
			<input type="text" id="name" name="name" placeholder="이름" required><br>
			<input type="text" id="birth" name="birth" placeholder="생년월일" required><br>
			<input type="text" id="phone" name="phone" placeholder="핸드폰번호" required><br>
			
		</div>

		<div id="button">
			<input class="btn btn-info" type="submit" value="동의하고 회원가입">
			<input class="btn btn-info" type="button" value="돌아가기" onclick="javascript:history.back(-1)">
		</div>
	 </div>	
	</form>

<%@include file="/footer.jsp" %>