<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<h1 class="list_title">${MINFO.r_uid } 회원님 수강권 수정</h1>
<div class="input_div">
<f:form class="ticket input_box">
	<div class="ticket error"></div>
	
	<label>제목</label><input placeholder="제목" value="${MINFO.i_title }" readonly style="pointer-events: none" >
	<label>수강횟수</label><input type="number" min="10" max="100" placeholder="수강횟수" name="r_icount" value="${MINFO.r_icount }" >
	<label>시작일</label><input type="date" name="r_sdate" value="${MINFO.r_sdate }" >
	<label>종료일</label><input type="date" name="r_edate" value="${MINFO.r_edate }" >
	<input type="submit" class="insert button-32" value="수정">
</f:form>
</div>