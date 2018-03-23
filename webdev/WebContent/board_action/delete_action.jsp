<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection" %>
<%@page import="board.models.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	long no = Long.parseLong(request.getParameter("no"));
	String passwd = request.getParameter("passwd");
	
	BoardVO boardVO = new BoardVO();
	boardVO.setNo(no);
	boardVO.setPasswd(passwd);
	
	StringBuffer sql = new StringBuffer();
	sql.append(" DELETE from board");
	sql.append(" where no=? and passwd=?");
	
	Connection conn = null;
	PreparedStatement ps = null;
	boolean result = false;

	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","n1","n1");
		ps = conn.prepareStatement(sql.toString());
		ps.setLong(1, boardVO.getNo());
		ps.setString(2, boardVO.getPasswd());
		if (ps.executeUpdate() > 0) result = true;
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if (ps != null) try {ps.close();} catch(Exception e) {}
		if (conn!= null) try {conn.close();} catch(Exception e){}
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ARTISTRY</title>
</head>
<body>
<script>
<% if (result) {  %>
		alert('삭제 성공');
		location.href='list.jsp';
<%	} else {  %>
		alert('비밀번호가 틀립니다.');
		location.href='javascript:history.back();';
<%	}  %>
</script>
</body>
</html>