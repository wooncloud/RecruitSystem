<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
</head>
<body>
<h1>TEST중입니다.</h1>

	<form action="./login.do" method="post">
		<div class="inputWord">아이디</div>
			<input type="text" name="email" id="email" placeholder="이메일 입력"><br>
		<div class="inputWord">비밀번호</div>
			<input type="password" name="pw" id="pw" placeholder="비밀번호 입력" ><br>
			
		<input type="submit"  id="login" name="login" class="login" value="LOGIN" >
		
		<div id="bottom">
			<input type="button" id="signup" value="회원가입">
			<input type="button" value="아이디 찾기">
			<input type="button" value="비밀번호 찾기">
		
		</div>	
	</form>

</body>
</html>