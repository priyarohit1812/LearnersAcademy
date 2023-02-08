<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.simplilearn.lms.entities.AcademicClass"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Master</title>
</head>
<body>
	<%
	
	List<AcademicClass> classes = (List<AcademicClass>) request.getAttribute("classes");
	String visibility = "visible";
	if(classes.isEmpty()){
		visibility = "hidden";
	}
	%>
	<a href="home.jsp">Back</a>
	<a href="classform?cid=0">Add Class</a>
	<table border="1" style="visibility: <%=visibility%>;">
		<tr>
			<td>Name</td>
			<td>Duration</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>
		<%
		for (AcademicClass aclass : classes) {
		%>
		<tr>
			<td><%=aclass.getName()%></td>
			<td><%=aclass.getDuration()%></td>
			<td><a href="classform?cid=<%=aclass.getCid()%>">Update Class</a>			
			</td>
			<td>
			<form action="./class" method ="post">
				<input type="hidden" name="cid" value="<%= aclass.getCid()%>">				
				<input type="submit" value="Delete">
			</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>

	<p style="color: blue;">${requestScope.msg}</p>
</body>
</html>