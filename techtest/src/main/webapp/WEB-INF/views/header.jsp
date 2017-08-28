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
              <li id="select">
              <a href="<%=request.getContextPath()%>/Projectindex.do" >
              FUNDING</a></li>
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
					<a href="#" target="_blank">
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
      	</nav>      
   </div>
         <div class="WelcomWrap" >
           <img src="/techtest/resources/images/tech9.png" alt="메인">
         </div>

</header>
