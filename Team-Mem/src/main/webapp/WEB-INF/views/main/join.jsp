<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<f:form class="join">
	<div class="join error"></div>
	<div><label>USERNAME</label><input placeholder="USERNAME" name="u_id"/></div>
	<div><label>PASSWORD</label><input placeholder="PASSWORD" name="u_password"/></div>
	<div><label>이름</label><input placeholder="NAME" name="u_name"/></div>
	<div><label>주소</label><input placeholder="ADDRESS" name="u_addr"/></div>
	<div><label>전화번호</label><input placeholder="TEL" name="u_tel"/></div>
	<div><label>업체명</label><input placeholder="업체명" name="u_comp"/></div>
	<div><button type="button" class="join_btn">회원가입</button></div>
</f:form>
