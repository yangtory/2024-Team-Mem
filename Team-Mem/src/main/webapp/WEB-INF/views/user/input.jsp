<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<script>const rootPath = "${rootPath}"</script>
<script src="${rootPath }/static/js/userInput.js"></script>
<script src="${rootPath }/static/js/minfoInput.js"></script>
<link href="${rootPath }/static/css/addUser.css" rel="stylesheet" >



<div class="userBox">
<div class="left">
<h1 class="list_title">회원등록</h1>
	<f:form class="formBox">
		<fieldset>
		<legend>회원 정보</legend>
			<div><label>ID</label><input class ="us_uid" placeholder="유저ID" name="us_uid" value="${COMP.us_uid }" readonly/></div>
			<div><label>이름</label><input class ="us_uname" placeholder="이름" name="us_uname" value="${COMP.us_uname } " readonly/></div>
			<div><input class ="us_utel" type="hidden" placeholder="전화번호" name="us_utel" value="${COMP.us_utel }"/></div>
			<div><label>업체명</label><input class ="us_cname" placeholder="업체명" name="us_cname" value="${CNAME}" readonly/></div>
			<div><label>업체코드</label><input class ="us_ccode" placeholder="업체코드" name="us_ccode" value="${CCODE}" readonly/></div>
		</fieldset>
		<fieldset class="form minfo">
			<legend>수강권 정보</legend>
			<div><label></label>
				<select name="r_iseq">
					<option>--수강권선택--</option>
					<c:forEach items="${MINFO }" var="M">
						<option value="${M.i_seq}" ${UMINFO.r_iseq == M.i_seq ? 'selected' : ''}>${M.i_title}</option>
					</c:forEach> 
				</select>
			</div>
			<div><label>수강권횟수</label><input class ="r_icount" placeholder="수강권횟수" name ="r_icount" value="${UMINFO.r_icount }" ></div>
			<div><label>시작일</label><input class ="r_sdate" type="date" name ="r_sdate" value="${UMINFO.r_sdate }" ></div>
			<div><label>종료일</label><input class ="r_edate" type="date" name ="r_edate" value="${UMINFO.r_edate }" ></div>
		</fieldset>
		<div class="button"><input type= "submit" value="${COMP != null ? '수정' : '저장' }"></div>
	</f:form>
	</div>
	<c:if test="${COMP == null}">
		
		<div class="right"><h1 class="list_title">회원리스트</h1>
		<table class="list">
			<thead>
				<tr>
					<th>ID</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${USER }" var="USER">
					<tr data-id = "${USER.u_id }">
						<td>${USER.u_id }</td>
						<td>${USER.u_name }</td>
					</tr>
				</c:forEach>
			</tbody>		
		</table>
		</div>
	</c:if>
	</div>

