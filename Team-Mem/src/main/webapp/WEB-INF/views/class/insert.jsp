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


<f:form class="input form">
<div class="class error"></div>
	<fieldset>
	<legend>수업 정보</legend>
		<div><label>수업명</label><input  placeholder="수업명" name="c_name"/></div>
		<div>
			<select name="c_tcode">
			<option value="">--강사선택--</option>
			<c:forEach items="${TLIST }" var="TEACHER">
				<option value="${TEACHER.t_code }"${TEACHER.t_code == c_tcode ? 'selected' : ''} >${TEACHER.t_name}</option>
			</c:forEach>
			</select>	
		</div>
		
		
		<div><label>개강일자</label><input placeholder="개강일자" type="date" value="${SDATE }" name="c_sdate"/></div>
		<div><label>종강일자</label><input placeholder="종강일자" type="date" name="c_edate" /></div>
		<div><label>시작시간</label><input placeholder="시작시간" type="time" name="c_stime" /></div>
		<div><label>종료시간</label><input placeholder="종료시간" type="time" name="c_etime" /></div>
		
	</fieldset>

	<div><label></label><button type="button">작성</button></div>
	
</f:form>