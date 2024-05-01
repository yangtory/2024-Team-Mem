<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<h1 class="list_title">강사 등록</h1>
<div class="input_div">
<f:form class="teacher input_box">
	<div class="teacher error"></div>
	<label>업체코드</label><input value="${VO != null ? VO.t_ccode : COMP}" name="t_ccode" readonly>
	<label>강사코드</label><input value="${VO != null ? VO.t_code : TCODE}" name="t_code" readonly>
	<label>강사이름</label><input placeholder="강사이름" name="t_name" value="${VO.t_name}">
	<label>전화번호</label><input placeholder="전화번호" name="t_tel" value="${VO.t_tel}">
	<input type="button" class="insert" value="${VO != null ? '수정' : '추가' }">
</f:form>
</div>