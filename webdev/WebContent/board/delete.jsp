
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
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
%>
<form action="delete_action.jsp" method="post">
<table>

	<caption><i>게시물 삭제</i></caption>
<tr>
	<th>글 번호</th>
	<td><%=no%>
	<input type="hidden" name="no" value="<%=no%>" required="required"/></td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="passwd" required="required" autofocus="autofocus"><br/>
		<font color="red">* Enter your original PW *</font>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="완료"/>
	</td>
</tr>
</table>
</form>
</body>
</html>