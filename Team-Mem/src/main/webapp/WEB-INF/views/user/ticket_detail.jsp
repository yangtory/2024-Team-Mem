<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${rootPath}/static/css/detail.css" />
<h1 class="list_title">${MINFO.r_uid } 회원님 수강권 정보</h1>
<div class="detail_box">
  <div class="card">
    <h3>${MINFO.i_title}</h3>
    <div class="container">
      <p>현재 D${DDAY } 남았습니다</p>
      <hr />
      <div class="info">
        <div>
          <strong>가격</strong>
          <p>${MINFO.i_price}</p>
        </div>
        <div>
          <strong>잔여횟수</strong>
          <p>${MINFO.r_icount} 회</p>
        </div>
        <div>
          <strong>기간</strong>
          <p>${MINFO.r_sdate} ~ ${MINFO.r_edate }</p>
        </div>
      </div>
    </div>
    <div class="detail btn_box">
      <a
        class="button-32"
        href="${rootPath }/customer/tickupdate/${MINFO.r_uid}/${MINFO.r_iseq}"
        >수정</a
      >
      <a
        class="button-32"
        href="${rootPath }/customer/tickdelete/${MINFO.r_uid}/${MINFO.i_seq}"
        >삭제</a
      >
    </div>
  </div>
</div>
