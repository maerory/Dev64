<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "s" uri = "http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sql_insert.jsp</title>
</head>
<body>
<s:setDataSource
	var="conn"
	driver="oracle.jdbc.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:xe"
	user="n1"
	password="n1"
/>
<c:catch var="exception_result">
	<s:update var="result" dataSource="${conn}">
	INSERT INTO board (no,name,title,content,passwd)
	VALUES (seq_board.nextval, '넬','백색왜성','~~~~','1111')
	</s:update>
</c:catch>
<c:if test="${!empty exception_result}">
	${exception_result.message }
</c:if>
${result} 개의 레코드가 insert 되었습니다.
</body>
</html>