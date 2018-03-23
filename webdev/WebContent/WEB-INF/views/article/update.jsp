<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHANGE!</title>
</head>
<body>
<form action="updateAction" method="post">
<table>
	<caption>게시물 수정</caption>
<tr>
	<th>글 번호</th>
	<td>${article.no}<input type="hidden" name="no" value="${article.no}" /></td>
</tr>
<tr>
	<th>이름</th>
	<td><input type="text" name="name" 
		value="${article.name}" autofocus="autofocus" required="required" /></td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="title" value="${article.title}" required="required"/></td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="passwd" required="required"/><br/>
		<font color="red">* 처음 글 작성시 입력한 비밀번호를 재 입력하세요</font>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea name="content" rows="5" cols="40" required="required">${article.content}</textarea></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="완료" />
	</td>
</tr>
</table>
</form>
</body>
</html>