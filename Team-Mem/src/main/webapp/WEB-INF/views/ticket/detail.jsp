<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<h1 class="list_title">${LIST.i_title} 정보</h1>
<div><strong>수강권 </strong><span>${LIST.i_title}</span></div>
<div><strong>가격</strong><span>${LIST.i_price}</span></div>
<div><strong>수강횟수</strong><span>${LIST.i_count}</span></div>
<div>
  <strong></strong
  ><span>
    <a href="${rootPath }/ticket/update/${LIST.i_seq}">수정</a>
    <a href="${rootPath }/ticket/delete/${LIST.i_seq}">삭제</a>
  </span>
</div>
