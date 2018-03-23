<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String iam = "그래, 난 " + name + ". 포기를 모르는 남자지";
%>
<%=iam%>