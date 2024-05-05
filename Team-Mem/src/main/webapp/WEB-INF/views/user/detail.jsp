<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="${rootPath }/static/js/userInput.js"></script>

<h1 class="list_title">${LIST.us_uid} 님의 정보</h1>
<div class="detail_box">
    <div class="card">
        <div class="container">
            <div class="info">
                <div class="info head">
                    <strong>ID</strong>
                    <p>${LIST.us_uid}</p>

                    <strong>전화번호</strong>
                    <p>${LIST.us_utel}</p>
                    <a class="message_btn button-32"
                        ><img src="${rootPath }/static/images/mail.png" width="10px" height="10px" />message</a
                    >
                </div>
                <div>
                    <strong>업체코드</strong>
                    <p>${LIST.us_ccode}</p>
                </div>
                <div>
                    <strong>업체명</strong>
                    <p>${LIST.us_cname}</p>
                </div>
                <div>
                    <strong>이름</strong>
                    <p>${LIST.us_uname}</p>
                </div>
            </div>
        </div>

        <div class="detail btn_box">
            <a class="button-32" href="${rootPath }/customer/update/${LIST.us_uid}">수정</a>
            <a class="delete_btn button-32" href="${rootPath }/customer/delete/${LIST.us_uid}">삭제</a>
            <a class="button-32" href="${rootPath }/customer/tickinfo/${LIST.us_uid}">회원권 정보</a>
        </div>
    </div>
</div>
