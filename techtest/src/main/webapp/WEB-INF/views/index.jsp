<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
	<div class="bodyMain"> 
<!-- main start -->
<script>
$(window).on('load',function(){
	$('#myModal').modal('show');
});
</script>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">프로젝트 설명</h4>
      </div>
      <div class="modal-body">
        <br>TechForest(SpringFramework4.3을 이용한 크라우드 펀딩 사이트).
		<br>(developed By 김미린)
		
		<br>기획 / 설계
		
		<br>고객의 요구사항을 분석하여 수행계획서 작성
		<br>2) 스토리보드 작성 - 화면구조(UI) 설계
		<br>3) 테이블정의서 / ERD 작성 - DB 설계
		<br>4) 클래스다이어그램 작성 - 프로그램 설계
		
		<br>------------------------------------------------------------------------
		
		<br>개발
		
		<br>1) SpringMVC를 활용
		<br>2) Mybatis를 활용
		<br>3) 뷰단 jstl, el, javascript, ajax, jQuery, html5, css3
		<br>4) Maven 사용
		<br>5) 형상관리 gitHub
		<br>6) Oracle / MySQL 데이터베이스 활용
		<br>7) 서비스 개발 환경 : Windows / Linux / Tomcat
		<br>8) 개발 툴 : 이클립스
		<br>9) 데이터 모델링 툴 : exerd, uml
		 
		<br>------------------------------------------------------------------------
		<br>특징
		
		<br>1) 웹MVC(Model2)로 개발 작업 후 이를 SpringMVC로 변환하며 각각의 차이점을 확인
		<br>2) 공통 모듈 작업(회원 로그인, 페이징, 로그)
		<br>3) 프로젝트 완료 보고서 작성
		<br>4) 부트스트랩을 활용하여 화면단 구현
		<br>5) gitHub로 버전관리
		<br>------------------------------------------------------------------------
		<br>관리자:admin@email.com / 비밀번호:123456
		<br>투자자:member1@email.com/ 비밀번호:123456
		<br>사업자:cmember1@email.com/ 비밀번호:123456
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<main>
   <div class="MainWrap clearfix">

      <div class="main-section">
         
         <div class="main-section1">
         <center>
          <img src="/techtest/resources/images/BEST.png" alt="BEST" style="width:200px;">   
         </center>
              <div class="container">
               <div id="myCarousel" class="carousel slide" data-ride="carousel">
                 <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1"></li>
                  <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>

                 <div class="carousel-inner" style="width: 625px; height: 298.625px;">
                  
                  <div class="item active">
                  <a href="<%=request.getContextPath()%>/Projectindex.do" >
                    <img src="/techtest/resources/images/rebox.png" alt="rebox">
                    </a>
                  </div>

                  <div class="item">
                  <a href="<%=request.getContextPath()%>/Projectindex.do" >
                    <img src="/techtest/resources/images/star.png" alt="star">
                    </a>
                  </div>
                
                  <div class="item">
                  <a href="<%=request.getContextPath()%>/Projectindex.do" >
                    <img src="/techtest/resources/images/book2.png" alt="book2">
                    </a>
                  </div>
                </div>

                 <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                  <span class="glyphicon glyphicon-chevron-left"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                  <span class="glyphicon glyphicon-chevron-right"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
               </div> 
         </div>
             <div class="main-section2">
                <div style="font-size: 17px; border:solid #669999 1px; text-align: center;">PROJECT FUNDING CATE</div>
                 <br>
                 <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/ProjectListByPower.do">
                   <button type="button" class="btn btn-default">                   
					파워랭킹					
                   	</button></a>
                 </div>
                 <div class="btn-group" role="group">                 
                   <a href="<%=request.getContextPath()%>/ProjectListByTech.do">
                   <button type="button" class="btn btn-default">
					기술랭킹					
				</button></a>
                 </div>
                 </div>
                 <br>
                 <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">            
                   <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=TECH">
                   <button type="button" class="btn btn-default">
					IT/TECH					
				</button></a>
                 </div>
                 <div class="btn-group" role="group">             
                   <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=BEAUTY">
                   <button type="button" class="btn btn-default">
					BEAUTY					
				</button></a>
                 </div>
                 </div>
                 <br>
                 <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=HANDMADE">
                   <button type="button" class="btn btn-default">                   
					HAND MADE					
				</button></a>
                 </div>
                 <div class="btn-group" role="group">
                   <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=FOOD">
                   <button type="button" class="btn btn-default">                   
					FOOD					
				</button></a>
                 </div>
                 </div>
                 <br>
                 <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=FASHION">
                   <button type="button" class="btn btn-default">                   
					FASHION					
				</button></a>
                 </div>
                 <div class="btn-group" role="group">
                 <a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=ETC">
                   <button type="button" class="btn btn-default">                   
					ETC.					
				</button></a>
                 </div>
                 </div>
                 <br>
                 <center> <img src="/techtest/resources/images/text2.png" alt="text2" style="width:200px;"> 
                 </center> 

             </div>  
       
         <div class="main-section3">
            
            <div class="main-section32">
               <center><h3 style="color: white;">자금의 불균형, 불가능에 도전하다.</h3></center>
               <div><span style="font-size: 20px; text-align: center;">금융의 사회적인 역할과 크라우드펀딩의 본질에 대해 연구하며, 힘과 정보의 불균형을 해결하고<br>공급과 수요를 직접 연결할 수 있는 금융 커뮤니티를 만들어가고 있습니다.<br> 크라우드 펀딩은 눈속임으로 단순히 많은 돈을 모으는 일이 아닙니다.<br> 다양한 사람들의 지혜를 신뢰하며 투명하고 진정성 있는,<br> 더 나은 삶을 만들기 위해 매일 우리는 도전합니다.</span></div>
            </div>
            <div class="main-section33">
               <img src="/techtest/resources/images/techforest2.png" alt="techforest2" style="width:1040px; height: 370px;">
            </div>
            
         </div>
        
      </div>

   </div>
 
   <script>
      $('.carousel').carousel()
   </script> 
	
	



<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>