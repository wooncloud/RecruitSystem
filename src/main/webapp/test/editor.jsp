<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.min.css" />
<link rel="stylesheet" href="https://uicdn.toast.com/editor/2.0.0/toastui-editor.min.css" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>에디터 테스트 페이지 입니다.</title>
</head>
<body>
	<h1>에디터 테스트 페이지</h1>

	<div id="editor"></div>

	<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			// Swal.fire('테스트 성공!', '우리는 이제 swal을 사용할 수 있어요. 야호!', 'success')

			const Editor = toastui.Editor;
			
			const editor = new Editor({
				el : document.querySelector('#editor'),
				height : '500px',
				initialEditType : 'markdown',
				previewStyle : 'vertical'
			});

			editor.getHtml();
		});
	</script>
</body>
</html>