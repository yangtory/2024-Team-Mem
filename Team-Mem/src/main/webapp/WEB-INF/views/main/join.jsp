<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

<f:form>
<div><input placeholder="USERNAME" name="u_id"/></div>
<div><input placeholder="PASSWORD" name="u_password"/></div>
<div><input placeholder="NAME" name="u_name"/></div>
<div><input placeholder="ADDRESS" name="u_addr"/></div>
<div><input placeholder="TEL" name="u_tel"/></div>
<div><input placeholder="업체명" name="u_comp"/></div>

<div><button>회원가입</button></div>



</f:form>
