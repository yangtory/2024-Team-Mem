<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>const rootPath = "${rootPath}"</script>
<script src="${rootPath }/static/js/calendar/insert.js"></script>
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

<h1 class="list_title">일정 등록</h1>
<div class="input_div">
	<f:form class="input_box">
		<div class="class error"></div>
		<label>제목</label><input placeholder="제목" name="s_title" value="${LIST.s_seq }"/>
		<label>내용</label><input placeholder="내용" name="s_content"/>
		<label>시작일자</label><input placeholder="시작일자" name="s_sdate" value="${SDATE }" type="date" readonly/>
		<label>종료일자</label><input placeholder="종료일자" name="s_edate" type="date"/>
		<label>색상</label>
		<div class="palette">
			<div class="color color1"></div>
			<div class="color color2"></div>
			<div class="color color3"></div>
			<div class="color color4"></div>
			<div class="color color5"></div>
			<div class="color color6"></div>
			<div class="color color7"></div>
			<div class="color color8"></div>
		</div>
		<input type="hidden" id="colorPicker" value="#ffffff" name="s_color">
		<input class="insert" type="button" value="작성"></input>
	</f:form>
</div>