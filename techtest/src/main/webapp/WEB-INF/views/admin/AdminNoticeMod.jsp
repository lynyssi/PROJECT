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

<p class="pageP">공지사항 수정하기</p>
	<form method="post" action="<c:url value='/AdminNoticeMod_Action.do'/>">
		<div class="form-group">
		    <label for="title">Title</label>
		    <input class="form-control" type="text" name="title" id="title" value="${bv.title}" required >
	  	</div>		
	  	<div class="form-group">
			<label for="cate">CATE</label>
			<select class="form-control" name="cate" id="cate">
				<option value="NOTICE">NOTICE</option>
				<option value="EVENT">EVENT</option>					
			</select>
		</div>
		<div class="form-group">
		  <label for="content">Content</label>	    
		  <textarea class="form-control" name="contents" id="content" rows="15" required>${bv.contents}</textarea> 	    
		</div>	 
		<input type="hidden" name="bIdx" value="${bv.bIdx}" required > 
  		<button type="submit" class="btn btn-primary btn-block">수정</button>
	</form>
	

<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>