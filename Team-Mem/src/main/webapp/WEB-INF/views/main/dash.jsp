<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<div class="login_wrap">
	<form class="login">
	<h1>환영합니다</h1>
	<div>
		<p>맴맴은 처음이신가요?</p>
		<button type="button" class="login_btn button-32">로그인</button>
		<button type="button" class="login_btn button-32">회원가입</button>
	</div>
	</form>
</div>
