window.onload = function () {
	console.log("test");

	// common.swal("알림", "내용", function(){
	// 	location.href = "./recuitList.do";
	// });
}

let common = {
	swal: function (title, text, evt) {
		Swal.fire({
			title: title,
			text: text,
		}).then(evt);
	}
}