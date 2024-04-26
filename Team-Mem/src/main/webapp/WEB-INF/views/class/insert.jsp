<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->


<f:form>
	<div><input placeholder="수업명" name="c_name"/></div>
	<div>
		<select name="c_tcode">
			<c:forEach items="${TLIST }" var="TEACHER">
				<option value="${TEACHER.t_name }"${TEACHER.t_name == } ></option>
			</c:forEach>
		</select>	
	</div>
	<div><input placeholder="개강일자" type="date" value="${SDATE }" name="c_sdate"/></div>
	<div><input placeholder="종강일자" type="date" name="c_edate" /></div>
	<div><input placeholder="시작시간" name="c_stime" /></div>
	<div><input placeholder="종료시간" name="c_etime" /></div>
	<div><button type="submit">작성</button></div>
</f:form>