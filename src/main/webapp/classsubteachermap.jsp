<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.simplilearn.lms.entities.Subject"%>
<%@page import="org.simplilearn.lms.entities.Teacher"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class : Subject Teacher Mapping</title>
</head>
<body>
	<%
	List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
	List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
	int cid = (int) request.getAttribute("cid");
	int sid = (int) request.getAttribute("sid");
	int tid = (int) request.getAttribute("tid");
	
	String subDisabled = "";
	if(sid > 0){
		subDisabled = "disabled";
	}
	%>
	<form action="./classsubteachermap" method="post">
		<input type="hidden" name="cid" value="<%=cid%>"> Subject
		Name: <select name="sid" required="required" <%=subDisabled%>>
			<option value=0></option>
			<%
			for (Subject subject : subjects) {
				int subID = subject.getSid();
				String selected = "";
				if (subID == sid) {
					selected = "selected";
				}
			%>
			<option value=<%=subject.getSid()%> <%=selected%>><%=subject.getName()%>
			</option>
			<%
			}
			%>
		</select><br> Teacher Name: <select name="tid" required="required">
			<option value=0></option>
			<%
			for (Teacher teacher : teachers) {
				int teachID = teacher.getTid();
				String selected = "";
				if (teachID == tid) {
					selected = "selected";
				}
			%>
			<option value=<%=teacher.getTid()%> <%=selected%>><%=teacher.getName()%>
			</option>
			<%
			}
			%>
		</select><br> <input type="submit" value="Save">
	</form>
</body>
</html>