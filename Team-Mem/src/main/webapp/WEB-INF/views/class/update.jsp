<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<style>
	.btnBox {
	display : flex;
	gap: 5px;
	}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath }/static/js/class/update.js"></script>

<f:form>
	<div><label>수업명</label><input placeholder="수업명" name="c_name" value="${LIST.c_name }"/></div>
	<div><label>강사명</label><input placeholder="강사명" value="${LIST.t_name}" name="t_name" readonly/></div>
	<div><label>개강일자</label><input placeholder="개강일자" type="date" value="${LIST.c_sdate }" name="c_sdate"/></div>
	<div><label>종강일자</label><input placeholder="종강일자" type="date" name="c_edate" value="${LIST.c_edate }" /></div>
	<div><label>시작시간</label><input placeholder="시작시간" name="c_stime" value="${LIST.c_stime }"/></div>
	<div><label>종료시간</label><input placeholder="종료시간" name="c_etime" value="${LIST.c_etime }"/></div>
	<div><input type="hidden" name="c_tcode" value="${LIST.c_tcode }"/></div>
	<div><input type="hidden" name="c_ccode" value="${LIST.c_ccode }"/></div>
	<div><input type="hidden" name="c_seq" value="${LIST.c_seq}"/></div>
	<div class="btnBox">
		<div><button type="submit">수정</button></div>
		<div><button type="button" data-seq = "${SEQ }">삭제</button></div>
	</div>
</f:form>