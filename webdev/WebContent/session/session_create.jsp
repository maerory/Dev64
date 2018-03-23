<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String user_id = null;	

	if (cookies != null) {
		for(Cookie cookie : cookies) {
			if (cookie.getName().equals("user_id")) {
				user_id = URLDecoder.decode(cookie.getValue(), "UTF-8");
			}
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="session_create_action.jsp">
<table>
	<caption>세션 생성</caption>
<tr>
	<th>아이디</th>
	<td><input type="text" name="user_id" value="<%=user_id != null ? user_id : ""%>"/><br/>
		<input type="checkbox" name="save_id" <%=user_id != null ? "checked" : "" %> />
		아이디 저장
	</td>
</tr>
<tr>
	<th>이름</th>
	<td><input type="text" name="user_name" /></td>
</tr>
<tr>
	<th>레벨</th>
	<td><select name="user_level">
			<option>1</option>
			<option>2</option>
			<option>3</option>
		</select></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="확인" />	
	</td>
</tr>
</table>
</form>
</body>
</html>