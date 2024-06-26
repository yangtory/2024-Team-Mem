<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="${rootPath }/static/css/class.css" rel="stylesheet" />
<script>
  const rootPath = "${rootPath}";
</script>
<script src="${rootPath }/static/js/class/class.js"></script>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

<h1 class="list_title">수업 관리</h1>
<body>
  <section>
    <div class="section_box">
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
          <div class="cal_wrapper">
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
        </div>
      </aside>
      <aside class="right"></aside>
    </div>
  </section>
</body>
