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

@WebServlet("/subjectform")
public class SubjectFormController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ISubjectService iSubjectService = new SubjectService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int sid =Integer.parseInt(req.getParameter("sid"));
		
		Subject subject = new Subject();
		subject.setSid(sid);
		subject.setName(name);
		iSubjectService.saveSubject(subject);
		resp.sendRedirect("./subject");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		Subject subject = null;		
		if (sid>0) {
			subject = iSubjectService.getSubject(sid);
		}
		req.setAttribute("subject", subject);
		RequestDispatcher rd = req.getRequestDispatcher("subjectform.jsp");
		rd.forward(req, resp);
	}

}
