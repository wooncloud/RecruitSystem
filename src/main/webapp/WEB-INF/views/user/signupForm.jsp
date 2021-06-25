<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/header.jsp" %>

<link href="./css/user.css" rel="stylesheet">

<div class="container">
	<form action="./signUpTest.do" method="post" >
	<div class="box">
		<div class="card">
		<div class="card-body">
			<div class="mt-3 fs-5 fw-bold">&nbsp;&nbsp;회원가입</div>
				<div class="input-group my-3">
 					<span class="input-group-text" id="basic-addon1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이메일&nbsp;&nbsp;&nbsp;&nbsp;</span>
  					<input type="text" name="email" id="email" class="form-control" aria-label="Username" aria-describedby="basic-addon1" required>
				</div>
				<div class="input-group my-3">
 					<span class="input-group-text" id="basic-addon1">&nbsp;&nbsp;&nbsp;비밀번호&nbsp;&nbsp;&nbsp;</span>
  					<input type="password" name="password" id="password" class="form-control" aria-label="Username" aria-describedby="basic-addon1" required>
				</div>
				<div class="input-group my-3">
 					<span class="input-group-text" id="basic-addon1">비밀번호확인</span>
  					<input type="password" name="passwordChk" id="passwordChk" class="form-control" aria-label="Username" aria-describedby="basic-addon1" required>
				</div>
				<div class="input-group my-3">
 					<span class="input-group-text" id="basic-addon1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
  					<input type="text" name="name" id="name" class="form-control" aria-label="Username" aria-describedby="basic-addon1" required>
				</div>
				<div class="input-group my-3">
 					<span class="input-group-text" id="basic-addon1">&nbsp;&nbsp;&nbsp;생년월일&nbsp;&nbsp;&nbsp;</span>
  					<input type="text" name="birth" id="birth" class="form-control" aria-label="Username" aria-describedby="basic-addon1" required>
				</div>
				<div class="input-group my-3">
 					<span class="input-group-text" id="basic-addon1">&nbsp;&nbsp;핸드폰번호&nbsp;</span>
  					<input type="text" name="phone" id="phone" class="form-control" aria-label="Username" aria-describedby="basic-addon1" required>
				</div>
		</div>	
		</div>

		<div class="my-3 d-grid gap-2" >
			<input type="submit" id="login" name="login" class="btn btn-light btn-outline-primary btn-lg" value="회원가입">
			<input type="button" class="btn btn-light btn-outline-secondary  btn-lg"  value="돌아가기" onclick="javascript:history.back(-1)">
		</div>
	</div>
	</form>
</div>	

<%@include file="/footer.jsp" %>