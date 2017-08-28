<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
           <center><div  class="projectcate" >POWER RANKING</div></center>
                 <br>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/ProjectListByPower.do">
                   <button type="button" class="btn btn-default">                   
					파워랭킹					
                   	</button></a>
                 </div>
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/ProjectListByTech.do">
                   <button type="button" class="btn btn-default">
					기술랭킹					
				</button></a>
                 </div>
                 
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=TECH">
                   <button type="button" class="btn btn-default">
					IT/TECH					
				</button></a>
                 </div>
                 <div class="btn-group" role="group">
                    <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=BEAUTY">
                   <button type="button" class="btn btn-default">
					BEAUTY					
				</button></a>
                 </div>
                                  
                 <div class="btn-group" role="group">
                  <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=HANDMADE">
                   <button type="button" class="btn btn-default">                   
					HAND MADE					
				</button></a>
                 </div>
                 <div class="btn-group" role="group">
                  <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=FOOD">
                   <button type="button" class="btn btn-default">                   
					FOOD					
				</button></a>
                 </div>
                 
                 <div class="btn-group" role="group">
                  <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=FASHION">
                   <button type="button" class="btn btn-default">                   
					FASHION					
				</button></a>
                 </div>
                 <div class="btn-group" role="group">
                  <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=ETC">
                   <button type="button" class="btn btn-default">                   
					ETC.					
				</button></a>
                 </div>

             </div>  
       </div>
       </div>
   <div class="project-container">
          <div class="project-list" style="width:1079px;">
          
		<c:forEach var="pv" items="${plist }">
            <div class="project-nav" style="margin-left: 50px;">
              <div class="item-1" >
                <div class="itemimg-1"><a href="<c:url value='/ProjectCon.do?pIdx=${pv.pIdx }' />">
				<img src="/techtest/resources/images//${pv.pUrl }" alt="프로젝트이미지"></a></div>
                <div class="itemexplain" >
                  제목:${pv.pName } 카테:${pv.pCate }<br>
                  펀딩금액:<fmt:formatNumber value="${pv.pnFunds }" pattern="###,###,###" />달성  
                </div>
              </div>
       
          </div>
         
		</c:forEach>
        </div> 
       </div>  




	

<!-- main end -->
	</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>