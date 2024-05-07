<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="f"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="${rootPath}/static/js/ticket.js"></script>

<h1 class="list_title">회원권 리스트</h1>
<div class="list_home">
    <div class="insert_btn_box">
        <a class="insert button-32" href="${rootPath }/ticket/insert">수강권 추가</a>
    </div>
    <table class="ticket list">
        <thead>
            <tr>
                <th>No.</th>
                <th>수강권</th>
                <th>가격</th>
                <th>수강횟수</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${TICKET_LIST}" var="I" varStatus="INDEX">
                <tr data-seq="${I.i_seq}">
                    <td>${INDEX.count }</td>
                    <td>${I.i_title }</td>
                    <td><fmt:formatNumber value="${I.i_price }" pattern="#,###" /></td>
                    <td>${I.i_count }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
