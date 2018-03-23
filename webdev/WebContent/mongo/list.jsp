<%@page import="java.util.*"%>
<%@page import="com.mongodb.DBCursor"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.WriteConcern"%>
<%@page import="com.mongodb.MongoClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MongoClient mongoClient = null;
	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	
	boolean result = false;
	try {
		mongoClient = new MongoClient("localhost", 27017);
		WriteConcern w = new WriteConcern(1, 2000);
		mongoClient.setWriteConcern(w);
		DB db = mongoClient.getDB("hello");
		DBCollection collection = db.getCollection("instrument");
		
		DBCursor cursor = collection.find();
		while(cursor.hasNext()) {
			cursor.next();
			Map<String,Object> doc = new HashMap<String,Object>();
			
			for (String key : cursor.curr().keySet()) {
				doc.put(key, cursor.curr().get(key));
			}
			list.add(doc);
		}
		
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Store</title>
</head>
<body>

<% for(Map<String, Object> doc : list) { %>
<table border='1'>
<%		for(String key : doc.keySet()) { %>
<%			if (!key.equals("_id")) { %>
	<tr>
		<th><%= key %></th>
		<td><%= doc.get(key) %></td>
	</tr>
<% 		} %>
<% } %>
	<tr>
		<td><a href="update.jsp?_id=<%=doc.get("_id")%>">수정</a></td>
		<td><a href="delete.jsp?_id=<%=doc.get("_id")%>">삭제</a></td>
	</tr>
</table>
<% } %>
</body>
</html>