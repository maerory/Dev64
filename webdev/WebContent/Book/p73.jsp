<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	int count = 0;
%>

<% 
	count++;
	if (request.getRemoteAddr().equals("70.12.50.168")) {
		if (count % 2 == 0) {
			out.println("당신은 앙돼영~!");
			return;
		}
	}
%>
ip: <%=request.getRemoteAddr() %><br/>
count: <%=count %>
requestURI : <%= request.getRequestURI() %>


</body>
</html>