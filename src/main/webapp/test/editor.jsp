<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.min.css" />
<link rel="stylesheet" href="https://uicdn.toast.com/editor/2.0.0/toastui-editor.min.css" />
<title>에디터 테스트 페이지 입니다.</title>
</head>
<body>
	<h1>에디터 테스트 페이지</h1>

	<div id="editor"></div>

	<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			const editor = new toastui.Editor({
			    el: document.querySelector('#editor'),
			    previewStyle: 'vertical',
			    height: '500px',
			    initialEditType : 'markdown',
			});


			editor.getHtml();
		});
	</script>
</body>
</html>