<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath }/static/js/class/detail.js"></script>
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

<a href="${rootPath }/class/insert/${SDATE }">추가</a>
<table class="schedule list">
	<thead>
		<tr>
			<th>SEQ</th>
			<th>수업명</th>
			<th>강사명</th>
			<th>개강일자</th>
			<th>종강일자</th>
			<th>시작시간</th>
			<th>종료시간</th>

		</tr>

	</thead>

	<tbody class="body">
		<c:forEach items="${LIST}" var="LIST" varStatus="INDEX">
			<tr data-seq = "${LIST.c_seq }" >
				<td>${INDEX.count}</td>
				<td>${LIST.c_name }</td>
				<td>${LIST.t_name }</td>
				
				<td>${LIST.c_sdate }</td>
				<td>${LIST.c_edate }</td>
				<td>${LIST.c_stime}</td>
				<td>${LIST.c_etime}</td>
			</tr>
	</c:forEach>
	
	</tbody>

</table>
