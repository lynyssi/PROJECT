<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="com.mirin.tech.service.*" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<style>
.btn-default{
	margin-bottom: 3px;
}

.imemWrapper{
	width:100%;
	padding: 0;
	margin: 0; 	 	
}

.imemDivTable{
	margin-top: 10px;
	margin-bottom: 40px;
}

.imemTitle{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 10px;
	font-weight: bold;
}
</style>

<script>
function goList(page) {
	  var form = document.getElementById("listForm");
	  form.curPage.value = page;
	  form.submit();
	 }
</script>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
	<div class="bodyMain"> 
		<div class="main-section">
<!-- main start -->
<div class="project">
       <div class="project-nav">
           <center><div  class="projectcate" >투자참가 리스트</div></center>
                 <br>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">
                  <a href="<%=request.getContextPath()%>/IMemberIndexP.do">
                   <button type="button" class="btn btn-default">마이페이지</button>
                   </a>
                 </div>
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath()%>/IMemberInfoCon.do">
                   <button type="button" class="btn btn-default">회원정보 수정</button>
                   </a>
                 </div>
                 
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath()%>/IMemberMoneyHis.do">
                   <button type="button" class="btn btn-default">충전 및 금액 조회</button>
                   </a>
                 </div>
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath()%>/IMemberFundList.do">
                   <button type="button" class="btn btn-default">투자리스트</button>
                   </a>
                 </div>
                                  
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath()%>/IMemberWishList.do">
                   <button type="button" class="btn btn-default">위시리스트</button>
                   </a>
                 </div>
                 <div class="btn-group" role="group">            
                 <a href="<%=request.getContextPath()%>/IMemberQnaList.do">
                   <button type="button" class="btn btn-default">QNA 리스트 </button>
                 </a>
                 </div>
             </div>  
       </div>
       </div>
<p class="imemTitle">참가 프로젝트 </p>
<div class="imemWrapper">
	<div class="imemDivTable">
		<div class="clearFix rowTitle">
			<div class="col col5_1">No</div>
			<div class="col col5_2">프로젝트 명</div>
			<div class="col col5_3">투자금액</div>
			<div class="col col5_4">투자일</div>
			<div class="col col5_5">목표달성률</div>
		</div>	
 
<div class="clearFix">
	<c:forEach var="plist" items="${dataList }">
			<div class="col col5_1">${plist.RNUM }</div>
			<div class="col col5_2"><a href="<c:url value='/ProjCon.do?pIdx=${plist.PIDX }'/>">${plist.PNAME }</a></div>
			<div class="col col5_3">${plist.INFUNDS }원</div>
			<div class="col col5_4">${plist.INSDATE }</div>
			<div class="col col5_5">${(plist.PNFUNDS / plist.PTFUNDS) * 100 }</div>
	</c:forEach>
</div>	

<div id="paging" style="text-align: center;">
  
  <c:if test="${prevLink > 0 }">
  	<a href="javascript:goList('${prevPage }')">[이전]</a>
  </c:if>

  <c:forEach var="i" items="${pageLinks }" varStatus="stat">
  	<c:choose>
    	<c:when test="${curPage == i}">
    		<span class="bbs-strong">${i }</span>
   		</c:when>
   		<c:otherwise>
    		<a href="javascript:goList('${i }')">${i }</a>
   		</c:otherwise>
  	</c:choose>
  </c:forEach>
  
  <c:if test="${nextLink > 0 }">
  	<a href="javascript:goList('${nextPage }')">[다음]</a>
  </c:if>
  
 </div>
 
 <div id="form-group" style="display: none;">
 	<form id="listForm" action="<c:url value='/IMemberIndexP.do' />" method="get">
   		<input type="hidden" name="curPage" />
 	</form>
 </div>

	</div>
</div>

<!-- main end -->
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>