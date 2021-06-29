let recruitList = {
	init: function () {
		document.getElementById("btnSearch").onclick = recruitList.search;

		let employs = document.querySelectorAll("#employ");
		for (const e of employs) {
			e.innerText = common.getCodeName(e.innerText, empCode);
		}
		let status = document.querySelectorAll("#status");
		for (const s of status) {
			switch(s.innerText){
				case "RCS001":
					s.classList.add('bg-warning');
					break;
				case "RCS002":
					s.classList.add('bg-success');
					break;
				case "RCS003":
					s.classList.add('bg-danger');
					break;
				case "RCS004":
					s.classList.add('bg-secondary');
					break;
			}

			s.innerText = common.getCodeName(s.innerText, rcsCode);
		}
	},
	search: function(){
		let emp = "";
		let search = "";

		let url = "./recruitList.do";
		if(document.getElementById("emp").value != ""){
			emp = "?employ=" + document.getElementById("emp").value;
		}

		if(document.getElementById("search").value != ""){
			search = (emp == "") ? "?" : "&";
			search += "title=" + document.getElementById("search").value;
		}

		location.href = "./recruitList.do" + emp + search;
	}
}

let recruitInsert = {
	editor: null,
	init: function () {
		// buttons init
		document.getElementById("submitTop").onclick = this.submit;
		document.getElementById("submitBottom").onclick = this.submit;

		// editor
		this.editor = new toastui.Editor({
			el: document.querySelector('#editor'),
			previewStyle: 'vertical',
			initialEditType: "wysiwyg",
			height: '500px',
			previewHighlight: true,
			language: 'ko',
			initialValue: ""
		});
	},
	valid: function (form) {
		if (form.title.value == "") {
			Swal.fire("알림", "제목을 입력하세요.", "warning");
			form.title.focus();
			return false;
		} else if (form.startterm.value == "") {
			Swal.fire("알림", "모집일자를 입력하세요.", "warning");
			form.startterm.focus();
			return false;
		} else if (form.employ.value == "") {
			Swal.fire("알림", "고용 구분을 선택하세요.", "warning");
			form.employ.focus();
			return false;
		} else if (form.status.value == "") {
			Swal.fire("알림", "공개 상태를 선택하세요.", "warning");
			form.status.focus();
			return false;
		} else if (form.content.value == "") {
			Swal.fire("알림", "내용을 입력하세요.", "warning");
			return false;
		}

		// 시작일자가 종료일자보다 크면 체크
		if(form.endterm.value != "" && form.startterm.value > form.endterm.value){
			Swal.fire("알림", "시작일자가 종료일자보다 더 큽니다.", "warning");
			return false;
		}

		return true;
	},
	submit: function () {
		let form = document.forms[0]

		// let content = recruitInsert.editor.getMarkdown();
		let content = recruitInsert.editor.getHTML();
		document.getElementById("content").value = content;

		if (!recruitInsert.valid(form)) {
			return;
		}

		Swal.fire({
			title: '정말로 저장 하시겠습니까?',
			showCancelButton: true,
			confirmButtonText: `네`,
			cancelButtonText: `취소`,
		}).then((result) => {
			if (result.isConfirmed) {
				form.submit();
			} else {
				return;
			}
		})
	}
}

let recruitDetail = {
	viewer: null,
	init: function (content) {

		let status = document.getElementById("status").innerText;
		document.getElementById("status").innerText = common.getCodeName(status, rcsCode);
		switch(status){
			case "RCS001":
				document.getElementById("status").classList.add('bg-warning');
				break;
			case "RCS002":
				document.getElementById("status").classList.add('bg-success');
				break;
			case "RCS003":
				document.getElementById("status").classList.add('bg-danger');
				break;
			case "RCS004":
				document.getElementById("status").classList.add('bg-secondary');
				break;
		}


		let employ = document.getElementById("employ").innerText;
		document.getElementById("employ").innerText = common.getCodeName(employ, empCode);

		// editor
		viewer = new toastui.Editor.factory({
			el: document.querySelector('#viewer'),
			viewer: true,
			language: 'ko',
			initialValue: content
		});
	},
	delete: function (seq) {
		Swal.fire({
			title: '삭제 하시겠습니까?',
			icon: 'question',
			text: '정말로 해당 공고를 삭제 하시겠습니까?',
			showCloseButton: true,
			showCancelButton: true,
			focusConfirm: false,
			confirmButtonText: '삭제',
			confirmButtonColor: '#E74C3C',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				location.href = "./recruitDelete.do?seq=" + seq;
			}
		});
	}
}

let recruitModify = {
	editor: null,
	init: function (content) {
		// buttons init
		document.getElementById("submitTop").onclick = this.submit;
		document.getElementById("submitBottom").onclick = this.submit;

		// editor
		this.editor = new toastui.Editor({
			el: document.querySelector('#editor'),
			previewStyle: 'vertical',
			initialEditType: "wysiwyg",
			height: '500px',
			previewHighlight: true,
			language: 'ko',
			initialValue: content
		});
	},
	valid: function (form) {
		if (form.title.value == "") {
			Swal.fire("알림", "제목을 입력하세요.", "warning");
			form.title.focus();
			return false;
		} else if (form.startterm.value == "") {
			Swal.fire("알림", "모집일자를 입력하세요.", "warning");
			form.startterm.focus();
			return false;
		} else if (form.employ.value == "") {
			Swal.fire("알림", "고용 구분을 선택하세요.", "warning");
			form.employ.focus();
			return false;
		} else if (form.status.value == "") {
			Swal.fire("알림", "공개 상태를 선택하세요.", "warning");
			form.status.focus();
			return false;
		} else if (form.content.value == "") {
			Swal.fire("알림", "내용을 입력하세요.", "warning");
			return false;
		}
		
		// 시작일자가 종료일자보다 크면 체크
		if(form.endterm.value != "" && form.startterm.value > form.endterm.value){
			Swal.fire("알림", "시작일자가 종료일자보다 더 큽니다.", "warning");
			return false;
		}

		return true;
	},
	submit: function () {
		let form = document.forms[0]

		// let content = recruitModify.editor.getMarkdown();
		let content = recruitModify.editor.getHTML();
		document.getElementById("content").value = content;

		if (!recruitModify.valid(form)) {
			return;
		}

		Swal.fire({
			title: '수정 하시겠습니까?',
			showCancelButton: true,
			confirmButtonText: `네`,
			cancelButtonText: `취소`,
		}).then((result) => {
			if (result.isConfirmed) {
				form.submit();
			} else {
				return;
			}
		})
	}
}
