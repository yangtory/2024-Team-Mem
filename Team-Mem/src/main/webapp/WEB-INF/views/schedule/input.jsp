<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<div><input placeholder="제목" name="s_title"/></div>
		<div><input placeholder="내용" name="s_content"/></div>
		<div><input placeholder="시작날" name="s_sdate"/></div>
		<div><input placeholder="마무리날" name="s_edate"/></div>
		<div><button type="submit">작성</button></div>
	
	</f:form>
	
	
</body>
</html>