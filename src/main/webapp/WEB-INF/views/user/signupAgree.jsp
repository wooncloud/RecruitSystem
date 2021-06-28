<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>

<link href="./css/user.css" rel="stylesheet">
<script type="text/javascript" src="./js/user.js"></script>

<div class="container">
	<div class="box">
		<div class="card">
			<div class="card-body">
				<div class="my-3 fs-4 fw-bold">[필수]개인정보 수집 및 이용 동의</div>
				<label  class="my-2 fw-bold" for="floatingTextarea">개인정보 수집 및 이용에 대한 안내</label>
				<div class="form-floating">
					<textarea class="form-control" id="floatingTextarea" readonly>동의하세요</textarea>
				</div>
				<div class="my-2">
					<input id="signupAgreeChk" type="checkbox">
					동의 
				</div>
			</div>
		</div>
		<div class="my-3 d-grid gap-2" >
			<input type="button" class="btn btn-light btn-outline-success btn-lg" value="다음" onclick="signupAgree()">
		</div>
	</div>
</div>





<%@include file="/footer.jsp"%>