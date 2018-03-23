<%@page import="board.models.BoardDAOImpl"%>
<%@page import="board.models.BoardDAO"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="board.models.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	BoardDAO boardDAO = BoardDAOImpl.getInstance();
	List<BoardVO> list = boardDAO.getBoardList();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GET OUT</title>
</head>
<body style="background-color:powderblue;">
<table>
	<caption><b>시간과 정신의 방</b></caption>
<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>이름</th>
	<th>작성일</th>	
	<th>조회수</th>
</tr>
<% for (BoardVO boardVO : list) { %>
	<tr>
		<td><%= boardVO.getNo() %></td>
		<td><a href="content.jsp?no=<%=boardVO.getNo()%>"><%= boardVO.getTitle() %></a></td>
		<td><%= boardVO.getName() %></td>
		<td><%= boardVO.getRegdate()%></td>
		<td><%= boardVO.getReadcount()%></td>
	</tr>
<% } %>

</table><br/>
<a href="insert.jsp">글쓰기</a>
</body>
</html>