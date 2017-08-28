<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="com.mirin.tech.service.*" %>

<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
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
<script>
function wishListDel(){ 
	if(confirm("위시리스트에서 삭제하시겠습니까?")){
    	}else{
    		return false;
    	}
	}
	
</script>
	<table class="table table-striped table-bordered table-hover" style="margin-top:40px;">
	<tr>
	<td>순번</td>
	<td>프로젝트 명</td>
	<td>프로젝트 현재 투자금액</td>
	<td>프로젝트 목표 도달금액</td>
	<td>목표도달율</td>
	<td>주문관리</td>
	</tr>
 
	<c:forEach var="pv" items="${plist}">
	<tr>
	<td></td>
	<td>${pv.pName}</td>
	<td>${pv.pnFunds}원</td>
	<td>${pv.ptFunds}원</td>
	<fmt:formatNumber value="${pv.pnFunds}" var="pnFunds" pattern=".00"/>
	<fmt:formatNumber value="${pv.ptFunds}" var="ptFunds" pattern=".00"/>
	<td>(pnFunds / ptFunds) * 100%</td>
	<td><a href="<c:url value='/IMemberWishListDel_Action.do?pIdx=${pv.pIdx}'/>" class="btn btn-default" id="wishListDelButton" type="button" onclick="wishListDel()">삭제하기</a></button></td>
	</tr>
	</c:forEach>
	</table>

<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>