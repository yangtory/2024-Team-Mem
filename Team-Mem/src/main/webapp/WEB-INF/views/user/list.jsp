<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<!DOCTYPE html>	
	<div class="customer btn_box">
		<f:form method="GET" modelAttribute="SEARCH">
			<f:input placeholder="아이디" path="uid"/>
			<f:input placeholder="이름" path="uname"/>
			<f:input placeholder="전화번호" path="utel"/>
			<input type="submit" value="검색" />
		</f:form>
	
	</div>
		
		<a href="${rootPath }/insert">수강생 추가</a>
		<div>
		<c:forEach items="${COMP }" var="COMP" >
			<td>${COMP.c_name}</td>
		</c:forEach>
			</div>
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
				<tr data-id = "${USER.u_id }">
					<td>${USER.u_id }</td>
					<td>${USER.u_name }</td>
					<td>${USER.u_tel }</td>
					
				
				
				</tr>
				</c:forEach>	
			</tbody>
		
		
		
		</table>
			
		


	
		
		


