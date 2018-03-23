<%@page import="java.util.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String term = request.getParameter("term");
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	StringBuffer sql = new StringBuffer();
	sql.append(" SELECT word ");
	sql.append(" FROM t_keywords ");
	sql.append(" WHERE word like '%' || ? || '%' ");
	sql.append(" ORDER BY word asc");
	
	List<String> words = new ArrayList<>();
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","n1","n1");
		ps = conn.prepareStatement(sql.toString());
		ps.setString(1, term);
		rs = ps.executeQuery();
		while (rs.next()) {
			words.add(rs.getString("word"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rs != null) try{rs.close();} catch (Exception e){}
		if (ps != null) try{rs.close();} catch (Exception e){}
		if (conn != null) try{rs.close();} catch (Exception e){}
	}
%>

[
<% for(int i=0; i < words.size(); i++) { %>
<% if(i==0) { %>
	"<%=words.get(i)%>"
<% } else { %>
	,"<%=words.get(i)%>"
<% }
}%>
]

