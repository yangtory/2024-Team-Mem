<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath }/static/js/calendar/detail.js"></script>
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

	<f:form>
		<div><input placeholder="제목" name="s_title" value="${LIST.s_title }"/></div>
		<div><input placeholder="내용" name="s_content" value="${LIST.s_content }"/></div>
		<div><input placeholder="시작날" name="s_sdate" value="${LIST.s_sdate }" type="date" /></div>
		<div><input placeholder="마무리날" name="s_edate" type="date" value="${LIST.s_edate }"/></div>
		<div><button type="submit">수정</button></div>
		<div><button type="button" class="delete" data-seq="${SEQ}">삭제</button></div>
	
	</f:form>
	
	
