<%@page import="board.models.BoardDAOImpl"%>
<%@page import="board.models.BoardDAO"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection" %>
<%@page import="board.models.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="boardVO" class="board.models.BoardVO">
	<jsp:setProperty name="boardVO" property="*"/>]
</jsp:useBean>
<%

	out.println(boardVO);
	if (true) return;
	
	BoardDAO boardDAO = BoardDAOImpl.getInstance();
	boolean result = boardDAO.insertBoard(boardVO);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8>
<title>ARTISTRY</title>
</head>
<body>
<script>
<% if (result) {  %>
		alert('입력 성공');
		location.href='list.jsp';
<%	} else {  %>
		alert('입력 실패');
		location.href='javascript:history.back()';
<%	}  %>
</script>
</body>
</html>