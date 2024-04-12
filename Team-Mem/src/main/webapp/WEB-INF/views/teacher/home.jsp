<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<h1>강사 리스트</h1>
	<c:forEach items="${LIST}" var="T" varStatus="INDEX">
		<ul>
			<li>${INDEX.count}</li>
			<li>${T.t_code}</li>
			<li>${T.t_name}</li>
		</ul>
	</c:forEach>

</div>
