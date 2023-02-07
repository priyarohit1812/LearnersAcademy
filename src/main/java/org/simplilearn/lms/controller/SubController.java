package org.simplilearn.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.lms.entities.Subject;
import org.simplilearn.lms.service.ISubjectService;
import org.simplilearn.lms.service.SubjectService;

@WebServlet("/addSub")
public class SubController extends HttpServlet {
	private ISubjectService iSubjectService = new SubjectService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subject = req.getParameter("subject");
		Subject subject2 = new Subject();
		subject2.setName(subject);
		iSubjectService.saveSubject(subject2); 
		req.setAttribute("msg", "Subject added Successfully");
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
}
