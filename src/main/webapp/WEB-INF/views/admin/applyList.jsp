<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/header.jsp" %>
	<link href="./css/admin.css" rel="stylesheet">
	<script type="text/javascript" src="./js/admin.js"></script>
	<div class="container mt-5">
		<div class="ctrl-div">
			<div class="my-1 between-center">
				<div>
					<select name="selectRecruit" id="selectRecruit" class="form-select" onchange="selectRecruit()">
						<option value="채용공고 선택" >채용공고 선택</option>
						<option value="allUser" >------------------------------------</option>
						<option value="allUser" >지원자 전체목록</option>
						<option value="allUser" >------------------------------------</option>
						<c:forEach var="dto" items="${rlists}" varStatus="vs">
							<option  value="${dto.seq}" >${dto.seq}&nbsp;-&nbsp;${dto.title}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<input type="button" value="채용완료" class="btn btn-warning text-white">
				</div>
			</div>		
<!-- 			<div class="my-3" id="recruitCard"> -->
<!-- 				<div class="card"> -->
<!-- 					<div class="card-body between-center"> -->
<!-- 						<div><h1 id="selRecruitTitle">젤리랑 놀아줄 사람 선택한공고 띄워야하는데</h1></div> -->
<!-- 						<div>모집기간</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<div class="my-3 d-flex align-items-center justify-content-end">
				<div class="mx-1">
					<select name="" id="" class="form-select">
						<option value="">검색방법 선택</option>
						<option value="">지원자명</option>
						<option value="">지원서 제목</option>
						<option value="">진행단계</option>
						<option value="">합격여부</option>
					</select>
				</div>
				<div class="mx-1 input-group">
					<input type="text" placeholder="제목 검색.." class="form-control">
					<input type="button" value="검색" class="btn btn-outline-secondary">
				</div>
			</div>
		</div>
		<div class="list-div">
			<div class="my-3 d-flex align-items-center justify-content-end">
				<select name="steps" id="steps" class="mx-1 form-select">
					<option value="">진행단계 선택</option>
					<c:forEach var="stp" items="${stp}" varStatus="vs">
						<option value="${stp.codename}">${stp.codename}</option>
					</c:forEach>
				</select>
				<input type="button" value="적용" class="mx-1 btn btn-success" onclick="stepChange()">
				<select name="results" id="results" class="mx-1 form-select">
					<option value="">합격여부 선택</option>
					<c:forEach var="rst" items="${rst}" varStatus="vs">
						<option value="${rst.codename}">${rst.codename}</option>
					</c:forEach>
				</select>
				<input type="button" value="적용" class="mx-1 btn btn-success" onclick="resultChahge()">
			</div>
			<div class="card">
				<div class="card-body">
					<table class="mb-0 table table-sm table-hover">
						<thead class="fw-bold ">
							<tr>
								<th style="width: 5%;"><input type="checkbox" name="chkAll" onclick="chkAll(this.checked)"></th>
								<th style="width: 5%;">#</th>
								<th style="width: 15%;">지원자명</th>
								<th style="width: 40%;">지원서 제목</th>
								<th style="width: 15%;">작성일</th>
								<th style="width: 10%;">진행단계</th>
								<th style="width: 10%;">합격여부</th>
							</tr>
						</thead>
						<tbody>
						
						<c:forEach var="dto" items="${lists}" varStatus="vs">
							<tr>
								<td><input type="checkbox" name="chkVal" value="${dto.seq}" onclick="selectChk()"></td>
								<td>${dto.seq}</td>
								<td>${dto.udto[0].name}</td>
								<td>
									<a href="#" class="application-list" >${dto.adto[0].title}</a>
								</td>
								<td>
									<fmt:formatDate value="${dto.submitdate}" pattern="yyyy. MM. dd." />
								</td>
								<td>
									<div id="step">${dto.step}</div>
								</td>
								<td>
									<div id="result">${dto.result}</div>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>		
				</div>
			</div>		
<%-- 			<c:if test=""> --%>
			<ul class="mt-3 pagination justify-content-center">
			<c:if test="${page.startPage > page.countPage}">
				<li class="page-item">
					<a class="page-link" href="./appConfirmList.do?page=${page.startPage-1}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>
				<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
					<li class="page-item ${num eq page.page ? 'active' : ''}">
						<a class="page-link" href="./appConfirmList.do?page=${num}">${num}</a>
					</li>	
				</c:forEach>
				
				<c:if test="${page.endPage < page.totalPage}">
					<li class="page-item">
						<a class="page-link" href="./appConfirmList.do?page=${page.endPage + 1}">
							<span>&raquo;</span>
						</a>
					</li>
				</c:if>	
			</ul>
<%-- 			</c:if> --%>
		</div>	
	</div>
<script type="text/javascript">
	window.onload = applyList.init;
	let stpCode = ${stpJson}
	let rstCode = ${rstJson}
</script>
<%@include file="/footer.jsp" %>