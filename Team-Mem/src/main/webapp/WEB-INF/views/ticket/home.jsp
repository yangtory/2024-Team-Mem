<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<h1>회원권 리스트</h1>
<a href="${rootPath }/ticket/insert">수강권 추가</a>
<table class="ticket list">
	<thead>
		<tr>
			<th>No.</th>
			<th>수강권</th>
			<th>가격</th>
			<th>수강횟수</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${TICKET_LIST}" var="I" varStatus="INDEX">
			<tr data-seq="${I.i_seq}">
				<td>${INDEX.count }</td>
				<td>${I.i_title }</td>
				<td>${I.i_price }</td>
				<td>${I.i_count }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>