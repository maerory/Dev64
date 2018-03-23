<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="org.bson.types.ObjectId"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.WriteConcern"%>
<%@page import="com.mongodb.MongoClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String _id = request.getParameter("_id");
	
	MongoClient mongoClient = null;
	DBObject doc = null;
	boolean result = false;
	try {
		mongoClient = new MongoClient("localhost", 27017);
		WriteConcern w = new WriteConcern(1, 2000);
		mongoClient.setWriteConcern(w);
		DB db = mongoClient.getDB("hello");
		DBCollection collection = db.getCollection("instrument");
		doc = collection.findOne(new ObjectId(_id));
%>		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update_action.jsp">
<table>
	<caption>데이터 수정 폼</caption>
<tr>
	<td><div id="kv">
<%		for(String key : doc.keySet()) { %>	
<%			if(key.equals("_id")) { %>
		<table>
		<tr>
			<td><input type="hidden" name="key" 
			placeholder="key" required="required" value="<%=key %>" /></td>
			<td><input type="hidden" name="value" value="<%=doc.get(key) %>" 
			placeholder="value"  required="required" /></td>
		</tr>
		</table>
<%			} else { %>
		<table>
		<tr>
			<td><input type="text" name="key" 
			placeholder="key" required="required" value="<%=key %>" /></td>
			<td><input type="text" name="value" value="<%=doc.get(key) %>" 
			placeholder="value"  required="required" /></td>
		</tr>
		</table>
<%			}
		} %>
		</div>
<%		result = true;
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
	</td>
<tr>
	<td align="center">
		<input type="submit" value="확인" />
	</td>
</tr>
</table>
</form>
</body>
</html>