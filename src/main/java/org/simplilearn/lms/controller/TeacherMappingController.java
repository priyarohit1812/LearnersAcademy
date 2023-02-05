package org.simplilearn.lms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.lms.dao.ISubject;
import org.simplilearn.lms.dao.SubjectDao;
import org.simplilearn.lms.entities.Subject;
import org.simplilearn.lms.entities.Teacher;
import org.simplilearn.lms.service.ITeacherService;
import org.simplilearn.lms.service.TeacherService;

@WebServlet("/mapToTeacher")
public class TeacherMappingController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ITeacherService iTeacherService = new TeacherService();
	private ISubject iSubject = new SubjectDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int tid = Integer.parseInt(req.getParameter("tid"));
		int sid = (int) Integer.parseInt(req.getParameter("sid"));
//		HttpSession session = req.getSession();
//		int sid = (int) session.getAttribute("sid");
		Teacher teacher = iTeacherService.getTeacher(tid);
		Subject subject = iSubject.get(sid);
		teacher.addSubject(subject);
		subject.addTeacher(teacher);
		iTeacherService.saveTeacher(teacher);
		
		// Redirect to displaySubjects.jsp with success message
		List<Subject> subjects = iSubject.getAll();
		req.setAttribute("subjects", subjects);
		req.setAttribute("msg", "Teacher Subject mapping done Successfully");
		RequestDispatcher rd = req.getRequestDispatcher("displaySubjects.jsp");		
		rd.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sid = (int) Integer.parseInt(req.getParameter("sid"));
		Subject subject = iSubject.get(sid);
		List<Teacher> teachers = iTeacherService.getAllTeachers();
		Set<Teacher> subjectTeacher = subject.getTeachers();
		if (subjectTeacher.isEmpty()) {
			req.setAttribute("teachers", teachers);
		} else {
			List<Teacher> filteredTeachers = new ArrayList<>();
			for (Teacher teacher : teachers) {
				if (!subjectTeacher.stream().anyMatch(st -> st.getTid() == teacher.getTid())) {
					filteredTeachers.add(teacher);
				}
			}
			req.setAttribute("teachers", filteredTeachers);
		}

		RequestDispatcher rd = req.getRequestDispatcher("teacher.jsp");
		rd.forward(req, resp);
	}
}
