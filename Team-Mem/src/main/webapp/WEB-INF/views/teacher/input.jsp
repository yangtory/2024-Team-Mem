<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<f:form class="teacher input_box">
	<div><label>강사코드</label><input placeholder="강사코드" name="t_code"></div>
	<div><label>강사이름</label><input placeholder="강사이름" name="t_name"></div>
	<div><label>전화번호</label><input placeholder="전화번호" name="t_tel"></div>
	<div><button type="button" class="insert">추가</button></div>
</f:form>