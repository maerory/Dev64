<%@page import="cookie.test.Cooker"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.addCookie(Cooker.createCookie("name", "이동규", 10));
	response.sendRedirect("eat_cookie.jsp");
%>
