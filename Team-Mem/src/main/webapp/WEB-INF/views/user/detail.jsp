<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath ��� ������ �����ؼ� value�� ���� ��ڴ� -->
<!DOCTYPE html>

<div><strong>���̵�</strong><span>${LIST.us_uid}</span></div>
<div><strong>��ȭ��ȣ</strong><span>${LIST.us_utel}</span></div>
<div><strong>�̸�</strong><span>${LIST.us_uname}</span></div>
<div><strong>��ü�ڵ�</strong><span>${LIST.us_ccode}</span></div>
<div><strong>��ü��</strong><span>${LIST.us_cname}</span></div>
<div><strong></strong><span>
	<a href="${rootPath }/customer/update/${LIST.us_uid}">����</a>
	<a href="${rootPath }/customer/delete/${LIST.us_uid}">����</a>
</span></div>