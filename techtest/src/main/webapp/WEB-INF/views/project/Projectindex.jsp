<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Tech Forest</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@ include file="/WEB-INF/views/css.jsp" %>
  <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 </head>
<body>
	<script src="js/bootstrap.min.js"></script>
<header class="clearFix">
<!-- 헤더 -->
 <div class="HeaderWrap clearfix">
        <div class="logo">
          <a href="<%=request.getContextPath() %>/index.do" ><img src="/techtest/resources/images/logo.png" alt="로고이미지"></a>
        </div>
      <nav class="gnb" ">
 
        <div class="manu-list">
           <ul>
              <li id="select"><a href="#">FUNDING</a></li>
              <li>
                 <label class="btn-more-gnbsub" for="globalSubNavOpener">
                    더보기
                 </label>
              </li>
           </ul>
        </div>    
         <div class="manu-list2">
							<%
				Object idx = session.getAttribute("idx");
				Object type = session.getAttribute("type");
			%>
			<%	
				if(idx == null){
			%>
				<div class="manu">
				<li>
					<a href="<%=request.getContextPath()%>/MemberLogIn.do" >
						<p class="glyphicon glyphicon-user" aria-hidden="true"></p>
						로그인
					</a>
				</li>
			<% 
				}else if(idx != null && type.equals("I")){ 
			%>
				<li>
					<a href="<%=request.getContextPath()%>/MemberLogOut_Action.do" >
						<p class="glyphicon glyphicon-remove" aria-hidden="true"></p>
						로그아웃
					</a>
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/IMemberIndexP.do">
						<p class="glyphicon glyphicon-wrench" aria-hidden="true"></p>
						투자자 마이페이지
					</a>
				</li>
			<% 
				}else if(idx != null && type.equals("C")){ 
			%>
				<li>
					<a href="<%=request.getContextPath()%>/MemberLogOut_Action.do" >
						<p class="glyphicon glyphicon-remove" aria-hidden="true"></p>
						로그아웃
					</a>
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/CMemberIndexP.do">
						<p class="glyphicon glyphicon-wrench" aria-hidden="true"></p>
						사업자 마이페이지
					</a>
				</li>
			<%
				}else if(type.equals("A")){
			%>
				<li>
					<a href="<%=request.getContextPath()%>/AdminIndex.do">
						<p class="glyphicon glyphicon-wrench" aria-hidden="true"></p>
						관리자 마이페이지
					</a>
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/MemberLogOut_Action.do" >
						<p class="glyphicon glyphicon-remove" aria-hidden="true"></p>
						로그아웃
					</a>
				</li>
			<%
				}
			%>
				<li>
					<a href="http://www.daum.net" target="_blank">
						<p class="glyphicon glyphicon-th" aria-hidden="true"></p>
						상세메뉴
					</a>
				</li>
				<li>	
					<a href="<%=request.getContextPath()%>/NoticeList.do" >
						<p class="glyphicon glyphicon-phone-alt" aria-hidden="true"></p>
						고객센터
					</a>
				</li>
				
				</div>
         </div>
      	</nav>      
   </div>

</header>
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
	<div class="bodyMain"> 
<!-- main start -->
<main>
<div class="MainWrap clearfix">
     <div class="section1" ></div>
     
     <div class="section2"">
              <div class="container" style="width: 900px; height: 400px; ">
               <div id="myCarousel" class="carousel slide" data-ride="carousel">
                 <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1"></li>
                  <li data-target="#myCarousel" data-slide-to="2"></li>
                  <li data-target="#myCarousel" data-slide-to="3"></li>
                  <li data-target="#myCarousel" data-slide-to="4"></li>
                  <li data-target="#myCarousel" data-slide-to="5"></li>

                </ol>

                 <div class="carousel-inner">
                  <div class="item active" >
                    <img src="/techtest/resources/images/fly.png" alt="fly" style="width: 900px; height: 400px;"">
                  </div>

                  <div class="item">
                    <img src="/techtest/resources/images/star.png" alt="star" style="width: 900px; height: 400px;">
                  </div>
                
                  <div class="item">
                    <img src="/techtest/resources/images/lover.png" alt="lover" style="width: 900px; height: 400px;">
                  </div>

                  <div class="item">
                    <img src="/techtest/resources/images/rebox.png" alt="rebox" style="width: 900px; height: 400px;">
                  </div>
                
                  <div class="item">
                    <img src="/techtest/resources/images/book2.png" alt="book2" style="width: 900px; height: 400px;">
                  </div>

                  <div class="item">
                    <img src="/techtest/resources/images/byebye.png" alt="byebye" style="width: 900px; height: 400px;">
                  </div>
                
                </div>

                 <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                  <span class="glyphicon glyphicon-chevron-left"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                  <span class="glyphicon glyphicon-chevron-right"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
               </div> 
    

       
       <div class="project">
       <div class="project-nav">
           <center><div  class="projectcate" >PROJECT FUNDING CATE</div></center>
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
				<img src="/techtest/resources/images/${pv.pUrl }" alt="프로젝트이미지"></a></div>
                <div class="itemexplain" >
                  제목:${pv.pName } 카테:${pv.pCate }<br>
                  펀딩금액:<fmt:formatNumber value="${pv.pnFunds }" pattern="###,###,###" />달성  
                </div>
              </div>
       
          </div>
         
		</c:forEach>
        </div> 
       </div>  
 
     </div>
     </div>
    
 <script>
      $('.carousel').carousel()
   </script> 


</main>
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>