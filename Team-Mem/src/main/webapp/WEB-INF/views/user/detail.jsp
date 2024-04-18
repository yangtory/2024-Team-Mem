<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>

<div><strong>아이디</strong><span>${LIST.us_uid}</span></div>
<div><strong>전화번호</strong><span>${LIST.us_utel}</span></div>
<div><strong>이름</strong><span>${LIST.us_uname}</span></div>
<div><strong>업체코드</strong><span>${LIST.us_ccode}</span></div>
<div><strong>업체명</strong><span>${LIST.us_cname}</span></div>
<div><strong></strong><span>
	<a href="${rootPath }/customer/update/${LIST.us_uid}">수정</a>
	<a href="${rootPath }/customer/delete/${LIST.us_uid}">삭제</a>
</span></div>