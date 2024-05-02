<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib
uri="http://www.springframework.org/security/tags" prefix="sec" %> <%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<script src="${rootPath }/static/js/userTicket.js"></script>
<script>
  const rootPath = "${rootPath}";
</script>
<h1 class="list_title">회원권 정보</h1>
<div class="list_home">
  <div class="insert_btn_box">
    <a class="insert button-32" href="${rootPath }/customer/tick/insert">회원권 추가</a>
  </div>
    
  <table class="user_ticket list">
    <thead>
      <tr>
        <th>수강권</th>
        <th>잔여횟수</th>
        <th>시작일</th>
        <th>종료일</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${MINFO }" var="M">
        <tr data-id="${M.r_uid }">
          <td>${M.i_title }</td>
          <td>${M.r_icount }</td>
          <td>${M.r_sdate }</td>
          <td>${M.r_edate }</td>
      	<c:forEach items="${DDAY }" varStatus="I" begin="0">
          <td>${DDAY[I.count-1]}</td>
      	</c:forEach>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
