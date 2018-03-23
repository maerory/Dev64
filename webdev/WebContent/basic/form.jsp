<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="process.jsp" method="get">
이름 : <input type="text" name="name" autofocus="autofocus" /><br/>
이름 : <input type="text" name="name"/><br/>
주소 : <input type="text" name="address"/><br/>
전화 : <input type="text" name="tel" /><br/>
우편번호 : <input type="text" name="zipcode"/><br/>
취미 : <br/>
<input type="checkbox" name="hobby" value="잠자기"/> 잠자기<br/>
<input type="checkbox" name="hobby" value="뒹굴기"/> 뒹굴기<br/>
<input type="checkbox" name="hobby" value="가위눌리기"/> 가위눌리기<br/>
<input type="submit" value="say"/>
</form>
</body>
</html>