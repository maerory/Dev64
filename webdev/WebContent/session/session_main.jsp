<%@page import="session.test.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>	
<body>
	<a href="session_create.jsp">세션생성</a>
	<a href="session_remove.jsp?item=user_id">아이디 삭제</a>
	<a href="session_remove.jsp?item=user_name">이름 삭제</a>
	<a href="session_remove.jsp?item=user_level">레벨 삭제</a>
	<a href="session_remove.jsp?item=user_info">MemberVO 삭제</a>
	<a href="session_invalidate.jsp">세션 종료</a>
	<hr />
	<%
		//HttpSession httpSession = request.getSession();

		String user_id = (String) session.getAttribute("user_id");
		String user_name = (String) session.getAttribute("user_name");
		Integer user_level = (Integer) session.getAttribute("user_level");
		MemberVO memberVO = (MemberVO) session.getAttribute("user_info");
		if (user_id != null) {

			Cookie[] cookies = request.getCookies();

			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("save_id")) {
	%>
	아이디 :
	<%=user_id%><br />
	<%
		}
				}
			}
		}
	%>

	<%
		if (user_name != null) {
	%>
	이름 :
	<%=user_name%><br />
	<%
		}
		if (user_level != null) {
	%>
	레벨 :
	<%=user_level%><br />
	<%
		}
		if (memberVO != null) {
	%>
	<%=memberVO%>
	<%
		}
	%>
</body>
</html>