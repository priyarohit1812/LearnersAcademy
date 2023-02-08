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
import org.simplilearn.lms.entities.Teacher;
import org.simplilearn.lms.service.ClassSubjectTeacherService;
import org.simplilearn.lms.service.IClassSubjectTeacherService;
import org.simplilearn.lms.service.ITeacherService;
import org.simplilearn.lms.service.TeacherService;
import org.simplilearn.lms.utils.Utilities;

@WebServlet("/teacher")
public class TeacherController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ITeacherService iTeacherService = new TeacherService();
	private IClassSubjectTeacherService classSubjectTeacherService = new ClassSubjectTeacherService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		int tid =Integer.parseInt(req.getParameter("tid"));
		Teacher teacher = iTeacherService.getTeacher(tid);
		if (teacher.getClassSubjectTeachers() != null && !teacher.getClassSubjectTeachers().isEmpty()) {
			for (ClassSubjectTeacher classSubjectTeacher : teacher.getClassSubjectTeachers()) {
				classSubjectTeacherService.deleteMapping(classSubjectTeacher.getId());
			} 
		}
		iTeacherService.deleteTeacher(tid);		
		Utilities.ShowAlert(req, resp, "teacher.jsp", "Teacher deleted successfully", "./teacher");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Teacher> teachers = iTeacherService.getAllTeachers();
		req.setAttribute("teachers", teachers);
		RequestDispatcher rd = req.getRequestDispatcher("teacher.jsp");
		rd.forward(req, resp);
	}
}
