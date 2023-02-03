package org.simplilearn.lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simplilearn.lms.dao.ISubject;
import org.simplilearn.lms.dao.SubjectDao;
import org.simplilearn.lms.entities.Subject;
import org.simplilearn.lms.entities.Teacher;
import org.simplilearn.lms.service.ITeacherService;
import org.simplilearn.lms.service.TeacherService;

@WebServlet("/mapToTeacher")
public class TeacherMappingController extends HttpServlet {
	private ITeacherService iTeacherService = new TeacherService();
	private ISubject iSubject = new SubjectDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("name");
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("sid");
		Teacher teacher = iTeacherService.getTeacher(name);
		Subject subject = iSubject.get(id);
		teacher.addSubject(subject);
		subject.setTeacher(teacher);
		iTeacherService.addTeacher(teacher);
		
	}
}
