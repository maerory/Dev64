<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap start -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!-- bootstrap end -->
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
<tr>
	<td colspan="5">
	<nav>
  	<ul class="pagination">
		<c:if test="${startPage != 1}">
			<li class="active">
				<a href="list?pg=${startPage - 1}" aria-label="Previous">&laquo;</a>
			</li>
		</c:if>
		<c:if test="${startPage == 1}">
			<li class="disabled">
				<a href="#" aria-label="Previous">&laquo;</a>
			</li>
		</c:if>
		
		
		<c:forEach var="p" begin="${startPage}" end="${endPage}">
			<c:if test="${p != pg}"><li class="active"><a href="list?pg=${p}">${p}</a></li></c:if>
			<c:if test="${p == pg}"><li class="disabled"><a href="#">${p}</a></li></c:if>
		</c:forEach>
		<c:if test="${endPage != totalPage}">
			<li class="active">
				<a href="list?pg=${endPage + 1}" aria-label="Next">&raquo;</a>
			</li>
		</c:if>
		<c:if test="${endPage == totalPage}">
			<li class="disabled">
				<a href="#" aria-label="Next">&raquo;</a>
			</li>
		</c:if>
	</ul>
	</nav>
	</td>
</tr>
</table><br/>
<a href="insert">글쓰기</a>
</body>
</html>
