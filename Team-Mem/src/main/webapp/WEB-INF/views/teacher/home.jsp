<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div>
	<h1>강사 리스트</h1>
	<div class="teacher btn_box">
		<f:form method="GET" modelAttribute="SEARCH">
			<f:input placeholder="이름" path="tname" />
			<f:input placeholder="강사코드" path="tcode" />
			<f:input placeholder="전화번호" path="ttel" />
			<input type="submit" value="검색" />
		</f:form>
	</div>

	<table class="teacher list">
		<thead>
			<tr>
				<th>No.</th>
				<th>강사코드</th>
				<th>강사이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${LIST}" var="T" varStatus="INDEX">
				<tr data-code="${T.t_code }">
					<td>${INDEX.count }</td>
					<td>${T.t_code }</td>
					<td>${T.t_name }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
