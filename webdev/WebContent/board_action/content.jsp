
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="board.models.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	long no = Long.parseLong(request.getParameter("no"));
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	StringBuffer sql = new StringBuffer();
	sql.append(" select no, name, title, content, regdate, readcount ");
	sql.append(" from board");
	sql.append(" where no=?");
	BoardVO boardVO = null;
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","n1","n1");
		ps = conn.prepareStatement(sql.toString());
		ps.setLong(1,no);
		rs = ps.executeQuery();
		if (rs.next()) {
			boardVO = new BoardVO();
			boardVO.setNo(rs.getLong("no"));
			boardVO.setTitle(rs.getString("title"));
			boardVO.setName(rs.getString("name"));
			boardVO.setReadcount(rs.getInt("readcount"));
			boardVO.setRegdate(rs.getString("regdate"));
			boardVO.setContent(rs.getString("content"));
		} else {
			throw new RuntimeException(no + "번 게시물이 존재하지 않습니다.");
		}
	} catch (RuntimeException e) { %>	
	
<% 	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rs != null) try {rs.close();} catch (Exception e) {}
		if (ps != null) try {ps.close();} catch (Exception e) {}
		if (conn != null) try {conn.close();} catch (Exception e) {}
	}
%>	

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MATERIAL</title>
</head>
<body style="background-color:ivory;">
<table border='1'>
	<caption>게시물 상세보기</caption>
<tr>
	<th>글번호</th>
	<td><%=boardVO.getNo() %></td>
</tr>
<tr>
	<th>제목</th>
	<td><%=boardVO.getTitle()%></td>
</tr>
<tr>
	<th>이름</th>
	<td><%=boardVO.getName()%></td>
</tr>
<tr>
	<th>내용</th>
	<td><%=boardVO.getContent()%></td>
</tr>
<tr>
	<th>조회수</th>
	<td><%=boardVO.getReadcount()%></td>
</tr>
<tr>
	<th>작성일</th>
	<td><%=boardVO.getRegdate()%></td>
</tr>	
</table><br/>
<a href="list.jsp">리스트</a>
<a href="update.jsp?no=<%=boardVO.getNo()%>">수정</a>
<a href="delete.jsp?no=<%=boardVO.getNo()%>">삭제</a>
	
</body>
</html>