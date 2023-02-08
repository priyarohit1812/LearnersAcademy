<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.simplilearn.lms.entities.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Master</title>
</head>
<body>
	<%
	List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
	String visibility = "visible";
	if(teachers.isEmpty()){
		visibility = "hidden";
	}
	%>
	<a href="home.jsp">Back</a>
	<a href="teacherform?tid=0">Add Teachers</a>
	<table border="1" style="visibility: <%=visibility%>;">
		<tr>
			<td>Name</td>
			<td>Address</td>
			<td>Designation</td>
			<td>Skill</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>
		
		<%
		for (Teacher teacher : teachers) {
			%>
			<tr>
				<td><%=teacher.getName()%></td>
				<td><%=teacher.getAddress()%></td>
				<td><%=teacher.getDesignation()%></td>
				<td><%=teacher.getSkill()%></td>
				<td><a href="teacherform?tid=<%=teacher.getTid()%>">Update Teacher</a>			
				</td>
				<td>
				<form action="./teacher" method ="post">
					<input type="hidden" name="tid" value="<%= teacher.getTid()%>">				
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