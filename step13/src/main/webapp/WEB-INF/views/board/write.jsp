<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- 현재 요청이 작성(write)인지 갱신(update)인지 확인 --%>
<c:choose>
    <c:when test="${not empty board}">
        <c:set var="action" value="update" />
        <c:set var="title" value="Update the post" />
    </c:when>
    <c:otherwise>
        <c:set var="action" value="write" />
        <c:set var="title" value="Write a new post" />
    </c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <style>
        #container { width: 800px; }
        #container > form > p > label { display: block; }
        #container > form > p > input[type="text"],
        #container > form > p > textarea {
            display: block; width: 100%; box-sizing: border-box; font: 1em sans-serif;
        }
        #container > form > p > textarea { line-height: 1.5; height: 12em; }
    </style>
</head>
<body>

    <div id="container">
        <h1>${title}</h1>

        <form action="${action}" method="post">
<c:choose>
    <c:when test="${action == 'update'}">
            <input type="hidden" name="id" value="${board.id}">
            <input type="hidden" name="page" value="${criteria.page}">
            <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}">
    </c:when>
</c:choose>

            <p>
                <label>Title:</label>
                <input type="text" name="title" value="${board.title}">
            </p>
            <p>
                <label>Writer:</label>
                <input type="text" name="writer" value="${board.writer}">
            </p>
            <p>
                <label>Content:</label>
                <textarea name="content">${board.content}</textarea>
            </p>
            <p>
                <input type="submit" name="submit" value="${fn:toUpperCase(action)}">
            </p>
        </form>
    </div> <!-- /#container -->

</body>
</html>
