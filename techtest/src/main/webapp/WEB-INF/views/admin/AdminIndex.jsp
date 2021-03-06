<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>   
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


<div class="adminWrapper">
       <div class="project">
       <div class="project-nav">
           <center><div  class="projectcate" >관리자 페이지</div></center>
                 <br>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">
                 	<a href="<%=request.getContextPath()%>/AdminImemInfoList.do">
                   <button type="button" class="btn btn-default">투자자회원정보</button>
                 	</a>
                 </div>
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminMoneyList.do">
                   <button type="button" class="btn btn-default">머니 충전 관리</button>
                 	</a>
                 </div>
                 
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminCmemInfoList.do">
                   <button type="button" class="btn btn-default">사업자 회원정보</button>
                 	</a>
                 </div>
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminCmemChkList.do">
                   <button type="button" class="btn btn-default">사업자 승인</button>
                 	</a>
                 </div>
                                  
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminProjChkList.do">
                   <button type="button" class="btn btn-default">프로젝트 승인</button>
                 	</a>
                 </div>
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminNoticeList.do">
                   <button type="button" class="btn btn-default">공지사항관리</button>
                 	</a>
                 </div>
                 
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminFaqList.do">
                   <button type="button" class="btn btn-default">FAQ관리</button>
                 	</a>
                 </div>
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/AdminQnaList.do">
                   <button type="button" class="btn btn-default">QNA관리</button>
                 	</a>
                 </div>
			
             </div>  
       </div>
       </div>
	<p class="adminP">회원 충전 대기</p>
	<div class="divTable">  
		<div class="clearFix rowTitle">
			<div class="col col6_1">No </div>
			<div class="col col6_2">회원</div>
			<div class="col col6_3">충전금액</div>
			<div class="col col6_4">신청일</div>
			<div class="col col6_5">상태</div>
			<div class="col col6_6">작업</div>
		</div>				
		
		
		<c:forEach var="hashmap" items="${alist}">
		<div class="clearFix">
			<div class="col col6_1">${hashmap.RNUM}</div>
			<div class="col col6_2"><a href="<c:url value='/' />/AdminImemInfoCon.do?param_idx=${hashmap.IDX}">${hashmap.NAME}</a></div>
			<div class="col col6_3">${hashmap.CHGMONEY }원</div>
			<div class="col col6_4">${hashmap.INSDATE }</div>	    
			<c:choose>
				<c:when test="${hashmap.STATUS eq 0 }">
					<div class="col col6_5">승인대기</div>
					<div class="col col6_6">					
						<a href="<c:url value="/AdminMoneyChkOk_Action.do?param_idx=${hashmap.IDX}&mIdx=${hashmap.MIDX}"/>">
							<button type='button' class='btn btn-default'>승인</button>
						</a> 
						<a href="<c:url value="/AdminMoneyChkNOk_Action.do?param_idx=${hashmap.IDX }&mIdx=${hashmap.MIDX}"/>">
						<button type='button' class='btn btn-default'>반려</button></a>
					</div>
				</c:when>
				<c:when test="${hashmap.STATUS ne 0 }">
					<div class="col col6_5">승인완료</div>
					<div class="col col6_6"></div>
				</c:when>
				
			</c:choose>
		</div>  					    									
		</c:forEach>
		
	</div>	  
	
<p class="adminP">프로젝트 승인 대기</p>
	<div class="divTable">  
		<div class="clearFix rowTitle">
			<div class="col col5_1">No </div>
			<div class="col col5_2">프로젝트 명</div>
			<div class="col col5_3">신청일</div>
			<div class="col col5_4">상태</div>
			<div class="col col5_5">작업</div>	  
		</div>
	
	<c:set var="list" value="${requestScope.blist}"/>

		<c:forEach var="pv" items="${blist}">
		<div class="clearFix">
			<div class="col col5_1"></div>
			<div class="col col5_2"><a href="${pageContext.request.contextPath}/AdminProjChkCon.do?pIdx=${pv.pIdx}">${pv.pName}</a></div>
			<div class="col col5_3">${pv.insDate}</div>
			<c:choose>
				<c:when test="${pv.status eq 0 }">	    
					<div class="col col5_4">승인대기</div>	    
					<div class="col col5_5">
						<a href="<c:url value="/AdminProjChkOk_Action.do?pIdx=${pv.pIdx}"/>">
							<button type='button' class='btn btn-default'>승인</button>
						</a>
						<a href="<c:url value="/AdminProjChkNOk_Action.do?pIdx=${pv.pIdx }"/>">
							<button type='button' class='btn btn-default'>반려</button></a>	     
		  			</div>
				</c:when>
				<c:when test="${pv.status ne 0 }">
					<div class="col col5_4">승인완료</div>
					<div class="col col5_5"></div>
				</c:when>
			</c:choose>
		</div>
		</c:forEach>
	</div>
	
	
<p class="adminP">사업자 승인 대기</p>
	<div class="divTable">  
		<div class="clearFix rowTitle">
			<div class="col col5_1">No </div>
			<div class="col col5_2">사업자</div>
			<div class="col col5_3">신청일</div>
			<div class="col col5_4">상태</div>
			<div class="col col5_5">작업</div>	  
		</div>
	
		<c:forEach var="mv" items="${clist}">
		<div class="clearFix">
			<div class="col col5_1"></div>
			<div class="col col5_2"><a href="<c:url value="/AdminCmemInfoCon.do?param_idx=${mv.idx}"/>">${mv.name}</a></div>
			<div class="col col5_3">${mv.modDate}</div>	    
				<c:choose>
					<c:when test="${mv.status eq 0 }">
						<div class="col col5_4">승인대기</div>
						<div class="col col5_5">
					<a href="<c:url value="/AdminCmemChkOk_Action.do?param_idx=${mv.idx}"/>">
							<button type='button' class='btn btn-default'>승인</button>
					</a>
					<a href="<c:url value="/AdminCmemChkNOk_Action.do?param_idx=${mv.idx}"/>">
							<button type='button' class='btn btn-default'>반려</button>
					</a>
					</div>
					</c:when>
					<c:when test="${mv.status ne 0}">
							<div class="col col5_5">승인완료</div>
							<div class="col col5_6"></div>
					</c:when>
			
				</c:choose>
			</div>
		</c:forEach>
	</div>		
	
	</div>
<!-- main end -->
	</div>
</div>
</div>		

<%@ include file="/WEB-INF/views/footer.jsp" %>