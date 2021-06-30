function selectRecruit(){
	
	var selectRecruit = document.getElementById("selectRecruit").value;
	console.log(selectRecruit);
	
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