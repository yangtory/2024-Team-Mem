<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="${rootPath }/static/js/notice.js"></script>
<link rel="stylesheet" href="${rootPath}/static/css/notice.css">
<link rel="stylesheet" href="${rootPath}/static/css/notice_detail.css" />


<h1 class="list_title">공지사항</h1>
<div class="list_home">
    <div class="insert_btn_box">
        <a class="insert button-32" href="${rootPath }/notice/insert"> 글쓰기 </a>
    </div>

    <div class="notice search">
        <f:form method="GET" modelAttribute="SEARCH">
            <f:input class="search_input" placeholder="제목" path="n_title" />
            <f:input class="search_input" placeholder="등록일" path="n_date" />
            <button class="button-32" type="submit" value="검색" ><img src="${rootPath }/static/images/search.png" width="10px" height="10px" ></button>
        </f:form>
    </div>
    <c:if test="${SEARCH_LIST.size() == 0}">
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
        </tbody>
        </table>
        <div class="noList_wrapper">
            <div class="noList">등록된 공지사항이 없습니다.</div>
        </div>
    </c:if>
     
    <c:if test="${SEARCH_LIST.size() > 0}">
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
                <c:forEach items="${SEARCH_LIST}" var="N" varStatus="INDEX">
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
</c:if>
<div class="modal-backdrop">
    <div class="detail">
        <div class="notice input_box">
            <label>제목</label><input name="title" readonly>
            <label>내용</label><textarea name="content" rows="20" readonly ></textarea>
            <div class="btn_box">
            <button class="notice_update button-32">수정</button>
            <button class="notice_delete button-32">삭제</button>
        </div>
        </div>
            </div>
    </div>
</div>