<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath }/static/js/class/update.js"></script>
<link href="${rootPath }/static/css/classUpdate.css" rel="stylesheet">

<h1 class="list_title">수업 수정</h1>
<div class="update input_div">
<f:form class="input_box">
	<div class="class error"></div>
	<input type="hidden" name="c_tcode" value="${LIST.c_tcode }"/>
	<input type="hidden" name="c_ccode" value="${LIST.c_ccode }"/>
	<input type="hidden" name="c_seq" value="${LIST.c_seq}"/>
	<label>수업명</label><input placeholder="수업명" name="c_name" value="${LIST.c_name }"/>
	<label>강사명</label><input placeholder="강사명" value="${LIST.t_name}" name="t_name" readonly/>
	<label>개강일자</label><input placeholder="개강일자" type="date" value="${LIST.c_sdate }" name="c_sdate"/>
	<label>종강일자</label><input placeholder="종강일자" type="date" name="c_edate" value="${LIST.c_edate }" />
	<label>시작시간</label><input placeholder="시작시간" type="time" name="c_stime" value="${LIST.c_stime }"/>
	<label>종료시간</label><input placeholder="종료시간" type="time" name="c_etime" value="${LIST.c_etime }"/>
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
	<input type="hidden" id="colorPicker" value="${LIST.c_color }" name="c_color">
	<div class="schedule">
	<input type="button" class="insert" value="수정">
	<input type="button" class="delete" data-seq = "${SEQ }" value="삭제">
	</div>
		
</f:form>
</div>