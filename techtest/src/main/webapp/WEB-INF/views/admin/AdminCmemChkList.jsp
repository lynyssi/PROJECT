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
	<p class="adminP">사업자 승인 관리</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col5_1">No </div>
	   <div class="col col5_2">사업자</div>
	   <div class="col col5_3">신청일</div>
	   <div class="col col5_4">상태</div>
	   <div class="col col5_5">작업</div>	  
	</div>
		
	<c:forEach var="mv" items="${mlist}">	
	<div class="clearFix">
	    <div class="col col5_1"></div>
	    <div class="col col5_2"><a href="<c:url value="/AdminCmemChkCon.do?param_idx=${mv.idx}"/>">${mv.name}</a></div>
	    <div class="col col5_3">${mv.modDate}</div>	  
	    <c:choose>
	    	<c:when test="${mv.status eq 0 }">
	    	   <div class="col col5_4">승인대기</div>
	    	   <div class="col col5_5">
	    	   	  	<a href="<c:url value="/AdminCmemChkOk_Action.do?param_idx=${mv.idx}"/>">
					<button type='button' class='btn btn-default'>승인</button></a>    	    
	   				<a href="<c:url value="/AdminMemoSend.do?param_idx=${mv.idx}"/>">
					<button type='button' class='btn btn-default'>반려</button></a>
				</div>	
				</c:when>	
	  			<c:when test="${mv.status eq 1 }">
					<div class="col col5_4">승인완료</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${mv.status eq 3 }">
					<div class="col col5_4">사업자 등록 완료</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${mv.status eq 9 }">
					<div class="col col5_4">회원 정지</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${mv.status eq 10 }">
					<div class="col col5_4">회원 탈퇴</div>
					<div class="col col5_5"></div>
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