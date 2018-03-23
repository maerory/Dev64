<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection" %>
<%@page import="board.models.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ARTISTRY</title>
</head>
<body>
<%
	long no = Long.parseLong(request.getParameter("no"));
	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String passwd = request.getParameter("passwd");
	

	BoardVO boardVO = new BoardVO();
	boardVO.setNo(no);
	boardVO.setName(name);
	boardVO.setTitle(title);
	boardVO.setContent(content);
	boardVO.setPasswd(passwd);
	
	StringBuffer sql = new StringBuffer();
	sql.append(" UPDATE board set");
	sql.append(" name=?,title=?,content=?");
	sql.append(" where no=? and passwd=?");
	
	Connection conn = null;
	PreparedStatement ps = null;
	boolean result = false;
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","n1","n1");
		ps = conn.prepareStatement(sql.toString());
		ps.setString(1, boardVO.getName());
		ps.setString(2, boardVO.getTitle());
		ps.setString(3, boardVO.getContent());
		ps.setLong(4, boardVO.getNo());
		ps.setString(5, boardVO.getPasswd());
		if (ps.executeUpdate() > 0) result = true;
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if (ps != null) try {ps.close();} catch(Exception e) {}
		if (conn!= null) try {conn.close();} catch(Exception e){}
	}
%>
<script>
<% if (result) {  %>
		alert('수정 성공');
		location.href='content.jsp?no=<%=no%>';
<%	} else {  %>
		alert('비밀번호가 틀립니다.');
		location.href='javascript:history.back()';
<%	}  %>
</script>
</body>
</html>