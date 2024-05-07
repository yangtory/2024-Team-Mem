<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath }/static/js/userInput.js"></script>
<script src="${rootPath }/static/js/minfoInput.js"></script>

<div class="input_div">
	<f:form class="formBox input_box">
		<h3>회원 정보</h3>
		<div class="user_error"></div>
		<label>ID</label>
		<input class="us_uid" name="us_uid" value="${COMP.us_uid }" readonly />
		<label>이름</label>
		<input class="us_uname" name="us_uname" value="${COMP.us_uname } "
			readonly />
		<input class="us_utel" type="hidden" placeholder="전화번호" name="us_utel"
			value="${COMP.us_utel }" />
		<input type="hidden" class="us_cname" placeholder="업체명"
			name="us_cname" value="${CNAME}" readonly />
		<input type="hidden" class="us_ccode" placeholder="업체코드"
			name="us_ccode" value="${CCODE}" readonly />

		<h3>수강권 정보</h3>
		<div class="m_error"></div>
		<div class="selectBox">
			<select class="select" name="r_iseq">
				<option value="0">--수강권선택--</option>
				<c:forEach items="${MINFO }" var="M">
					<option value="${M.i_seq}">${M.i_title}</option>
				</c:forEach>
			</select>
		</div>
		<label>수강권횟수</label>
		<input class="r_icount" placeholder="수강권횟수" name="r_icount" readonly>
		<label>시작일</label>
		<input class="r_sdate" type="date" name="r_sdate">
		<label>종료일</label>
		<input class="r_edate" type="date" name="r_edate">

		<input type="button" value="저장" class="insert">
	</f:form>
</div>
