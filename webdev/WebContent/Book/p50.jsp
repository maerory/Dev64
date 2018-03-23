<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String bookTitle = "슬램덩크";
	String author = "타케히코 이노우에";
	out.println("<strong>" + bookTitle + "</strong>(" + author + ")");
%>
<strong%=bookTitle %></strong>(<%=author %>)
</body>
</html>