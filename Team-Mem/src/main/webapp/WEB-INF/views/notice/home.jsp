<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="${rootPath }/static/js/notice.js?"></script>

<h1 class="list_title">공지사항</h1>
<div class="list_home">
  <div class="insert_btn_box">
    <a class="insert button-32" href="${rootPath }/notice/insert">
      글쓰기
    </a>
  </div>
  <div class="notice search">
    <f:form method="GET" modelAttribute="SEARCH">
      <f:input
        class="search_input"
        placeholder="제목"
        path="n_title"
      />
      <f:input
        class="search_input"
        placeholder="등록일"
        path="n_date"
      />
      <input class="button-32" type="submit" value="검색" />
    </f:form>
  </div>

  <table class="notice list">
    <thead>
      <tr>
        <th>No.</th>
        <th>업체명</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성날짜</th>
        <th>작성시간</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${SEARCH_LIST}" var="N" varStatus="INDEX">
        <tr data-seq="${N.n_seq }">
          <td>${INDEX.count }</td>
          <td>${N.n_ccode }</td>
          <td>${N.n_title }</td>
          <td>${N.n_uid }</td>
          <td>${N.n_date }</td>
          <td>${N.n_time }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
