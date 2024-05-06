<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include-head.jsp"%>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jsp"%>
	<div class="main">
		<!-- 로그인 전 -->
		<sec:authorize access="isAnonymous()">
		<section>
			<c:if test="${BODY == 'HOME'}">
				<%@ include file="/WEB-INF/views/main/dash.jsp"%>
			</c:if>
			<c:if test="${BODY == 'MAIN_LOGIN'}">
				<%@ include file="/WEB-INF/views/main/login.jsp"%>
			</c:if>
			<c:if test="${BODY == 'MAIN_JOIN'}">
				<%@ include file="/WEB-INF/views/main/join.jsp"%>
			</c:if>
		</section>
		</sec:authorize>

		<!-- 로그인 후 -->
		<sec:authorize access="isAuthenticated()">
			<%@ include file="/WEB-INF/views/include/include-sidebar.jsp"%>
			<section>
				<c:if test="${BODY == 'TEACHER_HOME'}">
					<%@ include file="/WEB-INF/views/teacher/home.jsp"%>
				</c:if>
				<c:if test="${BODY == 'TEACHER_INSERT' }">
					<%@ include file="/WEB-INF/views/teacher/input.jsp"%>
				</c:if>
				<c:if test="${BODY == 'TEACHER_DETAIL' }">
					<%@ include file="/WEB-INF/views/teacher/detail.jsp"%>
				</c:if>
				<c:if test="${BODY == 'TICKET_HOME' }">
					<%@ include file="/WEB-INF/views/ticket/home.jsp"%>
				</c:if>
				<c:if test="${BODY == 'TICKET_INSERT' }">
					<%@ include file="/WEB-INF/views/ticket/input.jsp"%>
				</c:if>
				<c:if test="${BODY == 'TICKET_DETAIL' }">
					<%@ include file="/WEB-INF/views/ticket/detail.jsp"%>
				</c:if>
				<c:if test="${BODY == 'NOTICE_HOME' }">
					<%@ include file="/WEB-INF/views/notice/home.jsp"%>
				</c:if>
				<c:if test="${BODY == 'NOTICE_INSERT' }">
					<%@ include file="/WEB-INF/views/notice/input.jsp"%>
				</c:if>
				<c:if test="${BODY == 'NOTICE_DETAIL' }">
					<%@ include file="/WEB-INF/views/notice/detail.jsp"%>
				</c:if>
				<c:if test="${BODY == 'NOTICE_UPDATE' }">
					<%@ include file="/WEB-INF/views/notice/input.jsp"%>
				</c:if>
				<c:if test="${BODY == 'USER_TICK_INFO' }">
					<%@ include file="/WEB-INF/views/user/ticket_list.jsp"%>
				</c:if>
				<c:if test="${BODY == 'USER_TICK_DETAIL' }">
					<%@ include file="/WEB-INF/views/user/ticket_detail.jsp"%>
				</c:if>
				<c:if test="${BODY == 'USER_TICK_UPDATE' }">
					<%@ include file="/WEB-INF/views/user/ticket_update.jsp"%>
				</c:if>
				<c:if test="${BODY == 'USER_TICK_INSERT' }">
					<%@ include file="/WEB-INF/views/user/ticket_input.jsp"%>
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

				<c:if test="${BODY == 'SCHEDULE_MAIN'}">
					<%@ include file="/WEB-INF/views/schedule/main.jsp"%>
				</c:if>
				<c:if test="${BODY == 'SCHEDULE_INSERT'}">
					<%@ include file="/WEB-INF/views/schedule/input.jsp"%>
				</c:if>
				<c:if test="${BODY == 'SCHEDULE_DETAIL'}">
					<%@ include file="/WEB-INF/views/schedule/detail.jsp"%>
				</c:if>
				<c:if test="${BODY == 'SCHEDULE_UPDATE'}">
					<%@ include file="/WEB-INF/views/schedule/update.jsp"%>
				</c:if>
				<c:if test="${BODY == 'CLASS_MAIN'}">
					<%@ include file="/WEB-INF/views/class/main.jsp"%>
				</c:if>
				<c:if test="${BODY == 'CLASS_DETAIL'}">
					<%@ include file="/WEB-INF/views/class/detail.jsp"%>
				</c:if>
				<c:if test="${BODY == 'CLASS_INSERT'}">
					<%@ include file="/WEB-INF/views/class/insert.jsp"%>
				</c:if>
				<c:if test="${BODY == 'CLASS_UPDATE'}">
					<%@ include file="/WEB-INF/views/class/update.jsp"%>
				</c:if>
			</section>
		</sec:authorize>
	</div>
</body>
</html>
