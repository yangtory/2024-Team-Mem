<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<script src="${rootPath }/static/js/userList.js"></script>
<script>
const rootPath = "${rootPath}"
</script>
<!DOCTYPE html>
<div class="customer btn_box">
	<f:form method="GET" modelAttribute="SEARCH">
		<f:input placeholder="아이디" path="uid" />
		<f:input placeholder="이름" path="uname" />
		<f:input placeholder="전화번호" path="utel" />
		<input type="submit" value="검색" />
	</f:form>
</div>

<a href="${rootPath }/customer/insert">수강생 추가</a>
<div>
	<c:if test="${not empty CCODE}">회사 코드 : <c:out value="${CCODE}"/>
</c:if>
</div>
<table class="customer list">
	<thead>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>전화번호</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${USER }" var="USER">
			<tr data-id="${USER.us_uid }">
				<td>${USER.us_uid }</td>
				<td>${USER.us_uname }</td>
				<td>${USER.us_utel }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>









