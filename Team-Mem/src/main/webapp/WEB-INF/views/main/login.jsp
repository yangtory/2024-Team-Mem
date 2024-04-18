<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
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

<f:form>
	<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null }">
		<div>${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
	</c:if>
	<div><input placeholder="USERNAME" name="u_id"/></div>
	<div><input placeholder="PASSWORD" name="u_password"/></div>
	<div><button>로그인</button></div>
</f:form>
</body>
</html>