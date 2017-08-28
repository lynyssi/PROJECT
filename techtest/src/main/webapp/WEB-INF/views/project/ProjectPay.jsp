<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %> 
<%@ page import="com.mirin.tech.service.*" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
	<div class="bodyMain"> 
		<div class="main-section">
<!-- main start -->
<script>
$(function(){
	$('textarea.content').keyup(function(){
		bytesHandler(this);
	});
});

function getTextLength(str) {
	var len = 0;
	for (var i = 0; i < str.length; i++) {
		if (escape(str.charAt(i)).length == 6) {
			len++;
		}
		if (len > 100) { 
	        alert("100자를 초과할 수 없습니다."); 
	        document.ProjPay.delivery.value = str.substring(0, 50); 
	    
	        return 100;
	    } 
		len++;
	}
	return len;
}

function bytesHandler(obj){
	var text = $(obj).val();
	$('span.bytes').text(getTextLength(text));
}
	
function message(selectObj) {
	if(selectObj.value != "직접입력"){
		$('#textarea').hide();
	}else{
		$('#textarea').show();
	}
}
</script>
<style>
.pay-total-con {
	width: 879px;
	margin: 0 auto;
	padding: 0 30px;
	overflow: hidden;
	line-height: 1;
}
#pay-title {
	font-weight: bold;
	margin-top: 10px;
}
.pay-custom-info {
	border-top: 1px #6BBB1A solid;
	border-bottom: 1px #6BBB1A solid;
}
.pay-delivery {
	border-top: 1px #6BBB1A solid;
	border-bottom: 1px #6BBB1A solid;
}
.pay-table {
	width: 100%;
	border-collapse: collapse;
}
.delivery-table{
	width: 100%;
	border-collapse: collapse;
}
.pay-table .first{
	border-top: none;
}
.pay-table .last{
	border-bottom: none;
}
.delivery-table .first{
	border-top: none;
	border-bottom: none;
}
.pay-custom-info tbody th {
	background: #f0f0f0;
	text-align: center;
	border-right: 1px #bcbcbc solid;
	border-bottom: 1px #bcbcbc solid;
}
.pay-custom-info tbody td {
	padding: 15px 20px;
	border-bottom: 1px #bcbcbc solid;
}
.pay-delivery tbody th {
	background: #f0f0f0;
	text-align: center;
	border-right: 1px #bcbcbc solid;
	border-bottom: 1px #bcbcbc solid;
}
.pay-delivery tbody td {
	padding: 15px 20px;
	border-bottom: 1px #bcbcbc solid;
}
#inFunds{
	width: 70px;
}
#textarea{
	display: none; 
	width: 300px;
	padding-top: 10px;
}
</style>	
<div class="pay-total-con">
	<h1 style="border-left: 3px #6F9 solid">펀딩 결제</h1>
	<p id="pay-title">펀딩고객정보</p>
	
	<c:url var="action" value='/ProjPay_Action.do' />
	<form name ="ProjPay" id="ProjPay" class="form-horizontal ProjPay" action="${action }" method="post">
		<input class="form-control" type="hidden" name="idx" id="idx" value="${data.IDX }">
		<input class="form-control" type="hidden" name="pIdx" id="pIdx" value="${iv.pIdx }">
		<input class="form-control" type="hidden" name="itIdx" id="itIdx" value="${iv.itIdx }">
		<div class="pay-custom-info">
			<table class="pay-table">
				<colgroup>
					<col width="120px">
					<col width="350px">
					<col width="120px">
					<col width="350px">
				</colgroup>
				<tbody>
					<tr>
						<th class="first">주문하시는 분 </th>
						<td class="first" colspan="3">
							<strong>${data.NAME }</strong> 님
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${data.ADDR}</td>
						<th>이메일</th>
						<td>${data.ID }</td>
					</tr>
					<tr>
						<th class="last">연락처</th>
						<td class="last">${data.PHONE }</td>
						<th class="last">휴대폰</th>
						<td class="last">${data.PHONE }</td>
					</tr>			
				</tbody>
				
			</table>
		</div>
		
	<p id="pay-title">배송메세지</p>
		<div class="pay-delivery">
			<table class="delivery-table">
				<colgroup>
					<col width="120px">
					<col width="350px">
				</colgroup>
				<tbody>
					<th class="first">주문요청사항/<br>
					배송메세지</th>
					<td class="first">
						<select onchange="message(this)">
							<option selected="selected" value="">배송메세지를 선택해주세요</option>
							<option value="직접입력">직접입력</option>
							<option value="부재경비실">부재 시 경비실에 경비실에 맡겨주세요</option>
							<option value="부재시연락">부재시 연락주세요</option>
							<option value="부재시문앞">부재시 문 앞에 놓아주세요</option>
							<option value="출발연락">출발 전에 연락 주세요</option>
						</select>
						<div name="textarea" id="textarea">
							<textarea name="delivery" class="content" rows="3" cols="50" onkeyUp="keyup()"></textarea>
							<span class="bytes">0</span>/100
						</div>
					</td>
				</tbody>
			</table>
		</div>
		
	<p id="pay-title">충전금액 및 결제</p>
		<div class="pay-delivery">
			<table class="delivery-table">
				<colgroup>
					<col width="120px">
					<col width="350px">
				</colgroup>
				<tbody>
					<th class="first">충전금액</th>
					<td class="first">
						<input type="text" name="inFunds" id="inFunds"> (사용가능 금액 : <fmt:formatNumber value="${data.MONEY }" pattern="###,###,###원" />)
					</td>
				</tbody>
			</table>
		</div>	
	 
</div>
<!-- main end -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>