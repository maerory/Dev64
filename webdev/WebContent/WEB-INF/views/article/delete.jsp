<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE!</title>
</head>
<body>
<form action="deleteAction" method="post">
<table>
	<caption>게시물 삭제</caption>
<tr>
	<th>글 번호</th>
	<td>${no}
		<input type="hidden" name="no" 
		value="${no}" required="required" /></td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="passwd" required="required" autofocus="autofocus" /><br/>
		<font color="red">* Re-enter your password.</font>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="삭제완료" />
	</td>
</tr>
</table>
</form>
</body>
</html>