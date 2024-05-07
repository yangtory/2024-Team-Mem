<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib uri="http://www.springframework.org/security/tags"
prefix="sec"%> <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div class="header">
    <div>
    <img src="${rootPath}/static/images/bug.png" width="30px" height="30px" />
    <sec:authorize access="isAnonymous()">
     <a href="${rootPath }/main/login">Mem</a></div>
     </sec:authorize>
     <sec:authorize access="isAuthenticated()">
     <a href="${rootPath }/main">Mem</a></div>
     </sec:authorize>
    <nav class="nav">
        <sec:authorize access="isAnonymous()">
            <a href="${rootPath }/main/login" class="login_btn">Log in</a>
            <a href="${rootPath}/main/join" class="signup_btn">Sign up</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <div class="authenticated">
                <a href="javascript:void(0)"><sec:authentication property="principal.u_comp" /></a>
                <a href="javascript:void(0)"> <sec:authentication property="principal.u_name" /> 님 </a>
                <a href="javascript:void(0)" class="logout_btn"
                    ><f:form class="logout" action="${rootPath }/main/logout" onclick="this.submit()"
                        >Log out</f:form
                    ></a
                >
            </div>
        </sec:authorize>
    </nav>
</div>
