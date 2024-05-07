<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div class="login_wrap">
    <f:form class="login">
        <h1>Login</h1>
        <div>
            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null }">
                <div>${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
            </c:if>
            <div class="login error"></div>
            <input placeholder="Username" name="u_id" />
            <input type="password" placeholder="Password" name="u_password" />
            <button type="button" class="login_btn button-32">SUBMIT</button>
        </div>
    </f:form>
</div>
