<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div class="side">
    <ul>
        <li class="ticket">
            <img src="${rootPath }/static/images/ticket.png" width="15px" height="15px" />
            회원권　
        </li>
        <li class="customer">
            <img src="${rootPath }/static/images/users.png" width="15px" height="15px" />
            회원관리
        </li>
        <li class="teacher">
            <img src="${rootPath }/static/images/teacher.png" width="15px" height="15px" />
            강사관리
        </li>
        <li class="class">
            <img src="${rootPath }/static/images/class.png" width="15px" height="15px" />
            수업관리
        </li>
        <li class="schedule">
            <img src="${rootPath }/static/images/cal.png" width="15px" height="15px" />
            일정관리
        </li>
        <li class="notice">
            <img src="${rootPath }/static/images/board.png" width="15px" height="15px" />
            공지사항
        </li>
    </ul>
</div>
