<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${rootPath}/static/css/detail.css" />
<h1 class="list_title">${MINFO.r_uid } 회원님 수강권 정보</h1>
<div class="detail_box">
  <div class="card">
    <h3>${MINFO.i_title}</h3>
    <div class="container">
      <c:choose>
        <c:when test="${DDAY < 0}">
          <p>현재 <span class="dday">D${DDAY }</span> 남았습니다</p>
        </c:when>
        <c:otherwise>
          <p>기간이 만료되었습니다</p>
        </c:otherwise>
      </c:choose>
      <hr />
      <div class="info">
        <div>
          <strong>가격</strong>
          <p>
            <fmt:formatNumber
              value="${MINFO.i_price}"
              pattern="#,###"
            />
          </p>
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
        class="button-32 minfo_delete_btn"
        href="${rootPath }/customer/tickdelete/${MINFO.r_uid}/${MINFO.i_seq}"
        >삭제</a
      >
    </div>
  </div>
</div>
