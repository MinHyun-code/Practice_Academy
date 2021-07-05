<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<button onclick="location.href='http://localhost:8484/mvc02/board/content'">버튼</button>
		<button onclick="location.href='http://localhost:8484/mvc02/board/reply'">버튼</button>
</body>
</html>
