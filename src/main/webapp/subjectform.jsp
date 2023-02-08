<%@page import="org.simplilearn.lms.entities.Subject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject Form</title>
</head>
<body>
	<%
	Subject subject = (Subject) request.getAttribute("subject");
	String action = "./subjectform";
	if (subject == null) {
		subject = new Subject();
		subject.setName("");
		action = action.trim() + "?sid=0";
	} else {
		action = action.trim() + "?sid=" + subject.getSid();
	}
	%>
	<a href="./subject">Back</a>
	<form action="<%=action%>" method="post">
		Subject Name <input type="text" name="name" required="required"
			value="<%=subject.getName()%>"><br> <input type="submit"
			name="Save">
	</form>
</body>
</html>