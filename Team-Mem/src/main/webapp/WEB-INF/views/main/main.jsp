<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${rootPath }/static/js/dash.js"></script>
<link href="${rootPath }/static/css/dash.css" rel="stylesheet">
<section class="page">
	<div class="top">
		<div class="month">
			<div class="total">월 매출</div>
			<c:if test="${TOTAL == 0 }">
				<div class="error">
					<div class="total error_left">
						<div>아직 매출이 없습니다</div>

					</div>
				</div>
			</c:if>
			<c:if test="${TOTAL > 0 }">
			<div class="chart">
				<canvas id="myPieChart"></canvas>
				<div class="total_box">
					<div class="total">
						<span>총 매출</span>
						<p>
							<fmt:formatNumber value="${TOTAL}" pattern="#,###" />
						</p>
					</div>

				</div>
			</div>
			</c:if>
		</div>

		<div class="month">
			<div class="total">월 가입수</div>
			<c:if test="${COUNT == 0 }">
				<div class="error">
					<div class="total error_right">
						<div>이용중인 회원이 없습니다</div>
					</div>
				</div>
			</c:if>
			<c:if test="${COUNT > 0 }">
			<div class="chart">
				<canvas id="myUserChart"></canvas>
				<div class="total_box">
					<div class="total">
						<span>이용중인 유저수</span>
						<p>${COUNT }명</p>
					</div>
				</div>
			</div>
			</c:if>
		</div>
	</div>

	<div class="bottom">
		<!-- 공지사항 리스트 -->
		<div class="total notice_list">공지사항</div>
		<c:if test="${NOTICE_LIST.size() == 0}">
		<div class="notice">
			<div class="table_wrapper">
				<table class="notice list">
					<thead>
						<tr>
							<th class="index" width="20px">No.</th>
							<th class="date" width="80px">작성일자</th>
							<th class="title" width="200px">제목</th>
							<th class="id" width="100px">작성자</th>
							

						</tr>
					</thead>
					<tbody></tbody>
					</table>
		<div class="noList_wrapper">
            <div class="noList">등록된 공지사항이 없습니다.</div>
        </div>
		</c:if>
		<c:if test="${NOTICE_LIST.size() > 0}">
		<div class="notice">
			<div class="table_wrapper">
				<table class="notice list">
					<thead>
						<tr>
							<th class="index" width="20px">No.</th>
							<th class="date" width="80px">작성일자</th>
							<th class="title" width="200px">제목</th>
							<th class="id" width="100px">작성자</th>
							

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${NOTICE_LIST}" var="N" varStatus="INDEX">
							<tr data-seq="${N.n_seq }">
								<td class="index">${INDEX.count }</td>
								<td class="date">${N.n_date }<br>${N.n_time }</td>
								<td class="title">${N.n_title }</td>
								<td class="id">${N.n_uid }</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</c:if>
		</div>
	</div>

</section>

