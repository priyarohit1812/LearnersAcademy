<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./addTeacher" method =post>
	Name:<input type="text" name="name" required="required"><br>
	Address:<input type = "text" name="address" required="required"><br>
	Designation:<input type="text" name="designation" required="required"><br>
	Skill:<input type="text" name="skill" required="required"><br>
	<input type="submit" value="Add Teacher">
	</form>
</body>
</html>