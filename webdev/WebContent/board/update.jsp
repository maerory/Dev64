
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="board.models.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물~</title>
</head>
<body>
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
			boardVO.setContent(rs.getString("content"));

		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rs != null) try {rs.close();} catch (Exception e) {}
		if (ps != null) try {ps.close();} catch (Exception e) {}
		if (conn != null) try {conn.close();} catch (Exception e) {}
	}
%>
<form action="update_action.jsp" method="post">
<table>

	<caption><i>게시물 수정</i></caption>
<tr>
	<th>글 번호</th>
	<td><%=boardVO.getNo()%><input type="hidden" name="no" value="<%=boardVO.getNo()%>" required="required"/></td>
</tr>
<tr>
	<th>이름</th>
	<td><input type="text" name="name" value="<%=boardVO.getName()%>" required="required"/></td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="title" value="<%=boardVO.getTitle()%>" required="required"/></td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="passwd" required="required"><br/>
		<font color="red">* Enter your original PW *</font>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea name="content" rows="5" cols="40" required="required"><%=boardVO.getContent()%></textarea></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="수정완료"/>
	</td>
</tr>
</table>
</form>
</body>
</html>