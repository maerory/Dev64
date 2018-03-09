<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />' type="text/css">
</head>
<body>
<form:form method="post" commandName="memoVO">
<table>
	<caption>메모 입력</caption>
<tr>
	<th>이름</th>
	<td><input type="text" name="name" autofocus="autofocus" value="${memoVO.name}" />
		<form:errors path="name" cssClass="msg_warn"/>
	</td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="title" value="${memoVO.title}" />
		<form:errors path="title"  cssClass="msg_warn"/>
	</td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="passwd" />
		<form:errors path="passwd"  cssClass="msg_warn"/>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea name="content" rows="5" cols="40">${memoVO.content}</textarea>
		<form:errors path="content"  cssClass="msg_warn"/>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="입력완료" />
		
	</td>
</tr>
</table>
</form:form>
</body>
</html>