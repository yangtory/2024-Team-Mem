<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<h1 class="list_title">수강권 정보</h1>
<div class="detail_box">
  <div class="card">
    <h3>${LIST.i_title}</h3>
    <div class="container">
      <p>현재 2명 이용중입니다</p>
      <hr />
      <div class="info">
        <div>
          <strong>가격</strong>
          <p>${LIST.i_price}</p>
        </div>
        <div>
          <strong>수강횟수</strong>
          <p>${LIST.i_count} 회</p>
        </div>
      </div>
    </div>
    <div class="detail btn_box">
      <a
        class="button-32"
        href="${rootPath }/ticket/update/${LIST.i_seq}"
        >수정</a
      >
      <a
        class="button-32"
        href="${rootPath }/ticket/delete/${LIST.i_seq}"
        >삭제</a
      >
    </div>
  </div>
</div>
