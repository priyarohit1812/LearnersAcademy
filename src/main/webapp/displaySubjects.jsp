<%@page import="org.simplilearn.lms.entities.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Subject> subjects = (List<Subject>)request.getAttribute("subjects"); 
	%>
	<table border = "1">
		<tr>
			<td>Id</td>
			<td>Name </td>
			<td>Action</td>
		</tr>
		<%
			for(Subject subject:subjects)
			{
		%>
			<tr>
				<td><%=subject.getSid()%></td>
				<td><%=subject.getName()%></td>
				<%
					session.setAttribute("sid", subject.getSid());
				%>
				<td><a href="./teacher.jsp">Map to Teacher</a></td>
			</tr>
		<%	
			}
		%>	
	</table>
</body>
</html>