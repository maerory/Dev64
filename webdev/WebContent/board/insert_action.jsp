<%@page import="board.models.BoardDAOImpl"%>
<%@page import="board.models.BoardDAO"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection" %>
<%@page import="board.models.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String passwd = request.getParameter("passwd");
	
	BoardVO boardVO = new BoardVO();
	boardVO.setName(name);
	boardVO.setTitle(title);
	boardVO.setContent(content);
	boardVO.setPasswd(passwd);
	
	BoardDAO boardDAO = new BoardDAOImpl();
	boolean result = boardDAO.insertBoard(boardVO);
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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