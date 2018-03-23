<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<caption>가위, 바위, 보</caption>
<tr>
	<th>You</th>
	<th rowspan="2">vs</th>
	<th>Com</th>
</tr>
<tr>
	<td>${you}</td>
	<td>${com}</td>
</tr>	
</table>
<h1>${win}</h1>
</body>
</html>