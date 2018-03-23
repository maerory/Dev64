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
	$.getJSON( "getProductList", function( data ) {
		  var items = '<table border="/"><caption>제품들...</caption>';
		  items += '<tr><th>name</th><th>price</th><th>amount</th><th>comment</th></tr>';
		  $.each( data, function( index, val ) {
			  items += '<tr>';
			  items += '<td>' + val['name'] + '</td>';
			  items += '<td>' + val['price'] + '</td>';
			  items += '<td>' + val['amount'] + '</td>';
			  items += '<td>' + val['comment'] + '</td>';
			  items += '</tr>';
		  });
		  items += '</table>';
		  $("#product_list").html(items);
	});
});
</script>
</head>
<body>
${msg}
<hr/>
<div id="product_list"></div>
</body>
</html>