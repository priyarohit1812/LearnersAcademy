package org.simplilearn.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.lms.entities.AcademicClass;
import org.simplilearn.lms.service.AcademicClassService;
import org.simplilearn.lms.service.IAcademicClassService;
import org.simplilearn.lms.utils.Utilities;
@WebServlet("/classform")
public class ClassFormController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAcademicClassService iAcademicClassService = new AcademicClassService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		int duration =Integer.parseInt(req.getParameter("duration"));
		int cid =Integer.parseInt(req.getParameter("cid"));
		
		AcademicClass academicClass = new AcademicClass();
		academicClass.setCid(cid);
		academicClass.setName(name);
		academicClass.setDuration(duration);
		iAcademicClassService.saveAcademicClass(academicClass);
		
		Utilities.ShowAlert(req, resp, "classform.jsp", "Academic Class saved successfully", "./class");	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid =Integer.parseInt(req.getParameter("cid"));
		AcademicClass academicClass = null;
		if (cid > 0) {
			academicClass = iAcademicClassService.getAcademicClass(cid);
		}
		req.setAttribute("class", academicClass);
		RequestDispatcher rd = req.getRequestDispatcher("classform.jsp");
		rd.forward(req, resp);
	}
}
