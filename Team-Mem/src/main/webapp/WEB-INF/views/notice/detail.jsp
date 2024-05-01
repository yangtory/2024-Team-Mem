<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div><strong>제목</strong><span>${VO.n_title}</span></div>
<div><strong>내용</strong><span>${VO.n_content}</span></div>
<div>
  <strong></strong
  ><span>
    <a href="${rootPath }/notice/update/${VO.n_seq}">수정</a>
    <a href="${rootPath }/notice/delete/${VO.n_seq}">삭제</a>
  </span>
</div>
