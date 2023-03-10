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

@WebServlet("/register") 
public class UserController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String userType = req.getParameter("userType");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setUserType(userType);
		userService.insert(user);
		
		session.setAttribute("msg", "User registered Successfully");
		resp.sendRedirect("./");
//		req.setAttribute("msg", "User registered Successfully");
//		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//		rd.forward(req, resp);
				
	}
}
