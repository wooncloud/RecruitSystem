<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/header.jsp" %>

	<link rel="stylesheet" href="./css/application.css" />
	<script type="text/javascript" src="./js/application.js"></script>
	<div class="container my-5">
		<div class="application-header">
			<div class="card">
				<div class="card-body">
					<div class="header-content">
						<div>
							<div><h4>지원자 : ${adDto.name}</h4></div>
							<div>${adDto.phone}</div>
							<div>${adDto.email}</div>
						</div>
						<div>
							<div class="d-flex-center">
								<input type="button" value="임시저장" id="btnApSave" class="mx-1 btn btn-warning">
								<input type="button" value="미리보기" id="btnApView" class="mx-1 btn btn-secondary">
								<input type="button" value="지원하기" id="btnApSubmit" class="mx-1 btn btn-primary">
							</div>
						</div>
						<input type="hidden" name="seq" value="${adDto.aDto.seq}">
					</div>
				</div>
			</div>
		</div>
		<div class="application-section">
			<div id="recruit" class="app-part">
				<div class="app-part-title">
					<h4>지원 공고 선택</h4>
					<div class="app-part-title-detail"></div>
				</div>
				<div class="app-part-body">
					<select id="" class="form-select">
						<option value="" selected>지원할 공고를 선택하세요.</option>
						<c:forEach var="rec" items="${rDto}" varStatus="vs">
							<option value="${rec.seq}">${rec.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div id="title" class="app-part">
				<div class="app-part-title">
					<h4>지원서 제목</h4>
					<div class="app-part-title-detail"></div>
				</div>
				<div class="app-part-body">
					<input type="text" id="txtApTitle" class="form-control" value="${adDto.aDto.title}" placeholder="지원서 제목 입력..">
				</div>
			</div>
			<div id="career" class="app-part">
				<div class="app-part-title">
					<h4>경력 정보</h4>
					<div class="app-part-title-detail">
						* 해당 항목을 모두 기입한 후, 완료버튼을 누르면 다음 항목이 활성화됩니다.<br>
						* 입사일/퇴사일은 "YYYY.MM.DD" 순서로 입력해 주세요. (예 : 2012.02.22)<br>
						* 고교졸업 이후 정규직 Full-time 경력을 기재합니다. (추후 증빙서류 제출 필수)<br>
						* 인턴십, 프리랜서 등은 기재는 가능하나 경력으로 인정되지 않습니다.<br>
						* 아르바이트 및 증명이 불가능한 경력사항은 기재하지 않습니다.<br>
						* 최종 회사에 재직중이면, 퇴사일은 비워 두셔도 됩니다.<br>
					</div>
				</div>
				<div class="app-part-body">
					<div class="app-part-body-new">
						<div class="my-1 row">
							<div class="col-4"><input type="text" id="txtCareerCorpname" class="form-control" placeholder="회사명"></div>
							<div class="col-2"><input type="text" id="txtCareerEmploy" class="form-control" placeholder="유형"></div>
							<div class="col-2"><input type="text" id="txtCareerPosition" class="form-control" placeholder="직급"></div>
							<div class="col-2"><input type="date" id="txtCareerHiredate" class="form-control" placeholder="입사일"></div>
							<div class="col-2"><input type="date" id="txtCareerFiredate" class="form-control" placeholder="퇴사일"></div>
						</div>
						<div class="my-1 row">
							<div class="col-12"><input type="text" id="txtCareerWork" class="form-control" placeholder="담당업무"></div>
						</div>
					</div>
					<input type="button" value="추가" id="btnCareerAdd" class="my-3 btn btn-outline-success">
					<div id="careerList"></div>
				</div>
			</div>
			<div id="projectExp" class="app-part">
				<div class="app-part-title">
					<h4>프로젝트 경험</h4>
					<div class="app-part-title-detail"></div>
				</div>
				<div class="app-part-body">
					<div class="app-part-body-new">
						<div class="my-1 row">
							<div class="col-8"><input type="text" id="txtProjectExpTitle" class="form-control" placeholder="프로젝트 명"></div>
							<div class="col-2"><input type="date" id="txtProjectExpStartdate" class="form-control" placeholder="시작일"></div>
							<div class="col-2"><input type="date" id="txtProjectExpEnddate" class="form-control" placeholder="종료일"></div>
						</div>
						<div class="my-1 row">
							<div class="col-6"><input type="text" id="txtProjectExpCorpname" class="form-control" placeholder="회사명"></div>
							<div class="col-6"><input type="text" id="txtProjectExpJob" class="form-control" placeholder="직무"></div>
						</div>
						<div class="my-1 row">
							<div class="col-12">
								<textarea id="txtProjectExpContent" cols="30" rows="4" class="form-control" placeholder="담당업무"></textarea>
							</div>
						</div>
					</div>
					<input type="button" value="추가" id="btnProjectExpAdd" class="my-3 btn btn-outline-success">
					<div id="projectExpList"></div>
				</div>
			</div>
			<div id="introduce" class="app-part">
				<div class="app-part-title">
					<h4>자기소개</h4>
					<div class="app-part-title-detail"></div>
				</div>
				<div class="app-part-body">
					<textarea id="txtApIntroduce" cols="30" rows="10" class="form-control">${adDto.aDto.introduce}</textarea>
					<div>글자수 세기</div>
				</div>
			</div>
			<div id="portpolio" class="app-part">
				<div class="app-part-title">
					<h4>포트폴리오</h4>
					<div class="app-part-title-detail">
						* 타사의 영업비밀에 해당하거나, 이에 해당될 수 있는 것으로 오해할 수 있는 자료는 경력기술서 또는 포트폴리오에 포함하여서는 안됩니다.<br>
						* [선택] 앞서 작성한 내용 이외에 본인의 역량을 충분히 나타낼 수 있는 자료가 있다면 제출해주세요. (30MB 이하의 PDF 또는 URL)
					</div>
				</div>
				<div class="app-part-body">
					<div class="input-group">
						<span class="input-group-text">포트폴리오 URL</span>
						<input type="text" class="form-control" placeholder="포트폴리오 URL을 입력...">
						<span class="input-group-text">첨부파일</span>
						<input type="file" class="form-control" placeholder="포트폴리오 첨부파일을 입력...">
					</div>
				</div>
			</div>
			<div id="education" class="app-part">
				<div class="app-part-title">
					<h4>학력정보</h4>
					<div class="app-part-title-detail">
						* 학력은 고등학교에서부터 현 최종학력 순으로 순차적으로 기재하시기 바랍니다.<br>
						* 해당 항목을 모두 기입한 후, 완료버튼을 누르면 다음 항목이 활성화됩니다.<br>
						* 입학년월/졸업년월은 YYYY.MM.DD 순서로 입력해 주세요. (예: 2012.03.02)<br>
						* 복수전공 및 이중전공을 이수하신 분들은 부전공란에 입력해주세요.<br>
					</div>
				</div>
				<div class="app-part-body">
					<div class="app-part-body-new">
						<div class="input-group">
							<select class="form-select" id="selEdu">
								<option value="">학력 선택..</option>
								<c:forEach var="code" items="${ADB}" varStatus="vs">
									<option value="${code.codeid}">${code.codename}</option>
								</c:forEach>
							</select>
							<input type="text" id="txtEdu" class="form-control" placeholder="학교명">
							<input type="text" id="txtEdu" class="form-control" placeholder="전공">
							<input type="text" id="txtEdu" class="form-control" placeholder="평점/총점">
							<input type="date" id="txtEdu" class="form-control" placeholder="입학년월일">
							<input type="date" id="txtEdu" class="form-control" placeholder="졸업년월일">
							<select class="form-select" id="selEdu">
								<option value="">졸업상태 선택..</option>
								<c:forEach var="code" items="${GDS}" varStatus="vs">
									<option value="${code.codeid}">${code.codename}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<input type="button" value="추가" id="btnEducationAdd" class="my-3 btn btn-outline-success">
					<div>
						리스트
					</div>
				</div>
			</div>
			<div id="certificate" class="app-part">
				<div class="app-part-title">
					<h4>자격증 및 수상 정보</h4>
					<div class="app-part-title-detail"></div>
				</div>
				<div class="app-part-body">
					<div class="app-part-body-new">
						<div class="input-group">
							<select id="selCertType" class="form-select">
								<option value="자격증">자격증</option>
								<option value="수상정보">수상정보</option>
							</select>
							<input type="text" id="txtCertName" class="form-control" placeholder="시험명">
							<input type="text" id="txtCertAgency" class="form-control" placeholder="주최기관">
							<input type="text" id="txtCertGrade" class="form-control" placeholder="점수 및 등급">
							<input type="date" id="txtCertRegdate" class="form-control" placeholder="취득일">
						</div>
					</div>
					<input type="button" value="추가" id="btnCertificateAdd" class="my-3 btn btn-outline-success">
					<div id="certList">
						
					</div>
				</div>
			</div>
			<div class="app-part">
				<div class="row">
					<div id="military" class="col-4">
						<div class="app-part-title">
							<h4>병역 사항</h4>
							<div class="app-part-title-detail"></div>
						</div>
						<div class="app-part-body">
							<select name="military" id="selMilitary" class="form-select">
								<option value="">병역사항 선택..</option>
								<c:forEach var="code" items="${MST}" varStatus="vs">
									<option value="${code.codeid}">${code.codename}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div id="rewarding" class="col-4">
						<div class="app-part-title">
							<h4>보훈 사항</h4>
							<div class="app-part-title-detail"></div>
						</div>
						<div class="app-part-body">
							<select name="rewarding" id="selRewarding" class="form-select">
								<option value="false">미대상</option>
								<option value="true">대상</option>
							</select>
						</div>
					</div>
					<div id="handicap" class="col-4">
						<div class="app-part-title">
							<h4>장애 정보</h4>
							<div class="app-part-title-detail"></div>
						</div>
						<div class="app-part-body">
							<select name="handicap" id="selHandicap" class="form-select">
								<option value="">장애정보 선택..</option>
								<c:forEach var="code" items="${DAT}" varStatus="vs">
									<option value="${code.codeid}">${code.codename}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
			</div>
		</div>
		${adDto }
	</div>
	<script type="text/javascript">
		window.onload = () => { application.init() }
	</script>

<script type="text/html" id="careerTemplete">
	<div>
		<div class="my-1 row">
			<div class="col-4"><input type="text" class="form-control" placeholder="회사명" disabled></div>
			<div class="col-2"><input type="text" class="form-control" placeholder="유형" disabled></div>
			<div class="col-2"><input type="text" class="form-control" placeholder="직급" disabled></div>
			<div class="col-2"><input type="date" class="form-control" placeholder="입사일" disabled></div>
			<div class="col-2"><input type="date" class="form-control" placeholder="퇴사일" disabled></div>
		</div>
		<div class="my-1 row">
			<div class="col-12"><input type="text" class="form-control" placeholder="담당업무" disabled></div>
		</div>
		<input type="button" value="수정" class="btn btn-outline-success" onclick="career.modify(this)">
		<input type="button" value="삭제" class="btn btn-outline-danger" onclick="application.delete(this)">
	</div>
</script>
<script type="text/html" id="projectExpTemplete">
	<div>
		<div class="my-1 row">
			<div class="col-8"><input type="text" class="form-control" placeholder="프로젝트 명" disabled></div>
			<div class="col-2"><input type="date" class="form-control" placeholder="시작일" disabled></div>
			<div class="col-2"><input type="date" class="form-control" placeholder="종료일" disabled></div>
		</div>
		<div class="my-1 row">
			<div class="col-6"><input type="text" class="form-control" placeholder="회사명" disabled></div>
			<div class="col-6"><input type="text" class="form-control" placeholder="직무" disabled></div>
		</div>
		<div class="my-1 row">
			<div class="col-12">
				<textarea cols="30" rows="4" class="form-control" placeholder="담당업무" disabled></textarea>
			</div>
		</div>
		<input type="button" value="수정" class="btn btn-outline-success" onclick="projectExp.modify(this)">
		<input type="button" value="삭제" class="btn btn-outline-danger" onclick="application.delete(this)">
	</div>
</script>
<script type="text/html" id="eduTemplete">
	<div class="input-group">
		<select class="form-select" disabled>
			<option value="">학력 선택..</option>
			<c:forEach var="code" items="${ADB}" varStatus="vs">
				<option value="${code.codeid}">${code.codename}</option>
			</c:forEach>
		</select>
		<input type="text" class="form-control" placeholder="학교명" disabled>
		<input type="text" class="form-control" placeholder="전공" disabled>
		<input type="text" class="form-control" placeholder="평점/총점" disabled>
		<input type="date" class="form-control" placeholder="입학년월일" disabled>
		<input type="date" class="form-control" placeholder="졸업년월일" disabled>
		<select class="form-select" disabled>
			<option value="">졸업상태 선택..</option>
			<c:forEach var="code" items="${GDS}" varStatus="vs">
				<option value="${code.codeid}">${code.codename}</option>
			</c:forEach>
		</select>
		<input type="button" value="수정" class="btn btn-outline-success" onclick="education.modify(this)">
		<input type="button" value="삭제" class="btn btn-outline-danger" onclick="application.delete(this)">
	</div>
</script>
<script type="text/html" id="certTemplete">
	<div class="input-group">
		<select class="form-select" disabled>
			<option value="자격증">자격증</option>
			<option value="수상정보">수상정보</option>
		</select>
		<input type="text" class="form-control" placeholder="시험명" disabled>
		<input type="text" class="form-control" placeholder="주최기관" disabled>
		<input type="text" class="form-control" placeholder="점수 및 등급" disabled>
		<input type="date" class="form-control" placeholder="취득일" disabled>
		<input type="button" value="수정" class="btn btn-outline-success" onclick="certificate.modify(this)">
		<input type="button" value="삭제" class="btn btn-outline-danger" onclick="application.delete(this)">
	</div>
</script>
<%@include file="/footer.jsp" %>