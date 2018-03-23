<%@ page import = "session.test.MemberVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	MemberVO memberVO = new MemberVO();
	memberVO.setUser_id("next");
	memberVO.setUser_name("신해철");
	memberVO.setUser_level(1);
--%>
<%= 10 + 5 %><br/>
\${10 + 5 } <br/>
${10 / 5 } <br/>
<c:set var="hangul" value="${ {'가','나','다'} }" />
${hangul}

</body>
</html>