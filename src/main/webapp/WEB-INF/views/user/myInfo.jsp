<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>

<link href="./css/user.css" rel="stylesheet">


<div class="container">
	<div class="box">
        <div class="card">
			<div class="card-body">
				<div class="fs-5 fw-bold">내 정보 조회</div>
				<div  class="my-3 fw-normal">
					이름<br>
					${dto.name}
				</div>
				<div  class="my-3 fw-normal">
					이메일<br>
					${dto.email}
				</div>
				<div  class="my-3 fw-normal">
					비밀번호<br>
					<a href="./modifyPw.do">비밀번호 변경하기</a>
				</div>
				<div  class="my-3 fw-normal">
					휴대폰 번호<br>
					${dto.phone}
				</div>
				<div  class="my-3 fw-normal">
					생년월일<br>
					${dto.birth}
				</div>
			</div>
		</div>
    	<div class="my-3" align="right">
	    	<input type="button" class="btn btn-danger " value="계정삭제">
    	</div>
	</div>
</div>

<%@include file="/footer.jsp"%>