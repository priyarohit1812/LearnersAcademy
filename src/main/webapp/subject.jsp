<%@page import="org.simplilearn.lms.entities.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject Master</title>
</head>
<body>
	<%
	List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
	String visibility = "visible";
	if(subjects.isEmpty()){
		visibility = "hidden";
	}
	%>
	<a href="home.jsp">Back</a>
	<a href="subjectform?sid=0">Add Subjects</a>
	<table border="1" style="visibility: <%=visibility%>;">
		<tr>
			<td>Name</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>
		<%
		for (Subject asubject : subjects ) {
		%>
		<tr>
			<td><%=asubject.getName()%></td>
			<td><a href="subjectform?sid=<%=asubject.getSid()%>">Update Subject</a>			
			</td>
			<td>
			<form action="./subject" method ="post">
				<input type="hidden" name="sid" value="<%= asubject.getSid()%>">				
				<input type="submit" value="Delete">
			</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>	
</body>
</html>