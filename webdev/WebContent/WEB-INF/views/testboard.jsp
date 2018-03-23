<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<f:setLocale value="ja_JP" />
<f:bundle basename="i18n/test_board">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<caption><f:message key="board.caption" /></caption>
<tr>
	<th><f:message key="board.no" /></th>
	<th><f:message key="board.title" /></th>
	<th><f:message key="board.name" /></th>
	<th><f:message key="board.regdate" /></th>
	<th><f:message key="board.readcount" /></th>
</tr>
<c:forEach items="${list}" var="vo">
	<tr>
		<td>${vo.no}</td>
		<td><a href="content.jsp?no=${vo.no}">${vo.title}</a></td>
		<td>${vo.name}</td>
		<td>${vo.regdate}</td>
		<td>${vo.readcount}</td>
	</tr>
</c:forEach>
<tr>
	<td colspan="5">
		<c:forEach begin="1" end="10" var="p">
			<c:if test="${p != pg}"><a href="TestBoard">${p}</a></c:if>
			<c:if test="${p == pg}">${p}</c:if>
		</c:forEach>
	</td>
</tr>
<tr>
	<td colspan="5">
		<c:forEach begin="1" end="10" var="p">
			<c:choose>
				<c:when test="${p != pg}"><a href="TestBoard">${p}</a></c:when>
				<c:when test="${p == pg}">${p}</c:when>
			</c:choose>
		</c:forEach>
	</td>
</tr>
</table>
</body>
</html>
</f:bundle>
