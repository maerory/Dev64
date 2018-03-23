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
</head>
<body>
업로드된 파일 : <a href="download?fileName=${originalName}">${originalName}(${fileSize})</a>
<br/>
<c:if test="${isImage==true}">
	<li>원본 이미지 </li>
	<img alt="원본이미지" src="download?fileName=${originalName}"><br/>
	<li>썸네일 이미지 </li>
	<img alt="썸네일이미지" src="download?fileName=thumb_${originalName}"><br/>
</c:if>

<c:if test="${isAudio==true}">
	<li>음악 </li>
	<audio controls>
		<source src="download?fileName=${originalName}" type="audio/mp3">
	</audio>
</c:if>


</body>
</html>