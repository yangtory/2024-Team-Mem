<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Board List</title>
    <style>

        #pageInfo { text-align: right; }

        #pagination {
            list-style-type: none;
            padding: 0;
            margin: 1em 0;
            font: 0.825em Tahoma, Verdana, sans-serif;
        }

        #pagination > li {
            display: inline-block;
            border: 1px solid #aaa;
        }

        #pagination > li > a,
        #pagination > li > span {
            display: block;
            padding: 0.3em 0.6em;
        }

        #pagination > li > a { text-decoration: none; }

        #pagination > li > span {
            background-color: #555;
            font-weight: bold;
            color: white;
        }

    </style>
</head>
<body>

    <h1>Board List</h1>

    <p id="pageInfo">
        ${pageMaker.criteria.page} / ${pageMaker.lastPage}
    </p>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Writer</th>
                <th>Date</th>
                <th>Last Updated</th>
            </tr>
        </thead>
        <tbody>
<c:forEach items="${list}" var="board">
            <tr>
                <td>${board.id}</td>
                <td><a href="read?id=${board.id}&page=${pageMaker.criteria.page}">${board.title}</a></td>
                <td>${board.writer}</td>
                <td>${board.regdate}</td>
                <td>${board.updatedate}</td>
            </tr>
</c:forEach>
        </tbody>
    </table>

    <ul id="pagination">
<c:if test="${pageMaker.startPage != 1}">
        <li><a href="list">First</a></li>
</c:if>
<c:if test="${pageMaker.prev}">
        <li><a href="list?page=${pageMaker.startPage - 1}">Prev</a></li>
</c:if>
<c:forEach var="page" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
    <c:choose>
        <c:when test="${page != pageMaker.criteria.page}">
        <li><a href="list?page=${page}">${page}</a></li>
        </c:when>
        <c:otherwise>
        <li><span>${page}</span></li>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${pageMaker.next}">
        <li><a href="list?page=${pageMaker.endPage + 1}">Next</a></li>
</c:if>
<c:if test="${pageMaker.lastPage != pageMake.endPage}">
        <li><a href="list?page=${pageMaker.lastPage}">Last</a></li>
</c:if>
    </ul>

    <p>
        [<a href="write">Write</a>]
    </p>

</body>
</html>
