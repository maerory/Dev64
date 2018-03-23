<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
	int year = 0;
	int month = 0;
	
	Calendar cal = Calendar.getInstance();
	try {
		year = Integer.parseInt(request.getParameter("year"));
		month = Integer.parseInt(request.getParameter("month"));
	} catch (Exception e) {
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
	}

	cal.set(year,  month-1, 1);
	year = cal.get(Calendar.YEAR);
	month = cal.get(Calendar.MONTH) + 1;
	int week = cal.get(Calendar.DAY_OF_WEEK);
	int endday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YourCal</title>
<link rel="icon" type="image/png" href="img/triforce.png">
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(
function() {
	$('#plusmonth').click(function() {
		changemonth(1);
	})
	
	$('#minusmonth').click(function() {
		changemonth(-1);
	})
	$('#plusyear').click(function() {
		changemonth(12);
	})
	
	$('#minusyear').click(function() {
		changemonth(-12);
	})
})

function changemonth(month) {
	let f = document.myform;
	f.month.value = parseInt(f.month.value) + month;
	f.submit();
}

</script>
</head>
<body>
<form name="myform">
<input type="hidden" name="year"  value="<%=year %>"/>
<input type="hidden" name="month" value="<%=month %>" %>

<b>Your Calendar!</b> <br>

<table border="1" cellpadding="3">
<tr>
<caption>
<span style="cursor:pointer" id="minusyear"> ◀ </span>
<span style="cursor:pointer" id="minusmonth"> ◁ </span>
<%=year %> 년 <%=month %> 월
<span style="cursor:pointer" id="plusmonth"> ▷ </span>
<span style="cursor:pointer" id="plusyear"> ▶ </span>
<br></caption>
	<th>일</th>
	<th>월</th>
	<th>화</th>
	<th>수</th>
	<th>목</th>
	<th>금</th>
	<th>토</th>
</tr>
<tr>
<%	
	for(int d=1; d < week; d++) {
		out.print("<td></td>");
	}
	for (int d=1, w = week; d <=endday; d++, w++) {
		out.print("<td>" + d + "</td>");
		if (w%7 == 0) out.println("</tr><tr>");
	}
%>
</tr>
</table>
</form>
</body>
</html>