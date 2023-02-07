package org.simplilearn.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.lms.entities.Subject;
import org.simplilearn.lms.entities.Teacher;
import org.simplilearn.lms.service.ISubjectService;
import org.simplilearn.lms.service.ITeacherService;
import org.simplilearn.lms.service.SubjectService;
import org.simplilearn.lms.service.TeacherService;

@WebServlet("/classsubteachermap")
public class ClassSubjectTeacherMapController extends HttpServlet {
	private ISubjectService subjectService = new SubjectService();
	private ITeacherService teacherService = new TeacherService();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid =Integer.parseInt(req.getParameter("cid"));
		int sid =Integer.parseInt(req.getParameter("sid"));	
		int tid =Integer.parseInt(req.getParameter("tid"));	
		
		List<Subject> lstSubjects = subjectService.getAllSubjects();
		List<Teacher> lstTeacher = teacherService.getAllTeachers();
		
		
		req.setAttribute("subjects", lstSubjects);
		req.setAttribute("teachers", lstTeacher);
		req.setAttribute("cid", cid);
		req.setAttribute("sid", sid);
		req.setAttribute("tid", tid);
		RequestDispatcher rd = req.getRequestDispatcher("classsubteachermap.jsp");
		rd.forward(req, resp);
	}
}
