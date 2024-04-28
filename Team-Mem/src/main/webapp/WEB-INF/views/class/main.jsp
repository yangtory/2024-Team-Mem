<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="${rootPath }/static/css/class.css" rel="stylesheet">
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath }/static/js/class/class.js"></script>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->


<body>
	<section>
	<aside class="left">
		<div class="calendar">
			<div class="calHeader">
				<div class="year-month"></div>
				<div class="calNav">
					<button class="nav-btn go-prev">&lt;</button>
					<button class="nav-btn go-today">Today</button>
					<button class="nav-btn go-next">&gt;</button>
				</div>
			</div>
			<div class="calMain">
				<div class="days">
					<div class="day">일</div>
					<div class="day">월</div>
					<div class="day">화</div>
					<div class="day">수</div>
					<div class="day">목</div>
					<div class="day">금</div>
					<div class="day">토</div>
				</div>
				<div class="dates"></div>
			</div>
		</div>
		</aside>
	</section>
</body>