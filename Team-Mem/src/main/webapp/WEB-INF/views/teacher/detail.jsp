<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${rootPath}/static/css/teacher_detail.css" />
<h1 class="list_title">${LIST.t_name} 님의 정보</h1>
<div class="detail_box">
    <div class="card">
        <div class="img_box">
            <img src="${rootPath }/static/images/bug.png" width="200px" />
        </div>
        <div class="teacher_info">
            <div><strong>업체코드</strong><span>${LIST.t_ccode}</span></div>
            <div><strong>강사코드</strong><span>${LIST.t_code}</span></div>
            <div><strong>이름</strong><span>${LIST.t_name}</span></div>
            <div><strong>전화번호</strong><span>${LIST.t_tel}</span></div>
        </div>
        <div class="detail btn_box">
            <a class="button-32" href="${rootPath }/teacher/update/${LIST.t_code}">수정</a>
            <a class="button-32" href="${rootPath }/teacher/delete/${LIST.t_code}">삭제</a>
        </div>
    </div>
</div>
