// 로그인 입력 확인
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

// 회원가입 약관동의
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

// 아이디 중복체크
function duplicate(){
	
	(async () => {

		const { value: email } = await Swal.fire({     // Swal 빨간줄 이클립스에서 호환 안되는 듯 함
		title: '이메일 중복검사',
		input: 'email',
		inputLabel: '사용하실 이메일을 입력해 주세요',
		inputPlaceholder: 'ex)jelly@gmail.com',
		confirmButtonText: '중복확인',	
		showCancelButton: true,
		cancelButtonColor: 'green',
		cancelButtonText: '취소'
	}); // Swal.fire
	 if(email){
		 $.ajax({
				url:"./duplication.do",
				type:"post",
				data:"chkEmail="+email,
				async:true,
				success: function (msg) {
					console.log(msg);
					if(msg.isc==true){
						Swal.fire({
							icon:'success',
							title:'중복검사성공',
							text:'아이디를 사용 하시겠습니까?',
							confirmButtonText: '아이디 사용',	
							showCancelButton: true,
							cancelButtonColor: 'green',
							cancelButtonText: '취소'
						}).then((result) => {
							if (result.isConfirmed) {
								document.getElementById("email").value=email;
							}
						})
					
					}else{
						Swal.fire({
							icon:'error',
							title:'중복검사실패',
							text:'이미 사용중인 아이디 입니다.',
							confirmButtonText: '확인'
						})
					}
					
				   }
			})
	 }  // if문
	})()  

}  // function

//비밀번호 중복확인
function pwCheck(){
	 var pw = document.getElementById('password');
	 var pwChk = document.getElementById('passwordChk');
	 var chk = document.getElementById('check');

	    if(pw.value !='' && pwChk.value !=''){
	        if(pw.value ==pwChk.value){
	            chk.innerHTML='비밀번호가 일치합니다.'
	            chk.style.color='blue';
	        }
	        else{
	           chk.innerHTML='비밀번호가 일치하지 않습니다.';
	           chk.style.color='red';
	        }
	    }
	
}

// 회원가입 완료전 확인
function signupChk(){
	
	if(document.getElementById('password').value!=document.getElementById('passwordChk').value){
		Swal.fire({
			icon:'error',
			title:'회원가입 실패',
			text:'비밀번호를 확인해 주세요.',
			confirmButtonText: '확인'
		});	
		document.getElementById('passwordChk').focus();	
		return false;
	}
}








