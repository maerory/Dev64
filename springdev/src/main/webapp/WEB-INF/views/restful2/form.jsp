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
<title> page title </title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!-- bootstrap end -->
<script type="text/javascript">
$(document).ready(function() {
	$('#btnOk').click(function() {
		$.ajax({	 //버튼을 눌렀을때 비동기로 JSON을 전달해
					//저 URL에 버튼에 있는 TYPE중으로 호출
			url : './',
			type : $('#_method').val(),
			data : {name: 'Joey',
					age : '27' }
		});	
	});
});


</script>
</head>
<body>
<!-- Post 방식 때는 ?가 사라진다! -->
<form id="restfulform"> 
<select id="_method">
	<option>GET</option>
	<option>POST</option>
	<option>DELETE</option>
	<option>PUT</option>
</select>
<input type="button" value="확인" id="btnOk"/>
</form>
</body>
</html>