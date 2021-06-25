window.onload = function () {
	console.log("test");

	// common.swal("알림", "내용", function(){
	// 	location.href = "./recruitList.do";
	// });
}

let common = {
	swal: function (title, text, evt) {
		Swal.fire({
			title: title,
			text: text,
		}).then(evt);
	},
	getCodeName: function(codeId, codeList){
		for (const code of codeList) {
			if(code.id == codeId){
				return code.name;
			}
		}
	}
}