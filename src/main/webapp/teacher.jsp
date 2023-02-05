<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.simplilearn.lms.entities.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
	int sid = (int) Integer.parseInt(request.getParameter("sid"));
	%>
	<form action="./mapToTeacher?sid=<%=sid%>" method="post">
		Name:<select name="tid" required="required">
		<option value=null></option>
		<%
		for (Teacher teacher : teachers) {
		%>
			<option value=<%= teacher.getTid() %>><%= teacher.getName() %> </option>
			<%
		}
		%>
		</select> <br> <input type="submit" value="Map">

	</form>

</body>
</html>