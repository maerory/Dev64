<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "s" uri = "http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sql_select.jsp</title>
</head>
<body>
<s:setDataSource
	var="conn"
	driver="oracle.jdbc.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:xe"
	user="n1"
	password="n1"
/>
<c:catch var="exception_result">
	<s:query var="rs" dataSource="${conn}">
	select no, name, title, readcount,
			to_char(regdate, 'YYYY/MM/DD/') as regdate
	from board
	order by no desc
	</s:query>
</c:catch>
<c:if test="${!empty exception_result}">
	${exception_result.message }
</c:if>
<table>
<c:forEach items="${rs.rows}" var="article">
	<tr>
		<td>${article.no }</td>
		<td>${article.title }</a></td>
		<td>${article.name }</td>
		<td>${article.regdate }</td>
		<td>${article.readcount }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>