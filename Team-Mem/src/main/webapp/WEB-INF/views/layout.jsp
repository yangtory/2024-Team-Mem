<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<%@ include file="/WEB-INF/views/teacher/home.jsp"%>
			</c:if>
			<!-- 승희 -->
			<c:if test="${BODY == 'USER_LIST'}">
				<%@ include file="/WEB-INF/views/user/list.jsp"%>

			</c:if> 
			<c:if test="${BODY == 'USER_INSERT'}">
				<%@ include file="/WEB-INF/views/user/input.jsp"%>
			</c:if>
			<c:if test="${BODY == 'USER_DETAIL'}">
				<%@ include file="/WEB-INF/views/user/detail.jsp"%>
			</c:if>
			<c:if test="${BODY == 'USER_UPDATE'}">
				<%@ include file="/WEB-INF/views/user/input.jsp"%>
			</c:if>
			<c:if test="${BODY == 'MAIN_LOGIN'}">
				<%@ include file="/WEB-INF/views/main/login.jsp"%>
			</c:if>
			<c:if test="${BODY == 'MAIN_JOIN'}">
				<%@ include file="/WEB-INF/views/main/join.jsp"%>
			</c:if>
		</section>
	</div>
</body>
</html>
