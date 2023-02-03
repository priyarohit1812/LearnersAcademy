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
import org.simplilearn.lms.service.ISubjectService;
import org.simplilearn.lms.service.SubjectService;

@WebServlet("/displaySubjects")
public class DisplaySubjectsController extends HttpServlet {
	private ISubjectService iSubjectService = new SubjectService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Subject> subjects = iSubjectService.getSubjects();
		req.setAttribute("subjects", subjects);
		RequestDispatcher rd = req.getRequestDispatcher("displaySubjects.jsp");
		rd.forward(req, resp);
		
	}
	
}
