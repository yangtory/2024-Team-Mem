<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="${rootPath }/static/js/notice.js"></script>
<h1 class="list_title">공지사항 등록</h1>
<div class="input_div">
<f:form class="notice input_box">
	<label>제목</label><input name="n_title" value="${VO.n_title }">
	<label>내용</label><textarea name="n_content" rows="20" >${VO.n_content }</textarea>
	<input type="button" class="insert" value="${VO != null ? '수정' : '저장' }">
</f:form>
</div>