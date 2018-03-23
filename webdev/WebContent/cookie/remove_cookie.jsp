<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("name", URLEncoder.encode("김남혁","UTF-8"));
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	response.sendRedirect("eat_cookie.jsp");
%>
