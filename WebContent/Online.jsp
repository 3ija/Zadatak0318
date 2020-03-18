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
	Active Users:
		<table border=1>
		<tr>
		<th>Username</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.username}" /></td>
			<tr>
		</c:forEach>
		</table>
		<p>
			<a href="./Index">Index</a>
		</p>
	</c:if>
</body>
</html>