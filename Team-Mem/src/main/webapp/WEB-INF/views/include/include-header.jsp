<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@
taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div class="header">
	<h3>
		<a href="${rootPath }">맴맴</a>
	</h3>
	<nav class="nav">
		<sec:authorize access="isAnonymous()">
			<a href="${rootPath }/main/login">로그인</a>
			<a href="${rootPath}/main/join">회원가입</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<div class="authenticated">
				<a href="${rootPath }/main/mypage"> <sec:authentication
						property="principal.u_name" /> 님
				</a>
				<f:form class="logout" action="${rootPath }/main/logout"
					onclick="this.submit()">로그아웃</f:form>
			</div>
		</sec:authorize>
	</nav>
</div>
