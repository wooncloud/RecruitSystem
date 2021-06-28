<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/header.jsp" %>

<link href="./css/user.css" rel="stylesheet">
<script type="text/javascript" src="./js/user.js"></script>

<div class="container">
	<form action="./asignUp.do" method="post"  onsubmit="return signupChk(this);">
	<div class="box">
		<div class="card">
		<div class="card-body">
			<div class="mt-3 fs-4 fw-bold">관리자 계정 생성</div>
				<div class="input-group my-3">
 					<span class="input-group-text" >이메일</span>
  					<input type="text" name="email" id="email" class="form-control"  required readonly>
					<input type="button" value="중복확인" class="btn btn-outline-success" onclick="duplicate()">
				</div>
				<div class="input-group my-3">
 					<span class="input-group-text" >비밀번호</span>
  					<input type="password" name="password" id="password" class="form-control"  required>
				</div>
				<div class="input-group my-3">
 					<span class="input-group-text" >비밀번호&nbsp;확인</span>
  					<input type="password" name="passwordChk" id="passwordChk" class="form-control" onchange="pwCheck()"  required>
				</div>
				<div>
  					<span id="check"></span>
				</div>
				<div class="input-group my-3">
 					<span class="input-group-text" >이&nbsp;름</span>
  					<input type="text" name="name" id="name" class="form-control"  required>
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