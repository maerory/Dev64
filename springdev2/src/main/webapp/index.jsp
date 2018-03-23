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
<title> Spring Web Index </title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!-- bootstrap end -->
</head>
<body>
<h1>index</h1>
<ol>
	<li><a href="product/getProduct">JACKSON (object)</a></li>
	<li><a href="product/getProductList">JACKSON2 (list)</a></li>
	<li><a href="product/view">view</a></li>
	<li><a href="chatbot/">CHATTY</a></li>
	
</ol>
</body>
</html>