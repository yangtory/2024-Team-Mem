<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<f:form class="login">
	<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null }">
		<div>${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
	</c:if>
	<div class="login error"></div>
	<div><label>USERNAME</label><input name="u_id"/></div>
	<div><label>PASSWORD</label><input name="u_password"/></div>
	<div><button type="button" class="login_btn">로그인</button></div>
</f:form>