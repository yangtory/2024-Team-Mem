<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath }/static/js/class/insert.js"></script>
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

<h1 class="list_title">수업 등록</h1>
<div class="input_div">
<f:form class="input_box">
<div class="class error"></div>
		<label>수업명</label><input placeholder="수업명" name="c_name"/>
			<label>강사</label>
			<div class="selectBox">
			<select name="c_tcode">
			<option value="">강사선택</option>
			<c:forEach items="${TLIST }" var="TEACHER">
				<option value="${TEACHER.t_code }"${TEACHER.t_code == c_tcode ? 'selected' : ''} >${TEACHER.t_name}</option>
			</c:forEach>
			</select>	
		</div>
		<label>시작일자</label><input placeholder="시작일자" type="date" value="${SDATE }" name="c_sdate"/>
		<label>종료일자</label><input placeholder="종료일자" type="date" name="c_edate" />
		<label>시작시간</label><input placeholder="시작시간" type="time" min = "00:00" max="24:00" name="c_stime" />
		<label>종료시간</label><input placeholder="종료시간" type="time" name="c_etime" />
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
		<input type="hidden" id="colorPicker" value="#ffffff" name="c_color">
	<input type="button" class="insert" value="작성" />
	
</f:form>
</div>