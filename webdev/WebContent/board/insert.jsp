<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DRUWA</title>
</head>
<body style="background-color:MediumSpringGreen;">
<form action="insert_action.jsp" method="post">
<table>

	<caption>게시물 입력</caption>
<tr>
	<th>이름</th>
	<td><input type="text" name="name" autofocus="autofocus"/></td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="title"/></td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="passwd"/></td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea name="content" rows="5" cols="40"></textarea></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="입력완료"/>
	</td>
</tr>
</table>
</form>
</body>
</html>