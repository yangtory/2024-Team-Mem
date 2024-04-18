<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<div>
<f:form>
<div><input placeholder="유저ID" name="us_uid"/></div>
<div><input placeholder="이름" name="us_uname"/></div>

<div><button>추가</button></div>

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

