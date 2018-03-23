<%@page import="java.net.URLEncoder"%>
<%@page import="session.test.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
	String user_name = request.getParameter("user_name");
	int user_level = Integer.parseInt(request.getParameter("user_level"));
	
	Cookie cookie = new Cookie("user_id", URLEncoder.encode(user_id,"UTF-8"));
	cookie.setMaxAge(
			request.getParameter("save_id") != null ?
					60 * 60 * 24 * 30 * 12 : 0);
	response.addCookie(cookie);
	
	MemberVO memberVO = new MemberVO();
	memberVO.setUser_id(user_id);
	memberVO.setUser_name(user_name);
	memberVO.setUser_level(user_level);
	
	session.setMaxInactiveInterval(60 * 60);
	session.setAttribute("user_id", user_id);
	session.setAttribute("user_name", user_name);
	session.setAttribute("user_level", user_level);
	session.setAttribute("user_info", memberVO);

	response.sendRedirect("session_main.jsp");
%>