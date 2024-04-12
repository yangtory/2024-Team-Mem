<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/head.jspf"%>


<body>
<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<div class="main">
		<%@ include file="/WEB-INF/views/include/sidebar.jspf"%>
		<section>
			
		
			<a href="${rootPath }/insert">수강생 추가</a>
			
			
			<table></table>
			
		
		</section>
	</div>
	
		
		

</body>
</html>