<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div><strong>����</strong><span>${VO.n_title}</span></div>
<div><strong>����</strong><span>${VO.n_content}</span></div>
<div><strong></strong><span>
	<a href="${rootPath }/notice/update/${VO.n_seq}">����</a>
	<a href="${rootPath }/notice/delete/${VO.n_seq}">����</a>
</span></div>