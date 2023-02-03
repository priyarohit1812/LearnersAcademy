package org.simplilearn.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simplilearn.lms.entities.Student;
import org.simplilearn.lms.service.IStudentService;
import org.simplilearn.lms.service.StudentService;

@WebServlet("/addStudent")
public class StudentController extends HttpServlet {
	private IStudentService iStudentService = new StudentService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		int age =Integer.parseInt(req.getParameter("age"));		
		Student student =new Student();
		student.setName(name);
		student.setAddress(address);
		student.setAge(age);
		iStudentService.addStudent(student);
		req.setAttribute("msg", "Student added Successfully");
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
		
		
	}

}
