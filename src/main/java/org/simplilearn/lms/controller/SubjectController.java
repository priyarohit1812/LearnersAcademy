package org.simplilearn.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.lms.entities.ClassSubjectTeacher;
import org.simplilearn.lms.entities.Subject;
import org.simplilearn.lms.service.ClassSubjectTeacherService;
import org.simplilearn.lms.service.IClassSubjectTeacherService;
import org.simplilearn.lms.service.ISubjectService;
import org.simplilearn.lms.service.SubjectService;
import org.simplilearn.lms.utils.Utilities;

@WebServlet("/subject")
public class SubjectController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  ISubjectService iSubjectService = new SubjectService();
	private IClassSubjectTeacherService classSubjectTeacherService = new ClassSubjectTeacherService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int sid =Integer.parseInt(req.getParameter("sid"));
		Subject subject = iSubjectService.getSubject(sid);
		if (subject.getClassSubjectTeachers() != null && !subject.getClassSubjectTeachers().isEmpty()) {
			for (ClassSubjectTeacher classSubjectTeacher : subject.getClassSubjectTeachers()) {
				classSubjectTeacherService.deleteMapping(classSubjectTeacher.getId());
			} 
		}
		iSubjectService.deleteSubject(sid);		
		Utilities.ShowAlert(req, resp, "subject.jsp", "Subject deleted successfully", "./subject");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Subject> subjects = iSubjectService.getAllSubjects();
		req.setAttribute("subjects", subjects);
		RequestDispatcher rd = req.getRequestDispatcher("subject.jsp");
		rd.forward(req, resp);
		
	}
}
