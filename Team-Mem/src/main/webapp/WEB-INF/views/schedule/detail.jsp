<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="${rootPath }/static/js/calendar/detail.js"></script>
<script>
  const rootPath = "${rootPath}";
</script>
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

<h1 class="list_title">일정 리스트</h1>
<div class="list_home">
  <div class="insert_btn_box">
    <a class="insert button-32" href="${rootPath }/schedule/insert/${SDATE}">일정 추가</a>
  </div>
  <table class="schedule list">
    <thead>
      <tr>
        <th>SEQ</th>
        <th>제목</th>
        <th>내용</th>
        <th>시작일자</th>
        <th>종료일자</th>
      </tr>
    </thead>

    <tbody class="body">
      <c:forEach items="${LIST}" var="LIST" varStatus="INDEX">
        <tr data-id="${LIST.s_seq }">
          <td>${INDEX.count}</td>
          <td>${LIST.s_title}</td>
          <td>${LIST.s_content}</td>
          <td>${LIST.s_sdate}</td>
          <td>${LIST.s_edate}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
