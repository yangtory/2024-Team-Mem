<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<f:form class="ticket input_box">
	<div><label>업체코드</label><input value="${CCODE}" name="i_ccode" readonly></div>
	<div><label>제목</label><input placeholder="제목" name="i_title" ></div>
	<div><label>수강횟수</label><input placeholder="수강횟수" name="i_count" ></div>
	<div><label>가격</label><input placeholder="가격" name="i_price" ></div>
	<div><button class="insert">추가</button></div>
</f:form>