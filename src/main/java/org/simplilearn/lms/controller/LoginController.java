package org.simplilearn.lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simplilearn.lms.entities.User;
import org.simplilearn.lms.service.IUserService;
import org.simplilearn.lms.service.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserService iUserService = new UserService();  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = iUserService.get(username, password);
		if(user!=null && user.getUserType().equals("admin"))
		{
			session.setAttribute("user", user);
			resp.sendRedirect("home.jsp");
					
		}
		else {
			session.setAttribute("msg", "username/password is invalid");
			resp.sendRedirect("./");
		}
		
	}
}
