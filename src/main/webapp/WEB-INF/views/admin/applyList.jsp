<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/header.jsp" %>
	<div class="container mt-5">
		<div class="ctrl-div">
			<div class="my-1 between-center">
				<div>
					<select name="" id="" class="form-select">
						<option value="젤리랑 놀아줄 사람">젤리랑 놀아줄 사람</option>
					</select>
				</div>
				<div>
					<input type="button" value="채용완료" class="btn btn-warning text-white">
				</div>
			</div>
			<div class="my-3">
				<div class="card">
					<div class="card-body between-center">
						<div><h1>젤리랑 놀아줄 사람</h1></div>
						<div>모집기간</div>
					</div>
				</div>
			</div>
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
			<div class="my-3 d-flex align-items-center justify-content-end">
				<select name="" id="" class="mx-1 form-select">
					<option value="">진행단계 선택</option>
				</select>
				<select name="" id="" class="mx-1 form-select">
					<option value="">합격여부 선택</option>
				</select>
				<input type="button" value="적용" class="mx-1 btn btn-success">
			</div>
		</div>
		<div class="list-div">
			<div class="card">
				<div class="card-body">
					<table class="mb-0 table table-sm table-hover">
						<thead class="fw-bold ">
							<tr>
								<th style="width: 5%;"><input type="checkbox" name="" id=""></th>
								<th style="width: 5%;">#</th>
								<th style="width: 15%;">지원자명</th>
								<th style="width: 40%;">지원서 제목</th>
								<th style="width: 15%;">작성일</th>
								<th style="width: 10%;">진행단계</th>
								<th style="width: 10%;">합격여부</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" name="" id=""></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<ul class="mt-3 pagination justify-content-center">
				<li class="page-item">
					<a class="page-link" href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item">
					<a class="page-link" href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</ul>
		</div>
	</div>


<%@include file="/footer.jsp" %>