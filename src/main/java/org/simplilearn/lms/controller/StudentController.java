package org.simplilearn.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.lms.entities.Student;
import org.simplilearn.lms.service.IStudentService;
import org.simplilearn.lms.service.StudentService;
import org.simplilearn.lms.utils.Utilities;

@WebServlet("/student")
public class StudentController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IStudentService iStudentService = new StudentService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int stuId =Integer.parseInt(req.getParameter("stuId"));		
		iStudentService.deleteStudent(stuId);		
		Utilities.ShowAlert(req, resp, "student.jsp", "Student deleted successfully", "./student");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> students = iStudentService.getAllStudents();
		req.setAttribute("students", students);
		RequestDispatcher rd = req.getRequestDispatcher("student.jsp");
		rd.forward(req, resp);
	}
}
