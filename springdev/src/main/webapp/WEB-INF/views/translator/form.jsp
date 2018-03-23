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
<title> 번역 </title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!-- bootstrap end -->
<script type="text/javascript">
$(document).ready(function(){
	$('#source').on('change', function(){
		$.post("./",{ 'source' : $('#source').val() })
		 .done(function(data){
			 $('#result').html(data)
		 })
		 .fail(function(){
			 alert('수행 에러');
		 })
		;
	});
});
</script>
<h1>전문번역 서비스!</h1>
</head>
<body>
<form name="mytran" method="post">
<table>
<tr>
	<td>??????</td>
	<td><textarea rows="5" cols="50" name="source" id="source"></textarea></td>
</tr>
	<td>Korean</td>
	<td><textarea rows="5" cols="50" name="source" id="result"></textarea></td>

</table>
<br/>
<p>어떤 언어든지 한국어로 번역해 드립니다. 대한민국만세!</p>
</form>
</body>
</html>