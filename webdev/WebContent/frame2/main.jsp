<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "김남혁";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>TrendSetter</title>
</head>
<body topmargin="0" leftmargin="0">
<table width="1004" height="1000">
<tr>
	<td colspan="2" height="100" bgcolor="deeppink"><jsp:include page="top.jsp"><td>
		<jsp:param value="<%=name %>" name="name" />
		</jsp:include>
</td>
<tr>
	<td bgcolor="ff0000" width="20%"><jsp:include page="menu.jsp" /></td>
	<td bgcolor="Maroon" width="80%"><jsp:include page="content.jsp"/></td>
</tr>
</table>

</body>
</html>





