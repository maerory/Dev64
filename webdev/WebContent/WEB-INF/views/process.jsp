<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rest</title>
<style type="text/css">
body {
	margin: 0;
}

.whoami {
	position: absolute
	z-index: 0;
}

#iam {
	position: absolute;
	top : 150px;
	left: 300px;
	z-index: 99;
	font-size: 1.8em;
	font-weight: bold;
	width: 100px;
}

</style>
<link rel="shortcut icon" href="/favicon.png"/>
</head>
<body>
<img src="img/aquinas.png" class="whoami"/>
<div id="iam">${iam}</div>
</body>
</html>