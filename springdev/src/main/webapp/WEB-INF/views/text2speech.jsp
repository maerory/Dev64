<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#myaudio').hide();
	
	$('#myaudio').on('loadeddata',function(){
		$('#myaudio').show();
	});
	
	$('#speak').click(function(){
		$('#myaudio').stop();
		$('#myaudio').attr('src','speak?&' + $('#myform').serialize());
		$('#myaudio').attr('autoplay','autoplay');
		return;
	});
});
</script>
</head>
<body>
text2 speech
<form id="myform" method="post">
<div>
	<div><h3>메시지를 입력 후 음성을 선택하세요~!!!</h3></div>
	<div>
		<textarea rows="7" cols="50" name="statement"></textarea><br/>
	</div>
	<div>
		<select name="voice">
		<c:forEach items="${voiceLists}" var="currentVoice">
			<option value="${currentVoice[1]}">${currentVoice[0]}</option>
		</c:forEach>
		</select>
	</div>
	<div>
		<input type="button" id="speak" value="읽기" />
	</div>
	<div>
		<audio id="myaudio" controls="controls" preload="auto">
		</audio>	
	</div>	
</div>
</form>
</body>
</html>