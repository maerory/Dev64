<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.WriteConcern"%>
<%@page import="com.mongodb.MongoClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MongoClient mongoClient = null;

	boolean result = false;
	try {
		mongoClient = new MongoClient("localhost", 27017);
		WriteConcern w = new WriteConcern(1, 2000);
		mongoClient.setWriteConcern(w);
		DB db = mongoClient.getDB("hello");
		DBCollection collection = db.getCollection("instrument");
		DBObject doc = new BasicDBObject();
		doc.put("name", "cubase");
		doc.put("price", 350000);
		collection.insert(doc);
		result = true;
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	if (result) { %>
입력되었습니다.
<%	} else { %>
입력실패
<%	} %>
</body>
</html>