<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection conn = null;
	try {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/mydbcp");
		conn = ds.getConnection();
		out.println("연결성공~!!");
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if (conn != null) try {conn.close();} catch(Exception e) {}
	}

%>

</body>
</html>