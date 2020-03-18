<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${login == true}">
<form action="./Add" method="POST">
		
		Username: <input type="text" name="username" value="">
		<br>
		<br>
		Password: <input type="text" name="password" value="">
		<br>
		<br>
		Firstname: <input type="text" name="firstname" value="">
		<br>
		<br>
		Lastname: <input type="text" name="lastname" value="">
		<br>
		<br> 
		<input type="submit" value="Dodaj user">
		<br>
		<br>
		<c:out value="${err}" ></c:out>
	</form>
	<p><a href="./Index">Index</a></p>
</c:if>
</body>
</html>