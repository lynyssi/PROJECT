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

<p class="pageP">공지사항 글쓰기</p>
	<form method="post" action="<c:url value='/AdminNoticeWrite_Action.do'/>">
		<div class="form-group">
		    <label for="title">Title</label>
		    <input class="form-control" type="text" name="title"   id="title" placeholder="제목을 입력하세요" required >
	  	</div>		
	  	<div class="form-group">
			<label for="cate">CATE</label>
			<select class="form-control" name="cate" id="cate">
				<option value="공지 사항">공지사항</option>
				<option value="EVENT">EVENT</option>					
			</select>
		</div>
		<div class="form-group">
		  <label for="content">Content</label>	    
		  <textarea class="form-control" name="contents" id="content" placeholder="내용을 입력하세요" rows="15" required></textarea> 	    
		</div>	  
  		<button type="submit" class="btn btn-primary btn-block">글쓰기</button>
	</form>
		
<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>