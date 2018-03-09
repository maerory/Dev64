<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="article" value="${articleVO}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
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
<a href="list">리스트</a> |
<a href="update?no=${article.no}">수정</a> |
<a href="delete?no=${article.no}">삭제</a>
</body>
</html>