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
	String _id = request.getParameter("_id");
	
	MongoClient mongoClient = null;

	boolean result = false;
	try {
		mongoClient = new MongoClient("localhost", 27017);
		WriteConcern w = new WriteConcern(1, 2000);
		mongoClient.setWriteConcern(w);
		DB db = mongoClient.getDB("hello");
		DBCollection collection = db.getCollection("instrument");
		collection.remove(new BasicDBObject("_id",new ObjectId(_id)));
		
		result = true;
	} catch(Exception e) {
		e.printStackTrace();
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deletion!</title>
</head>
<body>
<script type="text/javascript">
<%	if (result) { %>
alert('삭제되었습니다.');
location.href='list.jsp';
<%	} else { %>
alert('삭제실패.');
location.href='javascript:history.back();';
<%	} %>
</script>
</body>
</html>