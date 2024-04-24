<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link href="rootPath/static/css/main.css?001" rel="stylesheet">
</head>
<body>
<table class="customer list">
	<a href="${rootPath }/detail/${LIST.s_sdate}">추가</a>
	<thead>
		<tr>
			<th>SEQ</th>
			<th>제목</th>
			<th>내용</th>
			<th>시작일자</th>
			<th>종료일자</th>

		</tr>

	</thead>

	<tbody>
		<c:forEach items="${LIST}" var="LIST">
			<tr data-id="${LIST.s_seq }">
				<td>${LIST.s_seq}</td>
				<td>${LIST.s_title}</td>
				<td>${LIST.s_content}</td>
				<td>${LIST.s_sdate}</td>
				<td>${LIST.s_edate}</td>
			</tr>
	
		</c:forEach>
	</tbody>

</table>


</body>
</html>