<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JoeyYoo</title>
<link rel="icon" type="image/png" href="img/triforce.png">
</head>
<body>
   <% //script
   Calendar c = Calendar.getInstance();
   out.println(
         c.get(Calendar.MONTH) + 1 +"월"+
         c.get(Calendar.DATE)+ "일"
         );
%>

</body>
</html>