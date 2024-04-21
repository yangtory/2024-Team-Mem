<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div><strong>수강권 </strong><span>${LIST.t_ccode}</span></div>
<div><strong>가격</strong><span>${LIST.t_code}</span></div>
<div><strong>수강횟수</strong><span>${LIST.t_name}</span></div>
<div><strong>전화번호</strong><span>${LIST.t_tel}</span></div>
<div><strong></strong><span>
	<a href="${rootPath }/teacher/update/${LIST.t_code}">수정</a>
	<a href="${rootPath }/teacher/delete/${LIST.t_code}">삭제</a>
</span></div>