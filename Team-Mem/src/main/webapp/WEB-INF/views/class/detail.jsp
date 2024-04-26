<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<script>
	const rootPath = "${rootPath}"
</script>
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

<a href="${rootPath }/class/insert/${SDATE }">추가</a>
<table class="schedule list">
	<thead>
		<tr>
			<th>SEQ</th>
			<th>제목</th>
			<th>내용</th>
			<th>시작일자</th>
			<th>종료일자</th>

		</tr>

	</thead>

	<tbody class="body">
		
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
	
	
	</tbody>

</table>
