<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./addStudent" method =post>
		Name:<input type="text" name="name" required="required"><br>
		Address:<input type = "text" name="address" required="required"><br>
		Age:<input type="number" name="age" required="required"><br>
		<input type="submit" value="Add Student">
	</form>
</body>
</html>