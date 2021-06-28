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

		const { value: email } = await Swal.fire({    
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
							cancelButtonColor: 'gray',
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
	 }  // if문 종료
	})()  

}  // function 종료

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


//비밀번호 변경  
function modifyPw(){
	
	// 비빌번호 변경전 기존 비밀번호 확인
	(async () => {

		const { value: password } = await Swal.fire({     
		title: '비밀번호 변경',
		input: 'password',
		inputLabel: '현재 비밀번호를 입력해 주세요',
		
		confirmButtonText: '확인',	
		showCancelButton: true,
		cancelButtonColor: 'gray',
		cancelButtonText: '취소'
	}); // Swal.fire 종료
		// 확인 성공시 변경할 비밀번호 입력
	 if(password){
		 $.ajax({
				url:"./passwordChk.do",
				type:"post",
				data:"pwCheck="+password,
				async:true,
				success: function (msg) {
					console.log(msg);
					if(msg.isc==true){			

						Swal.fire({
							title:'새 비밀번호를 입력해 주세요',
							inputLabel: 'Password',
							html:
							    '<input type="password" id="swal-input1" class="swal2-input">' +
							    '<input type="password" id="swal-input2" class="swal2-input">',
							confirmButtonText: '확인',	
							showCancelButton: true,
							cancelButtonColor: 'gray',
							cancelButtonText: '취소',

						}).then((result) => {
							if(result.isConfirmed){							
								let pwChange = document.getElementById('swal-input1').value;
								let pwChange2 = document.getElementById('swal-input2').value;
								console.log(pwChange);
							// 변경할 비밀번호 유효값 확인 후 확인버튼 누르면 비밀번호 변경
							if (pwChange==pwChange2) {
								$.ajax({
									url:"./pwChange.do",
									type:"post",
									data:"pwChange="+pwChange,
									async:true,
									success: function(msg){
										console.log(msg);
										if(msg.isc==true){								
											Swal.fire({
												icon:'success',
												title:'비밀번호가 변경되었습니다.',
												confirmButtonText: '확인'
											})
										}
									}
								})
														
							}else{
								Swal.fire({
									icon:'error',
									title:'비밀번호가 일치하지 않습니다.',
									confirmButtonText: '확인'
								})
							}
							}
						})

					}else{
						Swal.fire({
							icon:'error',
							title:'잘못된 비밀번호 입니다.',
							confirmButtonText: '확인'
						})
					}
					
				   }
			})
	 }  // if문 종료
	})()  
	
}

//계정 삭제
function delFlagChk(){

	// 계정 삭제 전 비밀번호 확인
	(async () => {

		const { value: password } = await Swal.fire({     
		title: '계정 삭제',
		input: 'password',
		inputLabel: '비밀번호를 입력해 주세요',
		confirmButtonText: '확인',	
		showCancelButton: true,
		cancelButtonColor: 'gray',
		cancelButtonText: '취소'
	}); // Swal.fire 종료
		// 확인 성공시 변경할 비밀번호 입력
	 if(password){
		 $.ajax({
				url:"./passwordChk.do",
				type:"post",
				data:"pwCheck="+password,
				async:true,
				success: function (msg) {
					console.log(msg);
					if(msg.isc==true){			

						Swal.fire({
							title:'계정 삭제 ',
							text:'계정을 정말 삭제 하시겠습니까?',
							confirmButtonText: '확인',	
							showCancelButton: true,
							cancelButtonColor: 'gray',
							cancelButtonText: '취소',
							
							//계정 삭제 후 로그아웃 처리
						}).then((result) => {
							if(result.isConfirmed){	
								$.ajax({
									url:"./umDelFlag.do",
									type:"post",
									data:"delFlag",
									async:true,
									success: function(msg){
										console.log(msg);
										if(msg.isc==true){
											Swal.fire({
												icon:'success',
												title:'계정 삭제 성공',
												html:'계정이 삭제되었습니다.<br>  그동안 이용해주셔서 감사합니다.',
												confirmButtonText: '확인'
											}).then((result) => {
												//계정삭제 alert 후 세션삭제하고 로그아웃
											if(result.isConfirmed){	
											location.replace("./logout.do");
											}else{
											location.replace("./logout.do");
											}
											})
										}
									}
								})
														
							}
							
						})

					}else{
						Swal.fire({
							icon:'error',
							title:'잘못된 비밀번호 입니다',
							confirmButtonText: '확인',
							
						})
					}
					
				   }
			})
	 }  // if문 종료
	})()  
	
}

	//이메일 인증
function emailChk(){
	$.ajax({
		url:"./emailChk.do",
		type:"post",
		async:"true",
		success: function(){
			Swal.fire({
				title:'이메일 인증',
				html:'이메일로 전송된 인증번호를 입력해 주세요.',
				input:'text',
				confirmButtonText: '확인',	
				showCancelButton: true,
				cancelButtonColor: 'gray',
				cancelButtonText: '취소',
			})
		}
	})
}


