function loginCheck(){
	var email = document.getElementById("email");
	var password = document.getElementById("password");
	
	if(email.value==""){
		Swal.fire({
			icon :'warning',
			title:'로그인 실패',
			text:'아이디를 입력해 주세요'
		});
		return false;
	}else if(password.value==""){
		Swal.fire({
			icon :'warning',
			title:'로그인 실패',
			text:'비밀번호를 입력해 주세요'
		});
		return false;		
	}
	
}


function signupAgree(){
	
	let signupAgreeChk = document.getElementById('signupAgreeChk');
	
	if(signupAgreeChk.checked==true){
		location.href='./signupForm.do';
		
	}else{
		Swal.fire({
			icon :'warning',
			title:'약관 동의 실패',
			text:'위의 필수 약관에 동의해 주세요'
		});
		return false;
	}
	
}
















