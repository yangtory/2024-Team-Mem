<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div><strong>��ü�ڵ�</strong><span>${LIST.t_ccode}</span></div>
<div><strong>�����ڵ�</strong><span>${LIST.t_code}</span></div>
<div><strong>�̸�</strong><span>${LIST.t_name}</span></div>
<div><strong>��ȭ��ȣ</strong><span>${LIST.t_tel}</span></div>
<div><strong></strong><span>
	<a href="${rootPath }/teacher/update/${LIST.t_code}">����</a>
	<a href="${rootPath }/teacher/delete/${LIST.t_code}">����</a>
</span></div>