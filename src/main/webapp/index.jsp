<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Learning Management System</h1>
	<form action="./login" method="post">
	Username<input type = "text" name = "username" required="required" ><br>
	Password<input type = "password" name = "password" required="required" ><br> 
	<input type="submit" value="submit">
	<a href="register.jsp">Register</a>
	</form>
	<p style="color: red;">${sessionScope.msg}</p>
</body>
</html>