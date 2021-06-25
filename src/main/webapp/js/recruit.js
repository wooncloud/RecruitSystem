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

		this.editor.getHTML();
	},
	submit: function () {
		let form = document.forms[0]

		let content = recruitInsert.editor.getMarkdown();
		document.getElementById("content").value = content;

		Swal.fire({
			title: '정말로 저장 하시겠습니까?',
			showDenyButton: true,
			showCancelButton: true,
			confirmButtonText: `네`,
			denyButtonText: `아니오`,
		}).then((result) => {
			if (result.isConfirmed) {
				form.submit();
			} else {
				return;
			}
		})
	}
}