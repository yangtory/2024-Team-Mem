<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<div>
	<f:form modelAttribute="ADD">
		<f:input placeholder="아이디" path="us_uid" />
		<f:input placeholder="회사코드" path="us_ccode" />
		
		<input type="submit" value="추가" />
	</f:form>
	
	<table>
	
		<thead>
		<tr>
			<th>ID</th>
			<th>이름</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${USER }" var="USER">
				<tr>
					<td>${USER.u_id }</td>
					<td>${USER.u_name }</td>
				</tr>
			
			</c:forEach>
		</tbody>		
	
	</table>
	
	

</div>

