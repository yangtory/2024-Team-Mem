<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>맴</title>
<style>
	*{
		box-sizing : border-box;
		margin: 0;
		padding: 0;
	}
	html {
	 	height:100vh;
		color:#bec7d5;
	}
	body {
		height:100%;
		display: flex;
		flex-direction:column;
	}
	a {
		text-decoration:none;
	}
</style>
<link rel="stylesheet" href="${rootPath}/static/css/main.css?2024-04-17-010">
<link rel="stylesheet" href="${rootPath}/static/css/teacher.css?2024-04-16-001">
<script>
 	const rootPath = "${rootPath}" 
</script>
<script src="${rootPath}/static/js/main.js?2024-04-12-002"></script>
<script src="${rootPath}/static/js/teacher.js?2024-04-18-002"></script>

</head>