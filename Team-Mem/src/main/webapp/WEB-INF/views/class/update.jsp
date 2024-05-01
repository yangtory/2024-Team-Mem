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
<div class="update">
<f:form class="update">
	<div class="inputbox">
	<fieldset>
	<legend>수업추가</legend>
	<div><label>수업명</label><input placeholder="수업명" name="c_name" value="${LIST.c_name }"/></div>
	<div><label>강사명</label><input placeholder="강사명" value="${LIST.t_name}" name="t_name" readonly/></div>
	<div><label>개강일자</label><input placeholder="개강일자" type="date" value="${LIST.c_sdate }" name="c_sdate"/></div>
	<div><label>종강일자</label><input placeholder="종강일자" type="date" name="c_edate" value="${LIST.c_edate }" /></div>
	<div><label>시작시간</label><input placeholder="시작시간" name="c_stime" value="${LIST.c_stime }"/></div>
	<div><label>종료시간</label><input placeholder="종료시간" name="c_etime" value="${LIST.c_etime }"/></div>
	<div><label>색상</label><input type="color" id="colorPicker" value="${LIST.c_color }" name="c_color"></div>
	<div class="btnBox">
	<div><label></label><button type="submit" class="insert button-32">수정</button></div>
	<div><label></label><button type="button" class="insert button-32" data-seq = "${SEQ }">삭제</button></div>
	</div>
	<div><input type="hidden" name="c_tcode" value="${LIST.c_tcode }"/></div>
	<div><input type="hidden" name="c_ccode" value="${LIST.c_ccode }"/></div>
	<div><input type="hidden" name="c_seq" value="${LIST.c_seq}"/></div>
	</fieldset>
	</div>
</f:form>
</div>