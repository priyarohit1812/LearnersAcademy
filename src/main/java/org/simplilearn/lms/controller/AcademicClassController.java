package org.simplilearn.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.lms.entities.AcademicClass;
import org.simplilearn.lms.entities.ClassSubjectTeacher;
import org.simplilearn.lms.service.AcademicClassService;
import org.simplilearn.lms.service.ClassSubjectTeacherService;
import org.simplilearn.lms.service.IAcademicClassService;
import org.simplilearn.lms.service.IClassSubjectTeacherService;
import org.simplilearn.lms.utils.Utilities;

@WebServlet("/class")
public class AcademicClassController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAcademicClassService iAcademicClassService = new AcademicClassService();
	private IClassSubjectTeacherService classSubjectTeacherService = new ClassSubjectTeacherService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int cid = Integer.parseInt(req.getParameter("cid"));
		AcademicClass academicClass = iAcademicClassService.getAcademicClass(cid);
		if (academicClass.getClassSubjectTeachers() != null && !academicClass.getClassSubjectTeachers().isEmpty()) {
			for (ClassSubjectTeacher classSubjectTeacher : academicClass.getClassSubjectTeachers()) {
				classSubjectTeacherService.deleteMapping(classSubjectTeacher.getId());
			} 
		}
		iAcademicClassService.deleteAcademicClass(cid);
		Utilities.ShowAlert(req, resp, "class.jsp", "Academic Class deleted successfully", "./class");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AcademicClass> classes = iAcademicClassService.getAllAcademicClasses();
		req.setAttribute("classes", classes);
		RequestDispatcher rd = req.getRequestDispatcher("class.jsp");
		rd.forward(req, resp);
	}
}
