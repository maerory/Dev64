<%@page import="cookie.test.Cooker"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="make_cookie.jsp">쿠키 생성</a>
<a href="remove_cookie.jsp">쿠키 삭제</a>
<hr/>
<%
	Cooker cooker = new Cooker(request);
	out.println(cooker.getValue("name"));
%>
</body>
</html>