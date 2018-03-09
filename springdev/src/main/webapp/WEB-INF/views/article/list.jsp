<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<caption>게시물 리스트</caption>
<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>
<c:forEach items="${list}" var="vo">
<tr>
	<td>${vo.no}</td>
	<td><a href="view?no=${vo.no}">${vo.title}</a></td>
	<td>${vo.name}</td>
	<td>${vo.regdate}</td>
	<td>${vo.readcount}</td>
</tr>
</c:forEach>
</table><br/>
<a href="insert">글쓰기</a>
</body>
</html>
