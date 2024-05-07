<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${rootPath }/static/js/dash.js"></script>
<link href ="${rootPath }/static/css/dash.css" rel="stylesheet" >
<section>
	
	
	
	<div><span>이용중인 유저수</span><p>${COUNT }명</p></div>
	

	<!-- 공지사항 리스트 -->
	<div>
		<div class="table_div">
			<table class="notice list">
				<thead>
					<tr>
						<th class="index" width="20px">No.</th>
						<th class="date" width="80px">작성일자</th>
						<th class="title" width="200px">제목</th>
						<th class="id" width="20px">작성자</th>
						<th class="content">내용</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${NOTICE_LIST}" var="N" varStatus="INDEX">
						<tr data-seq="${N.n_seq }">
							<td class="index">${INDEX.count }</td>
							<td class="date">${N.n_date }<br>${N.n_time }</td>
							<td class="title">${N.n_title }</td>
							<td class="id">${N.n_uid }</td>
							<td class="content">${N.n_content}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div><span>회원권 총매출</span><p><fmt:formatNumber value="${TOTAL}" pattern ="#,###" /></p></div>
	<div>회원권 월매출</div>
<canvas id="myPieChart"></canvas>


</section>

