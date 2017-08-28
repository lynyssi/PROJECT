<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Attribute start -->
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
           <center><div  class="projectcate" >투자참가 리스트</div></center>
                 <br>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">
                  <a href="<%=request.getContextPath() %>/CMemberIndexP.do">
                   <button type="button" class="btn btn-default">사업자 마이페이지</button>
                   </a>
                 </div>
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/CMemberInfoExtWrite.do">
                   <button type="button" class="btn btn-default">사업자 등록</button>
                   </a>
                 </div>
                 
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/CMemberInfoCon.do">
                   <button type="button" class="btn btn-default">사업자 회원정보 수정 </button>
                   </a>
                 </div>
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/CMemberProjNowList.do">
                   <button type="button" class="btn btn-default">사업자 진행중 프로젝트</button>
                   </a>
                 </div>
                                  
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath() %>/CMemberProjHisList.do">
                   <button type="button" class="btn btn-default">사업자 완료된 프로젝트</button>
                   </a>
                 </div>
                 <div class="btn-group" role="group">            
                 <a href="<%=request.getContextPath() %>/CMemberProjApplyWrite.do">
                   <button type="button" class="btn btn-default">사업자 프로젝트 신청</button>
                 </a>
                 </div>
             </div>  
       </div>
       </div>
<script>
$(document).ready(function(){
    $('#cmemberModifyButton').click(function(){
        if($('#name').val().length <1) { 
            alert('이름은 1자이상 이어야 합니다.'); 
            $('#name').focus(); 
        } else if($('id').val()=='') {
            alert('아이디를 입력하세요.');
            $('#id').focus();
        } else if($('#pw').val()=='') {
            alert('패스워드를 입력하세요.');
            $('#pw').focus();
        } else if($('#nick').val()=='') {
            alert('닉네임을 입력하세요.');
            $('#nick').focus();
        } else if($('#phone').val()=='') {
            alert('전화번호를 입력하세요.');
            $('#phone').focus();
        } else if($('#addr').val()=='') {
            alert('주소를 입력하세요.');
            $('#addr').focus();
        } else if(confirm("수정 하시겠습니까?")){
        	$('#cmemberModifyAction').submit();
    	} else {
    		return false;
    	}
    });
});
</script>
	<c:url var="action" value="/CMemberInfoMod_Action.do" />
	<form id="cmemberModifyAction" class="form-horizontal cmemberModifyAction" 	action="${action }" method="post" >
  		<div class="form-group">
  	 	</div>
  	 	<div class="form-group">
    		<label for="name" class="col-sm-3 control-label">성명</label>
    		<div class="col-sm-9">
      			<input class="form-control" type="text" name="name" id="name" value="${data.NAME }" readonly>
   		</div>
  		</div>
  		<div class="form-group">
   	 		<label for="id" class="col-sm-3 control-label">이메일</label>
    		<div class="col-sm-9">
      				<input class="form-control" type="text" id="id" value="${data.ID }"  readonly>
   			</div>
 		</div>
 		<div class="form-group">
   	 		<label for="pw" class="col-sm-3 control-label">비밀번호</label>
    		<div class="col-sm-9">
      				<input  class="form-control" type="password" name="pw" id="pw" value="${data.PW }">
   			</div>
 		</div>
  		<div class="form-group">
    		<label for="nick" class="col-sm-3 control-label">닉네임</label>
    		<div class="col-sm-9">
      				<input class="form-control" type="text" name="nick" id="nick" value="${data.NICK }">
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="phone" class="col-sm-3 control-label">전화번호</label>
    		<div class="col-sm-9">
      				<input class="form-control" type="text" name="phone" id="phone" value="${data.PHONE }">
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="addr" class="col-sm-3 control-label">주소</label>
    		<div class="col-sm-9">
      				<input  class="form-control" type="text" name="addr" id="addr" value="${data.ADDR }">
   		 	</div>
  		</div>
  		<center><input class="btn btn-primary" id="cmemberModifyButton" type="button" value="수정" ></center>
	</form>



	

<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>