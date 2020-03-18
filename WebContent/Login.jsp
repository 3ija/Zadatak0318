<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./Login" method="POST">
		
		Username: <input type="text" name="username" value="">
		<br>
		<br>
		Password: <input type="text" name="password" value="">
		<br>
		<br>
		<input type="submit" value="Prijavi se">
		<br>
		<br>
		<c:out value="${err}" ></c:out>
	</form>
</body>
</body>
</html>