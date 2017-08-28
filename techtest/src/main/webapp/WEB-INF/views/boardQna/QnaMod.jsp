<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="com.mirin.tech.service.*" %>
<%@ page import="java.util.*" %> 
<!-- Attribute start -->

<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
	<div class="bodyMain"> 
		<div class="main-section">
<!-- main start -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
        $('#ModifyButton').click(function(){ 
            if($('#title').val().length <1) { 
                alert('제목을 입력해주세요'); 
                $('#title').focus(); 
            } else if($('#contents').val()=='') { 
                alert('내용을 입력하세요'); 
                $('#contents').focus();
            } else {
                $('#ModifyForm').submit(); 
            }
        });
    });
</script>
	<h1>QNA MODIFY</h1>   
		<form id="ModifyForm" action="${pageContext.request.contextPath}/QnaMod_Action.do" method="post">
	  		<div class="">
	           <label for="bIdx"></label>
	      		<input class="" name="bIdx" id="bIdx" type="hidden" value="${bv.bIdx}" autocomplete="off" readonly="readonly"/>
	      	</div>
			<div class="form-group">
	 		
				<label for="cate">CATE</label>
				<select class="qcate" name="cate" id="cate">
					<option>회원</option>
					<option>가드닝</option>
					<option>결제</option>
				</select>
			</div>
						
	        <div class="form-group">
	            <label for="title">title :</label>
	            <input class="qtitle" name="title" id="title" type="text" value="${bv.title}"/>
	            <div class="title2"></div>
	        </div>
	        <div class="form-group">
	            <label for="contents">contents :</label>
	            <textarea class="qcontents" name="contents" id="contents" rows="5" cols="50">${bv.contents}</textarea>
	        </div>

	
	    </form>	
		<div>
			<input class="btn btn-default" id="ModifyButton" type="button" value="수정완료"/>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/QnaList.do?idx=${bv.idx}">글목록</a>
		</div>
<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>