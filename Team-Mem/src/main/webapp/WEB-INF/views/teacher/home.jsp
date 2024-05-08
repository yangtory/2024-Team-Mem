<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<h1 class="list_title">강사 리스트</h1>
<div class="list_home">
	<div class="teacher input insert_btn_box">
		<button class="teacher input insert button-32" type="button">강사추가</button>
	</div>
	<div class="teacher btn_box search">
		<f:form method="GET" modelAttribute="SEARCH">
			<f:input class="search_input" placeholder="이름" path="tname" />
			<f:input class="search_input" placeholder="강사코드" path="tcode" />
			<f:input class="search_input" placeholder="전화번호" path="ttel" />
			<button class="button-32" type="submit" value="검색">
				<img src="${rootPath }/static/images/search.png" width="10px"
					height="10px">
			</button>
		</f:form>
	</div>
	<div class="table_div">
		<table class="teacher list">
			<thead>
				<tr>
					<th>No.</th>
					<th>강사코드</th>
					<th>강사이름</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${SEARCH_LIST}" var="T" varStatus="INDEX">
					<tr data-code="${T.t_code }">
						<td>${INDEX.count }</td>
						<td>${T.t_code }</td>
						<td>${T.t_name }</td>
						<td>${T.t_tel }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
