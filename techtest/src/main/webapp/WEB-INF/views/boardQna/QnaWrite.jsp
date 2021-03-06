<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
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
           <center><div  class="projectcate" >QNA</div></center>
                 <br>
             <center>    
            <div class="btn-group btn-group-justified" role="group" aria-label="..." style="width:500px;">
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
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/QnaWrite.do">
                   <button type="button" class="btn btn-default">QNA</button>
                 </a>
                 </div>
            </div>
            </center>  
       </div>
       </div>
<script src="/resource/plugins/summernote/summernote.js"></script>
<script>
$(document).ready(function(){
    $('#addButton').click(function(){ 
        if($('#cate').val().length <1) {
            alert('카테고리를입력해주세요'); 
            $('#cate').focus(); 
        } else if($('#title').val()=='') { 
            alert('제목을입력해주세요'); 
            $('#title').focus();
        } else if($('#contents').val()=='') { 
            alert('내용을입력해주세요'); 
            $('#contents').focus();
        }
			else {
            $('#addForm').submit(); 
        }
    });
});
</script>

<div class="container">
   <h1>QNA WRITE</h1>
   		
	    <form id="addForm" action="${pageContext.request.contextPath}/QnaWrite_Action.do" method="post"> 
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
	            <input class="qtitle" name="title" id="title" type="text"/>
	        </div>
	        <div class="form-group">
	            <label for="contents">contents :</label>
	            <textarea class="qcontents" name="contents" id="contents" rows="5" cols="50"></textarea>
	        </div>
	
	        <div>
	            <input class="btn btn-default" id="addButton" type="button" value="글입력"/> 
	            <input class="btn btn-default" type="reset" value="초기화"/>
	            <a class="btn btn-default" href="${pageContext.request.contextPath}/IMemberQnaList.do">글목록</a>
	        </div>
    </form>
    
</div>
<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>