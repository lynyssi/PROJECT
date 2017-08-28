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

</style>
<p class="pageP">QNA 답변하기</p>
	<form method="post" action="<%=request.getContextPath()%>/AdminQnaWrite_Action.do">		
		<input type="hidden" name="bIdx" id= "bIdx" value="${bv.bIdx}">
		<input type="hidden" name="pIdx" id= "pIdx" value="${bv.pIdx}">	  			
		<div class="form-group">
		    <label for="title">Title</label>
		    <input class="form-control" type="text" name="title" id="title" placeholder="${bv.title}" required >
	  	</div>
	  	<div class="form-group">
		    <label for="cate">Cate</label>
		    <select class="form-control" name="cate" id="cate">
		    	<option >회원</option>
				<option >가드닝</option>
				<option >결제</option>		
			</select>	   
	  	</div>		
		<div class="form-group">
		  <label for="contents">Contents</label>	    
		  <textarea class="form-control" name="contents" id="contents" placeholder="${bv.contents}" rows="15" required></textarea> 	    
		</div>	  
  		<button type="submit" class="btn btn-primary btn-block">답변 작성</button>
	</form>
		

<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>