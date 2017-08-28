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
	<div class="bodyMain" style="width:1079px; margin:0 auto;"> 
<!-- main start -->
<style>

.project-list {
	width: 879px;
	margin: 0 auto;
	overflow: hidden;
	line-height: 1;
}
.project-list .project-list-ul {
	display: flex;
	flex-wrap: wrap;
	padding: 0;
	margin: 20px 10px;
	list-style: none;
}
.project-list .project-list-ul li {
	width : 245px;
	margin : 0 20px;
}
h1 {
	text-align: center;
}

</style>

       <div class="project">
       <div class="project-nav">
           <center><div  class="projectcate" >PROJECT</div></center>
                 <br>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">
                   <button type="button" class="btn btn-default">파워랭킹</button>
                 </div>
                 <div class="btn-group" role="group">
                   <button type="button" class="btn btn-default">기술랭킹</button>
                 </div>
                 
                 <div class="btn-group" role="group">
                   <button type="button" class="btn btn-default">IT/TECH</button>
                 </div>
                 <div class="btn-group" role="group">
                   <button type="button" class="btn btn-default">BEUTY</button>
                 </div>
                                  
                 <div class="btn-group" role="group">
                   <button type="button" class="btn btn-default">HANDMADE</button>
                 </div>
                 <div class="btn-group" role="group">
                   <button type="button" class="btn btn-default">FOOD</button>
                 </div>
                 
                 <div class="btn-group" role="group">
                   <button type="button" class="btn btn-default">FASHION</button>
                 </div>
                 <div class="btn-group" role="group">
                   <button type="button" class="btn btn-default">ETC</button>
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
<%@ include file="/WEB-INF/views/footer.jsp" %>