<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/header.jsp" %>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.min.css" />
	<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
    <div class="container my-5">
        <div class="card">
            <form action="./recruitInsert.do" method="POST" onsubmit="">
                <div class="card-header d-flex align-items-center justify-content-between">
                    <div>
                        <h5 class="mb-0 fw-bold">새 공고 작성</h5>
                    </div>
                    <div>
                        <input type="button" class="mx-1 btn btn-success" value="작성완료">
                        <input type="reset" class="mx-1 btn btn-secondary" value="작성취소" onclick="history.back(-1)">
                    </div>
                </div>
                <div class="card-body">
                    <div>
                        <div>
                            <input type="text" value="" name="title" class="form-control form-control-lg" placeholder="공고 제목을 입력하세요.">
                        </div>
                        <div class="my-2 d-flex align-items-center justify-content-end">
                            <div class="d-flex align-items-center">
                                <input type="date" name="startterm" class="mx-1 form-control">
                                <span class="mx-1"> ~ </span>
                                <input type="date" name="endterm" class="mx-1 form-control">
                            </div>
                            <div class="ms-3 me-1">
                                <select name="employ" class="mx-1 form-select">
                                    <option value="">고용구분 선택..</option>
                                    <c:forEach var="e" items="${emp}">
                                        <option value="${e.codeid}">${e.codename}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <div>
                        <div id="editor"></div>
                    </div>
                </div>
                <div class="card-footer d-flex justify-content-end">
                    <input type="button" class="mx-1 btn btn-success" value="작성완료">
                    <input type="reset" class="mx-1 btn btn-secondary" value="작성취소" onclick="history.back(-1)">
                </div>
            </form>
        </div>
    </div>
    <script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			let content = "";
			
			const editor = new toastui.Editor({
			  el: document.querySelector('#editor'),
			  previewStyle: 'vertical',
			  initialEditType: "wysiwyg",
			  height: '500px',
			  previewHighlight:true,
			  language: 'ko',
			  initialValue: content
			});
		
			editor.getHTML();
		});
	</script>
<%@include file="/footer.jsp" %>