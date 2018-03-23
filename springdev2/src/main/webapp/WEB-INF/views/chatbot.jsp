<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap start -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> HELPDESK </title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!-- bootstrap end -->
<link href="<c:url value="/resources/css/bubbles.css" />" rel="stylesheet">
<script type="text/javascript">
$(document).ready(function(){
	$('#btn_restart').click(function(){
		let re = confirm('기존 대화가 모두 사라집니다.\n대화를 재시작 할까요?');
		if (re) {
			$('#said').html('');
			ajax_process('');
			
		}
	});
	
	$('#txt_isay').keypress(function(e){
		if(e.which === 13) {
			conversation();
		}
	});
	
	$('#btn_isay').click(function(){
		conversation();
	});
	ajax_process('');
});

function conversation() {
	let _isay = $.trim($('#txt_isay').val());
	if (_isay ==='') {
		alert('뭐라고 말씀하시겠습니까?');
		return;
	}
	let isay = '<p class="triangle-border right">' + _isay + '</p>';
	$('#said').append(isay);
	$('#txt_isay').val('');
	ajax_process(_isay);
}

function ajax_process(_isay) {
	$.ajax({
		type:'POST',
		url :'watsonsay',
		data:{'isay': _isay },
	//	async:false,
		success: function(data){
			let watsonsay =
				'<p class="triangle-border left">' + data.output.text;
			if (_isay === '') {
				watsonsay += '<img src="<c:url value="/resources/img/james.png"/>" width=200/>'
			}
			watsonsay+= '</p>';
			$('#said').append(watsonsay);
			$('html, body').animate({scrollTop:$(document).height()}, 500);
		}
	});
}
</script>
</head>
<body>

<div class="chat_window">
<div class="top_menu">
<div class="buttons">
<div class="button close"></div>
<div class="button minimize"></div>
<div class="button maximize"></div>
</div>
<div class="title">HELPDESK CHATBOT</div>
</div><ul class="messages"></ul>
<div class="bottom_wrapper clearfix">
<div class="message_input_wrapper">
<div id="said"></div>
<button type="button" id="btn_restart" class="btn btn-default">대화 재시작</button>
<input type="text" id="txt_isay" class="triangle-border center" />
<button type="button" id="btn_isay" class="btn btn-success">say</button>
</body>
</html>