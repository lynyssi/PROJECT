<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="com.mirin.tech.service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
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
           <center><div  class="projectcate" >관리자 페이지</div></center>
                 <br>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">
                 	<a href="<%=request.getContextPath()%>/AdminImemInfoList.do">
                   <button type="button" class="btn btn-default">투자자회원정보</button>
                 	</a>
                 </div>
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminMoneyList.do">
                   <button type="button" class="btn btn-default">머니 충전 관리</button>
                 	</a>
                 </div>
                 
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminCmemInfoList.do">
                   <button type="button" class="btn btn-default">사업자 회원정보</button>
                 	</a>
                 </div>
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminCmemChkList.do">
                   <button type="button" class="btn btn-default">사업자 승인</button>
                 	</a>
                 </div>
                                  
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminProjChkList.do">
                   <button type="button" class="btn btn-default">프로젝트 승인</button>
                 	</a>
                 </div>
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminNoticeList.do">
                   <button type="button" class="btn btn-default">공지사항관리</button>
                 	</a>
                 </div>
                 
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminFaqList.do">
                   <button type="button" class="btn btn-default">FAQ관리</button>
                 	</a>
                 </div>
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminQnaList.do">
                   <button type="button" class="btn btn-default">QNA관리</button>
                 	</a>
                 </div>
			
             </div>  
       </div>
       </div>
<div class="adminWrapper">	
<p class="adminP">회원 머니 리스트</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col6_1">No </div>
	   <div class="col col6_2">회원 이름</div>
	   <div class="col col6_3">충전 금액</div>
	   <div class="col col6_4">신청일</div>
	   <div class="col col6_5">상태</div>	  
	   <div class="col col6_6">작업</div>	  
	</div>
		
	<c:forEach var="hashmap" items="${alist}">
  <div class="clearFix">
	    <div class="col col6_1"></div>
	    <div class="col col6_2"><a href="<c:url value='/AdminImemInfoCon.do?param_idx=${hashmap.IDX}'/>">${hashmap.NAME}</a></div>
	    <div class="col col6_3">${hashmap.CHGMONEY}원</div>	    
	    <div class="col col6_4">${hashmap.INSDATE}</div>	    
	    <c:choose>
	    	<c:when test="${hashmap.STATUS eq 0 }">
	    <div class="col col6_5">승인대기</div>
	   <div class="col col6_6">					
			<a href="<c:url value="/AdminMoneyChkOk_Action.do?param_idx=${hashmap.IDX}&mIdx=${hashmap.MIDX}"/>">
				<button type='button' class='btn btn-default'>승인</button>
			</a> 
			<a href="<c:url value="/AdminMoneyChkNOk_Action.do?param_idx=${hashmap.IDX }&mIdx=${hashmap.MIDX}"/>">
			<button type='button' class='btn btn-default'>반려</button></a>
		</div>
		</c:when>
		<c:when test="${hashmap.STATUS eq 1 }">
			<div class="col col6_5">충전 완료</div>
		</c:when>
		<c:when test="${hashmap.STATUS eq 2 }">
			<div class="col col6_5">충전 취소</div>
		</c:when>
		
		</c:choose>
		</div>
		</c:forEach>
	
	</div>
	
</div>
<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>