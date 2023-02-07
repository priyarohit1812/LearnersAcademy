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
import org.simplilearn.lms.service.AcademicClassService;
import org.simplilearn.lms.service.IAcademicClassService;
@WebServlet("/class")
public class AcademicClassController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAcademicClassService iAcademicClassService = new AcademicClassService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cid =Integer.parseInt(req.getParameter("cid"));		
		iAcademicClassService.delete(cid);
		req.setAttribute("msg", "Academic Class deleted successfully");
		List<AcademicClass> classes = iAcademicClassService.getAll();
		req.setAttribute("classes", classes);
		RequestDispatcher rd = req.getRequestDispatcher("class.jsp");
		rd.forward(req, resp);
 		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AcademicClass> classes = iAcademicClassService.getAll();
		req.setAttribute("classes", classes);
		RequestDispatcher rd = req.getRequestDispatcher("class.jsp");
		rd.forward(req, resp);
	}
}
