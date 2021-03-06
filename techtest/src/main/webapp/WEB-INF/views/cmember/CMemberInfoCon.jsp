<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Attribute start -->
<%@ page import="com.mirin.tech.service.*" %>
<%@ page import="java.util.*" %>
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
	<form class="form-horizontal cmemberCon" style="width:500px; margin:0 auto; margin-top:40px; border:1px solid black; padding:15px;">
		<div class="form-group">
    		<label for="name" class="col-sm-3 control-label">성명</label>
    		<div class="col-sm-9">
      			${data.NAME }
   		 	</div>
  		</div>
  		<div class="form-group">
   	 		<label for="id" class="col-sm-3 control-label">이메일</label>
    		<div class="col-sm-9">
    			${data.ID }
   			</div>
 		</div>
  		<div class="form-group">
    		<label for="nick" class="col-sm-3 control-label">닉네임</label>
    		<div class="col-sm-9">
      			${data.NICK }
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="phone" class="col-sm-3 control-label">전화번호</label>
    		<div class="col-sm-9">
      			${data.PHONE }
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="addr" class="col-sm-3 control-label">주소</label>
    		<div class="col-sm-9">
      			${data.ADDR }
   		 	</div>
  		</div>
  		<center>
	  		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
	 			회원정보 수정
			</button>
		</center>
  	</form>
  	
  	<center><h3>추가정보</h3></center>
  	<p class="text-center">사업자 관련 정보 수정이 필요한경우 고객센터로 문의 바랍니다.
  	
  	<form class="form-horizontal cmemberCon" style="width:500px; margin:0 auto; border:1px solid black; padding:15px;">  	
	  		<div class="form-group">
	    		<label for="company" class="col-sm-3 control-label">회사명</label>
	    		<div class="col-sm-9">
	      			<c:out value="${data.COMPANY }" default="등록되지 않았습니다" />
	   		 	</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="cNumber" class="col-sm-3 control-label">사업자번호</label>
	    		<div class="col-sm-9">
	      			<c:out value="${data.CNUMBER }" default="등록되지 않았습니다" />
	   		 	</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="cAddr" class="col-sm-3 control-label">사업자주소</label>
	    		<div class="col-sm-9">
	    			<c:out value="${data.CADDR }" default="등록되지 않았습니다" />
	   		 	</div>
	  		</div>
	 </form>
  	
  	<c:url var="action" value='/CMemberInfoMod.do' />
  	<form id="ModifyForm" action=${action } method="post">	
		<div class="modal fade imemberModify" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		        <span aria-hidden="true">&times;</span>
		        </button>
		        <h4 class="modal-title" id="myModalLabel">비밀번호를 입력해주세요.</h4>
		      </div>
		      <div class="modal-body">
		      	 <input class="form-control" type="password" name="pw" id="pw">
		      </div>
		      <div class="modal-footer">
		        <button type="submit" id="ModifyForm" class="btn btn-primary">입력</button>
		      </div>
		    </div>
		  </div>
		</div>
	</form>



	

<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>