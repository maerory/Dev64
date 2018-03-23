<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.sendRedirect("article/list");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title please</title>
</head>
<body>
<ol>
	<li><a href="board/list.jsp">게시판</a></li>
	<li><a href="hello.jsp">서브렛 테스트</a></li>
	<li><a href="TestBoard"> JTSL 루프테스트</a></li>
</ol>

</body>
</html>
<%-- <c:redirect url="TestBoard"/> --%>