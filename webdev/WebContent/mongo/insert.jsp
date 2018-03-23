<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mongolian</title>
<script type="text/javascript">
window.onload = function() {
	document.getElementById('question_count').onchange = function() {
		let kv_count = document.getElementById('question_count').value;
		let kv_temp = '<table>';
		for(let cnt = 1; cnt <= kv_count; cnt++) {
			kv_temp += '<tr>';
			kv_temp += '<td><input type="text" name="key" placeholder="key"/></td>';
			kv_temp += '<td><input type="text" name="value" placeholder="value"/></td>';
			kv_temp += '</tr>';
		}
		kv_temp += '</table>'
		document.getElementById('kv').innerHTML = kv_temp;
	}
}

</script>
</head>
<body>
<form action="insert_action.jsp">
<select id="question_count">
	<c:forEach var="count" begin="1" end="10">
		<option>${count}</option>
	</c:forEach>
</select>
<table>
	<caption>데이터 입력 폼</caption>

<tr>
	<td><div id="kv">
		<table>
		<tr>
			<td><input type="text" name="key" placeholder="key"/></td>
			<td><input type="text" name="value" placeholder="value"/></td>
		</tr>
		</table>
		</div>
	</td>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="확인"/>
	</td>
</tr>
</table>
</form>
</body>
</html>