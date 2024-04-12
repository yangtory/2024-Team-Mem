<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<div class="main">
		<%@ include file="/WEB-INF/views/include/sidebar.jspf"%>
		<section>
		<c:if test="${BODY == 'TEACHER_HOME'}">
			<%@ include file="/WEB-INF/views/teacher/home.jsp" %>
		</c:if>
		<!-- 승희 -->
		</section>
	</div>
</body>
</html>
