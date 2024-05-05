<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />



<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>맴</title>
    <style>
    
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        html {
            height: 100vh;
            color: #391145;
        }
        body {
            height: 100%;
            display: flex;
            flex-direction: column;
        }
        a {
            text-decoration: none;
        }
    </style>
    <link rel="stylesheet" href="${rootPath}/static/css/main.css" />
    <link rel="stylesheet" href="${rootPath}/static/css/table.css" />
    <link rel="stylesheet" href="${rootPath}/static/css/search.css" />
    <link rel="stylesheet" href="${rootPath}/static/css/input.css" />
    <link rel="stylesheet" href="${rootPath}/static/css/detail.css" />

    <script>
        const rootPath = '${rootPath}';
    </script>
    <script src="${rootPath}/static/js/main.js?2024-04-26-001"></script>
    <script src="${rootPath}/static/js/teacher.js?2024-04-18-002"></script>
</head>
