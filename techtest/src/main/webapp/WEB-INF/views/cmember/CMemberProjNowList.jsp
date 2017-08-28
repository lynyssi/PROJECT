<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Attribute start -->
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
                  <a href="<%=request.getContextPath() %>/CMemberIndexP.do">
                   <button type="button" class="btn btn-default">사업자 마이페이지</button>
                   </a>
                 </div>
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/CMemberInfoExtWrite.do">
                   <button type="button" class="btn btn-default">사업자 등록</button>
                   </a>
                 </div>
                 
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/CMemberInfoCon.do">
                   <button type="button" class="btn btn-default">사업자 회원정보 수정 </button>
                   </a>
                 </div>
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/CMemberProjNowList.do">
                   <button type="button" class="btn btn-default">사업자 진행중 프로젝트</button>
                   </a>
                 </div>
                                  
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/CMemberProjHisList.do">
                   <button type="button" class="btn btn-default">사업자 완료된 프로젝트</button>
                   </a>
                 </div>
                 <div class="btn-group" role="group">            
                 <a href="<%=request.getContextPath() %>/CMemberProjApplyWrite.do">
                   <button type="button" class="btn btn-default">사업자 프로젝트 신청</button>
                 </a>
                 </div>
             </div>  
       </div>
       </div>
<style>
.btn-default{
	margin-bottom: 3px;
}

.cmemWrapper{
	width:100%;
	padding: 0;
	margin: 0; 	 	
}

.cmemDivTable{
	margin-top: 10px;
	margin-bottom: 40px;
}

.cmemTitle{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 10px;
	font-weight: bold;
}
</style>
<p class="cmemTitle">현재 진행중 프로젝트</p>
<div class="cmemWrapper">
	<div class="cmemDivTable">
		<div class="clearFix rowTitle">
			<div class="col col5_1">프로젝트 명</div>
			<div class="col col5_2">프로젝트 현재 투자금액</div>
			<div class="col col5_3">프로젝트 목표 투자금액</div>
			<div class="col col5_4">목표도달율</div>
			<div class="col col5_5">상태</div>
		</div>

<div class="clearFix">
	<div>
		<div class="col col5_1"><a href="<c:url value='/ProjCon.do?pIdx=${pv.pIdx}' /> ">${pv.pName }</a></div>
		<div class="col col5_2">${pv.pnFunds }원</div>
		<div class="col col5_3">${pv.ptFunds }원</div>
		<div class="col col5_4">${(pv.pnFunds / pv.ptFunds) * 100}%</div>
		<div class="col col5_5">진행</div>
	</div>
</div>	

	</div>
</div>
<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>