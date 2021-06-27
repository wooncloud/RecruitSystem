<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>

<link href="./css/user.css" rel="stylesheet">
<script type="text/javascript" src="./js/user.js"></script>

<div class="container">
	<div class="box">
        <div class="card">
			<div class="card-body">
				<div class="fs-4 fw-bold">내 정보 조회</div>
				<div  class="my-3 fw-light">
					이름
					<p class="fw-normal fs-6">${dto.name}</p>
				</div>
				<div  class="my-3 fw-light">
					이메일
					<p class="fw-normal fs-6">${dto.email}</p>
				</div>
				<div  class="my-3 fw-light">
					비밀번호
					<p class="fw-normal fs-6" onclick="modifyPw()"><a class="modifyPw">비밀번호 변경하기</a></p>
				</div>
				<div  class="my-3 fw-light">
					휴대폰 번호
					<p class="fw-normal fs-6">${dto.phone}</p>
				</div>
				<div  class="my-3 fw-light">
					생년월일
					<p class="fw-normal fs-6">${dto.birth}</p>
				</div>
			</div>
		</div>
    	<div class="my-3" align="right">
	    	<input type="submit" class="btn btn-danger " value="계정삭제" onclick="delFlagChk()">
    	</div>

	</div>
</div>

<%@include file="/footer.jsp"%>