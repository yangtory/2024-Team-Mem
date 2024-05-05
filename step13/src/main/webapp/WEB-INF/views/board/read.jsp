<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${boardVO.title}</title>
    <script>
        window.addEventListener('load', function () {
            document.getElementById('delete').addEventListener('click', function (event) {
                if (!window.confirm('Are you sure to delete the post?'))
                    event.preventDefault();
            });
        });
    </script>
</head>
<body>

    <div id="container">
        <h1>${boardVO.title}</h1>

        <ul id="info">
            <li>ID: ${boardVO.id}</li>
            <li>Writer: ${boardVO.writer}</li>
            <li>Date: ${boardVO.regdate}</li>
            <li>Last Updated: ${boardVO.updatedate}</li>
        </ul>

        <p>${boardVO.content}</p>

        <hr>

        <p>
            [<a href="list?page=${criteria.page}">List</a>]
            [<a href="update?id=${boardVO.id}&page=${criteria.page}">Update</a>]
            [<a href="delete?id=${boardVO.id}&page=${criteria.page}" id="delete">Delete</a>]
        </p>
    </div> <!-- /#container -->

</body>
</html>
