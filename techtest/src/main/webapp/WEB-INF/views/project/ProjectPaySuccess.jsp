<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="com.mirin.tech.service.*" %>
<%
	MemberVo vo = (MemberVo) request.getAttribute("vo");
%>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
	<div class="bodyMain"> 
		<div class="main-section">
<!-- main start -->
	
	<h1> 펀딩결제에 성공하셨습니다. </h1>
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>주문자 성명</td>
	</tr>
	
	<tr>
	<td><%=vo.getName() %></td>
	</tr>
	</table>




	

<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>