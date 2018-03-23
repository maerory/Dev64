<%@page import="org.bson.types.ObjectId"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.WriteConcern"%>
<%@page import="com.mongodb.MongoClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] keys = request.getParameterValues("key");
	String[] values = request.getParameterValues("value");

	MongoClient mongoClient = null;

	boolean result = false;
	try {
		mongoClient = new MongoClient("localhost", 27017);
		WriteConcern w = new WriteConcern(1, 2000);
		mongoClient.setWriteConcern(w);
		DB db = mongoClient.getDB("hello");
		DBCollection collection = db.getCollection("instrument");
		DBObject doc = new BasicDBObject();
		for(int i=0; i < keys.length; i++) {
			doc.put(keys[i], values[i]);
		}
		
		DBObject original = collection.findOne(new ObjectId((String)doc.get("_id")));
		doc.removeField("_id");
		DBObject set = new BasicDBObject("$set", doc);
		collection.update(original, set);
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
<script type="text/javascript">
<%	if (result) { %>
alert('수정되었습니다.');
location.href='list.jsp';
<%	} else { %>
alert('수정실패');
location.href='javascript:history.back();';
<%	} %>
</script>
</body>
</html>