<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div><strong>수강권 </strong><span>${LIST.i_title}</span></div>
<div><strong>가격</strong><span>${LIST.i_price}</span></div>
<div><strong>수강횟수</strong><span>${LIST.i_count}</span></div>
<div><strong></strong><span>
	<a href="${rootPath }/ticket/update/${LIST.i_seq}">수정</a>
	<a href="${rootPath }/ticket/delete/${LIST.i_seq}">삭제</a>
</span></div>