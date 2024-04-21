<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<a class="button-32" href="${rootPath }/notice/insert"> 글쓰기 </a>
<div class="notice search">
	<f:form method="GET" modelAttribute="SEARCH">
		<f:input placeholder="제목" path="title" />
		<f:input placeholder="등록일" path="date" />
		<f:input placeholder="등록번호" path="num" />
		<input type="submit" value="검색" />
	</f:form>
</div>

<table class="notice list">
	<thead>
		<tr>
			<th>No.</th>
			<th>업체명</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${SEARCH_LIST}" var="N" varStatus="INDEX">
			<tr data-code="${N.n_seq}">
				<td>${INDEX.count }</td>
				<td>${N.n_ccode }</td>
				<td>${N.n_title }</td>
				<td>${N.n_uid }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>