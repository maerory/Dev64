
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MATERIAL</title>
</head>
<body style="background-color:ivory;">
<table border='1'>
	<caption>게시물 상세보기</caption>
<tr>
	<th>글번호</th>
	<td>${article.no}</td>
</tr>
<tr>
	<th>제목</th>
	<td>${article.title}</td>
</tr>
<tr>
	<th>이름</th>
	<td>${article.name}</td>
</tr>
<tr>
	<th>내용</th>
	<td>${article.content}</td>
</tr>
<tr>
	<th>조회수</th>
	<td>${article.readcount}</td>
</tr>
<tr>
	<th>작성일</th>
	<td>${article.regdate}</td>
</tr>	
</table><br/>
<a href="list">리스트</a>
<a href="update?no=${article.no}">수정</a> |
<a href="delete?no=${article.no}">삭제</a>
	
</body>
</html>