<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<script>const rootPath = "${rootPath}"</script>
<script src="${rootPath }/static/js/userInput.js"></script>
<!DOCTYPE html>
<div>
	<f:form class="formBox">
		<div><input class ="us_uid" placeholder="유저ID" name="us_uid" value="${COMP.us_uid }"/></div>
		<div><input class ="us_uname" placeholder="이름" name="us_uname" value="${COMP.us_uname }"/></div>
		<div><input class ="us_utel" placeholder="전화번호" name="us_utel" value="${COMP.us_utel }"/></div>
		<div><input class ="us_cname" placeholder="업체명" name="us_cname" value="${CNAME}" readonly/></div>
		<div><input class ="us_ccode" placeholder="업체코드" name="us_ccode" value="${CCODE}" readonly/></div>
		<div><button>저장</button></div>
	</f:form>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${USER }" var="USER">
				<tr data-id = "${USER.u_id }">
					<td>${USER.u_id }</td>
					<td>${USER.u_name }</td>
					<td>${USER.u_tel}</td>
				</tr>
			</c:forEach>
		</tbody>		
	</table>
</div>

