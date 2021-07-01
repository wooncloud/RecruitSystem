//  지원한 지원자 목록 페이지 채용공고 선택
function selectRecruit(){
	
	var selectRecruit = document.getElementById("selectRecruit").value;
	console.log(selectRecruit);
	
//	var selectRecruit2 = document.getElementById("selectRecruit").value2;
//	var selectRecruit2 = $("#selectRecruit option:selected").attr('value3');
//	console.log(selectRecruit2);
	
	if(selectRecruit=="allUser"){
		location.href = "./appConfirmList.do";
	}else{
		location.href = "./selAppConfirmList.do?seq="+selectRecruit;
		
	}
	
}

let applyList ={	
		init : function(){

			let steps = document.querySelectorAll("#step");
			for (const s of steps) {
				s.innerText = common.getCodeName(s.innerText, stpCode);
			}
			
			let results = document.querySelectorAll("#result");
			for (const r of results) {
				r.innerText = common.getCodeName(r.innerText, rstCode);
			}
			
		}
		
}

// 체크박스 전체선택 
function chkAll(bool) {
	var chkVals = document.getElementsByName("chkVal");

	for (var i = 0; i < chkVals.length; i++) {
		chkVals[i].checked = bool;
	}
	
}

// 선택 하나라도 풀릴시 전체선택 체크 해제
function selectChk(){
	var chkVals = document.querySelectorAll('input[name="chkVal"]');
	var checked = document.querySelectorAll('input[name="chkVal"]:checked');
	var chkAll = document.querySelector('input[name="chkAll"]');
	console.log(chkVals);
	console.log(checked);
	
	if(chkVals.length===checked.length){
		chkAll.checked = true;
	}else{
		chkAll.checked = false;		
	}
	
}

// 선택한 지원자 선택한 진행단계로 변경
function stepChange() {
	var steps = document.getElementById("steps").value;
	console.log(steps);
	var chkVals = document.getElementsByName("chkVal");
	console.log(chkVals);
	var chkVal = document.querySelectorAll('input[name="chkVal"]:checked');
	console.log(chkVal);
	var n = 0;
	
	for (var i = 0; i < chkVals.length; i++) {
		if (chkVals[i].checked) {
			n++
		}
	}

	if (n > 0) {
		Swal.fire({
			title:'진행단계 변경',
			text:'선택한 지원자들의 진행단계를 변경 하시겠습니까?',
			confirmButtonText: '확인',	
			showCancelButton: true,
			cancelButtonColor: 'gray',
			cancelButtonText: '취소',
		}).then((result) => {
			if(result.isConfirmed){
				
//				$.ajax({
//					type:"post",
//					url:"./acChangeStep.do",
//					dataType:"json",
//					data:{steps:steps, chkVal:chkVal},
//					data:"steps="+steps+"&chkVal="+chkVal,
//					data:"steps="+steps,
//					async:true,
//					success: function(msg){
//						if(msg.isc==true){
//							Swal.fire({
//								icon:'success',
//								title:'진행단계 변경',
//								text:'변경사항 적용에 성공하셨습니다.'
//							})
//						}
//					}
//				})
				
			}
		})

	} else {
		Swal.fire({
			icon :'warning',
			title:'적용 실패',
			text:'선택된 지원자가 없습니다.'
		});
		
	}

}

//선택한 지원자 선택한 합격여부로 변경
function resultChahge() {	
	var results = document.getElementById("results").value;
	console.log(results);
	var chkVal = document.getElementsByName("chkVal");
	var n = 0;
	
	for (var i = 0; i < chkVal.length; i++) {
		if (chkVal[i].checked) {
			n++
		}
	}
	
	if (n > 0) {
		$.ajax({
			url:"./acMultiBtn.do",
			type:"post",
			
		})
		
	} else {
		Swal.fire({
			icon :'warning',
			title:'적용 실패',
			text:'선택된 지원자가 없습니다.'
		});
		return false;
	}
	
}
