<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<f:form class="notice input_box">
	<div><label>제목</label><input name="n_title" value="${VO.n_title }"></div>
	<div><label>내용</label><textarea name="n_content" rows="20" >${VO.n_content }</textarea>
</div>
	<div><input type="submit" class="insert" value="저장"></div>
</f:form>