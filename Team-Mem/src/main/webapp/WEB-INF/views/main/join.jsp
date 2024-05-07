<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<div class="join_wrap">
    <f:form class="join">
        <h1>Sign Up</h1>
        <div>
            <div class="join error"></div>
            <input placeholder="USERNAME" name="u_id" />
            <input placeholder="PASSWORD" name="u_password" />
            <input placeholder="NAME" name="u_name" />
            <input placeholder="ADDRESS" name="u_addr" />
            <input placeholder="TEL" name="u_tel" /><input placeholder="업체명" name="u_comp" />
            <button type="button" class="join_btn button-32">SIGN UP</button>
        </div>
    </f:form>
</div>
