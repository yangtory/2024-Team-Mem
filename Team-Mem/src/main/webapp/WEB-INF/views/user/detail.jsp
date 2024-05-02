<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>

<div><strong>ID</strong><span>${LIST.us_uid}</span></div>
<div><strong>전화번호</strong><span>${LIST.us_utel}</span></div>
<div><strong>업체코드</strong><span>${LIST.us_ccode}</span></div>
<div><strong>업체명</strong><span>${LIST.us_cname}</span></div>
<div><strong>이름</strong><span>${LIST.us_uname}</span></div>

<div>
  <strong></strong
  ><span>
    <a class="button-32" href="${rootPath }/customer/update/${LIST.us_uid}">수정</a>
    <a class="button-32" href="${rootPath }/customer/delete/${LIST.us_uid}">삭제</a>
    <a class="button-32" href="${rootPath }/customer/tickinfo/${LIST.us_uid}">회원권 정보</a>
  </span>
</div>
