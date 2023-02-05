<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Hi ${sessionScope.user.username}, Welcome to learning Management System</h4>
	<a href= "addSubject.jsp">Add subject</a>
	<a href= "addTeacher.jsp">Add Teacher</a>
	<a href= "addClass.jsp">Add class</a>
	<a href= "addStudent.jsp">Add student</a>
	<a href = "./displaySubjects">Display Subjects</a>
	<p style="color: blue;">${requestScope.msg}</p>
</body>
</html>