<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!-- Attribute start -->
<%@ page import="com.mirin.tech.service.*" %>
<%@ page import="java.util.*" %>

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
           <center><div  class="projectcate" >FAQ</div></center>
                 <br>
             <center>    
            <div class="btn-group btn-group-justified" role="group" aria-label="..." style="width:300px;">
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/NoticeList.do">
                   <button type="button" class="btn btn-default">NOTICE</button>
                 </a>
                 </div>                 
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/FaqList.do">
                   <button type="button" class="btn btn-default">FAQ</button>
                 </a>
                 </div>
            </div>
            </center>  
       </div>
       </div>
<h3>FAQ CON</h3>
<p>
	<div class="t">
	  <div class="tt1">
		<div class="title0">
			<div class="title1">${bv.title }</div>
			<div class="title2">${bv.insDate}</div>
		</div>
		<div class="title3">
			<div class="title4">카테고리 > ${bv.cate} </div>
			<div class="title5">조회수 : ${bv.hit}</div>
		</div>	
		<div class="tt2">
			<div class="title6">
		 	${bv.contents}
		 	</div>
		</div>	
	  </div>
	</div>
	<div>
		<center><a class="btn btn-default" href="<c:url value='/FaqList.do?bIdx=${bv.bIdx}'/>">글목록</a></center>
	</div>
	
			
<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>