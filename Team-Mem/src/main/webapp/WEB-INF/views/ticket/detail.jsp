<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div><strong>������ </strong><span>${LIST.i_title}</span></div>
<div><strong>����</strong><span>${LIST.i_price}</span></div>
<div><strong>����Ƚ��</strong><span>${LIST.i_count}</span></div>
<div><strong></strong><span>
	<a href="${rootPath }/ticket/update/${LIST.i_seq}">����</a>
	<a href="${rootPath }/ticket/delete/${LIST.i_seq}">����</a>
</span></div>