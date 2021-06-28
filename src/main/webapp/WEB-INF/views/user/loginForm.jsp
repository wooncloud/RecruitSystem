<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>

<link href="./css/user.css" rel="stylesheet">
<script type="text/javascript" src="./js/user.js"></script>

<div class="container">
	<div class="box">
	<form action="./login.do" method="post" onsubmit="return loginCheck()">
		<div class="card">
			<div class="card-body">
				<div class="mt-3 fs-4 fw-bold">로그인</div>
				<div class="input-group my-3">
 					<span class="input-group-text" id="basic-addon1">이메일</span>
  					<input type="text" name="email" id="email" class="form-control" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				<div class="input-group my-3">
 					<span class="input-group-text" id="basic-addon1">비밀번호</span>
  					<input type="password" name="password" id="password" class="form-control" aria-label="Username" aria-describedby="basic-addon1">
				</div>
			</div>
		</div>
		<div class="my-3 d-grid gap-2" >
			<input type="submit" id="login" name="login" class="btn btn-light btn-outline-success btn-lg" value="로그인">
			<input type="button" id="signup" class="btn btn-light btn-outline-primary btn-lg" value="회원가입" onclick="location.href='./signupAgree.do'">
		</div>
	</form>
	</div>
</div>

<%@include file="/footer.jsp"%>