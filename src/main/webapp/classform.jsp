<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.simplilearn.lms.entities.AcademicClass"%>
<%@page import="org.simplilearn.lms.entities.ClassSubjectTeacher"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Form</title>
</head>
<body>
	<%
	AcademicClass aClass = (AcademicClass) request.getAttribute("class");
	String action = "./classform";
	String visibility = "visible";
	String mapVisibility = "visible";
	if (aClass == null) {
		Set<ClassSubjectTeacher> emptySet = new HashSet<>();
		aClass = new AcademicClass();
		aClass.setName("");
		aClass.setClassSubjectTeachers(emptySet);		
		action = action.trim() + "?cid=0";
		mapVisibility = "hidden";
	} else {
		action = action.trim() + "?cid=" + aClass.getCid();		
	}
	Set<ClassSubjectTeacher> subTeachers = aClass.getClassSubjectTeachers();
	if (subTeachers.isEmpty()) {
		visibility = "hidden";
	}
	List<ClassSubjectTeacher> lstClassSubjectTeachers = new ArrayList<ClassSubjectTeacher>(subTeachers);
	%>
	<form action="<%=action%>" method=post>
		Name:<input type="text" name="name" required="required"
			value="<%=aClass.getName()%>"><br> Duration in Months:<input
			type="number" name="duration" required="required"
			value="<%=aClass.getDuration()%>"><br> <input
			type="submit" value="Save">
	</form>
	<br>
	<br>
	<a href="home.jsp">Back</a>
	<a href="classsubteachermap?cid=<%=aClass.getCid()%>&sid=0&tid=0" style="visibility: <%=mapVisibility%>;">Add
		Subject Teacher Mapping</a>
	<table border="1" style="visibility: <%=visibility%>;">
		<tr>
			<td>Subject</td>
			<td>Teacher</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>
		<%
		for(ClassSubjectTeacher subTeacher : lstClassSubjectTeachers)
		{
		%>
		<tr>
			<td><%=subTeacher.getSubject().getName()%></td>
			<td><%=subTeacher.getTeacher().getName()%></td>
			<td><a
				href="classsubteachermap?cid=<%=subTeacher.getAcademicClass().getCid()%>&sid=<%=subTeacher.getSubject().getSid()%>&tid=<%=subTeacher.getTeacher().getTid()%>">Update
					Mapping</a></td>
			<td>
				<form action="./deleteclasssubteachermap" method="post">
					<input type="hidden" name="cid"
						value="<%=subTeacher.getAcademicClass().getCid()%>"> <input
						type="hidden" name="sid"
						value="<%=subTeacher.getSubject().getSid()%>"> <input
						type="hidden" name="tid"
						value="<%=subTeacher.getTeacher().getTid()%>"> <input
						type="submit" value="Delete">
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>