<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://www.springframework.org/security/tags" prefix="sec" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<script src="${rootPath }/static/js/userList.js"></script>
<script>
    const rootPath = '${rootPath}';
</script>
<h1 class="list_title">회원 리스트</h1>
<div class="list_home">
    <div class="insert_btn_box">
        <a class="insert button-32" href="${rootPath }/customer/insert">수강생 추가</a>
    </div>
    <div class="customer btn_box search">
        <f:form method="GET" modelAttribute="SEARCH">
            <f:input class="search_input" placeholder="아이디" path="uid" />
            <f:input class="search_input" placeholder="이름" path="uname" />
            <f:input class="search_input" placeholder="전화번호" path="utel" />
            <button class="button-32" type="submit"><img src="${rootPath }/static/images/search.png" width="10px" height="10px" ></button>
        </f:form>
    </div>
    <div class="table_div">
    <table class="customer list">
        <thead>
            <tr>
                <th>ID</th>
                <th>이름</th>
                <th>전화번호</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${USER }" var="USER">
                <tr data-id="${USER.us_uid }">
                    <td>${USER.us_uid }</td>
                    <td>${USER.us_uname }</td>
                    <td>${USER.us_utel }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</div>