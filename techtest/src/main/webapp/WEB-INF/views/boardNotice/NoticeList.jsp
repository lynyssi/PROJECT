<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
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
<script>
function goList(page) {
	  var form = document.getElementById("listForm");
	  form.curPage.value = page;
	  form.submit();
	 }
</script>
<div class="project">
       <div class="project-nav">
           <center><div  class="projectcate" >NOTICE</div></center>
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

<h3>NOTICE</h3>

	<div class="NoticeTable">
		<div class ="row thead">
			<div class="cell col2">제목</div>
			<div class="cell col3">조회수</div>
			<div class="cell col4">날짜</div>
		</div>	
	
<c:forEach var="bv" items="${alist}">
	<div class ="row">
		<div class="cell col2"><a href="<c:url value='/NoticeCon.do?bIdx=${bv.bIdx}'/>">${bv.title}</a></div>
		<div class="cell col3">${bv.hit}</div>
		<div class="cell col4">${bv.insDate}</div>
	</div>
	
	</c:forEach>
<div id="paging" style="text-align: center;">
  <c:if test="${prevLink > 0 }">
  	<a href="javascript:goList('${prevPage }')">[이전]</a>
  </c:if>

  <c:forEach var="i" items="${pageLinks }" varStatus="stat">
  	<c:choose>
    	<c:when test="${curPage == i}">
    		<span class="bbs-strong">${i }</span>
   		</c:when>
   		<c:otherwise>
    		<a href="javascript:goList('${i }')">${i }</a>
   		</c:otherwise>
  	</c:choose>
  </c:forEach>
  
  <c:if test="${nextLink > 0 }">
  	<a href="javascript:goList('${nextPage }')">[다음]</a>
  </c:if>
</div>
 
 <div id="form-group" style="display: none;">
 	<form id="listForm" action="/techforest/IMemberQnaList.do" method="get">
   		<input type="hidden" name="curPage" />
 	</form>
 </div>
</div>

<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>