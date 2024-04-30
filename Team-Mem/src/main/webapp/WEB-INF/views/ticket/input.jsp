<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<h1 class="list_title">회원권 등록</h1>
<div class="input_div">
<f:form class="ticket input_box">
	<div class="ticket error"></div>
	
	<label>업체코드</label><input value="${L != null ? L.i_ccode : CCODE}" name="i_ccode" readonly>
	<label>제목</label><input placeholder="제목" name="i_title" value="${L.i_title }" >
	<label>수강횟수</label><input placeholder="수강횟수" name="i_count" value="${L.i_count }" >
	<label>가격</label><input placeholder="가격" name="i_price" value="${L.i_price }" >
	<input type="button" class="insert button-32" value="${L != null ? '수정' : '추가' }">
</f:form>
</div>