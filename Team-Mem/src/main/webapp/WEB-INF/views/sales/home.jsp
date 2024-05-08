<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="${rootPath}/static/js/sales.js"></script>
<link rel="stylesheet" href="${rootPath}/static/css/sales_detail.css" />

<h1 class="list_title">매출 내역</h1>
<div class="list_home">
    <div class="sales btn_box search">
        <f:form class="search_form" method="GET" modelAttribute="SEARCH">
        	<div>
        	<div><label class="sdate">시작일</label>
            <f:input class="search_input sdate" placeholder="시작일" path="s_sdate" type="date" /></div>
            <div><label class="sdate">종료일</label>
            <f:input class="search_input edate" placeholder="종료일" path="s_edate" type="date" /></div>
            </div>
            <div>
            <f:input class="search_input" placeholder="회원ID" path="s_uid" />
            <f:input class="search_input" placeholder="회원권이름" path="s_ititle" />
            </div>
            <button class="button-32" type="button" value="검색" >
              <img src="${rootPath }/static/images/search.png" width="10px" height="10px" ></button>
        </f:form>
    </div>
	<div class="table_div">
		<table class="sales list">
			<thead>
				<tr>
					<th>No.</th>
					<th>매출 날짜</th>
					<th>회원 아이디</th>
					<th>회원권 번호</th>
					<th>회원권 이름</th>
					<th>회원권 가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${SALES_LIST}" var="S" varStatus="INDEX">
					<tr class ="sales_list" data-sdate="${S.r_sdate}" data-uid="${S.r_uid}">
						<td>${INDEX.count }</td>
						<td class="sdate">${S.r_sdate }</td>
						<td class="id">${S.r_uid }</td>
						<td class="seq">${S.i_seq }</td>
						<td class="title">${S.i_title }</td>
						<td class="price"><fmt:formatNumber value="${S.i_price }" pattern="#,###" />
						</td>
					</tr>
				</c:forEach>
				<tr class="total">
					<td>총 매출
					<td>
					<td>
					<td>
					<td>					
					<td class="total">
				</tr>
				
			</tbody>
		</table>
	</div>
	<div class="modal-backdrop">
		<div class="detail">
			<div class="sales recipe">
				<h1>매출 영수증</h1>
				<div><label>업체코드</label><input value="${SALES_LIST[0].i_ccode}" readonly></div>
				<div><label>업체명</label><input value="${CNAME}" readonly></div>
				<div><label>전화번호</label><input value="010-0000-0000" readonly></div>
				<div><label>주　소</label><input value="광주 광산구" readonly></div>

				<div><label>영수증번호</label><input value="202241-256871" readonly></div>
				<div><label>매출날짜</label><input name="r_sdate" readonly></div>
				<div><label>회원ID</label><input name="r_uid" readonly ></div>
				<div><label>회원권이름</label><input name="i_title" readonly ></div>
				<div><label>회원권가격</label><input name="i_price" readonly ></div>
			</div>
			</div>
				</div>
		</div>
</div>