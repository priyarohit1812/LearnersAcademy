package org.simplilearn.lms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.lms.entities.AcademicClass;
import org.simplilearn.lms.entities.ClassSubjectTeacher;
import org.simplilearn.lms.entities.Subject;
import org.simplilearn.lms.entities.Teacher;
import org.simplilearn.lms.service.AcademicClassService;
import org.simplilearn.lms.service.ClassSubjectTeacherService;
import org.simplilearn.lms.service.IAcademicClassService;
import org.simplilearn.lms.service.IClassSubjectTeacherService;
import org.simplilearn.lms.service.ISubjectService;
import org.simplilearn.lms.service.ITeacherService;
import org.simplilearn.lms.service.SubjectService;
import org.simplilearn.lms.service.TeacherService;
import org.simplilearn.lms.utils.Utilities;

@WebServlet("/classsubteachermap")
public class ClassSubjectTeacherMapController extends HttpServlet {
	private IAcademicClassService academicClassService = new AcademicClassService();
	private ISubjectService subjectService = new SubjectService();
	private ITeacherService teacherService = new TeacherService();
	private IClassSubjectTeacherService classSubjectTeacherService = new ClassSubjectTeacherService();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isDelete = Boolean.parseBoolean(req.getParameter("isDelete"));
		int cid = Integer.parseInt(req.getParameter("cid"));
		int cstid = Integer.parseInt(req.getParameter("cstid"));
		
		if (cstid > 0) {			
			classSubjectTeacherService.deleteMapping(cstid);
		}

		if (isDelete) {
			Utilities.ShowAlert(req, resp, "classsubteachermap.jsp",
					"Subject-Teacher mapping for Academic Class deleted successfully", "./classform?cid=" + cid);
		} else {
			int sid = Integer.parseInt(req.getParameter("sid"));
			int tid = Integer.parseInt(req.getParameter("tid"));
			AcademicClass academicClass = academicClassService.getAcademicClass(cid);
			Subject subject = subjectService.getSubject(sid);
			Teacher teacher = teacherService.getTeacher(tid);

			ClassSubjectTeacher classSubjectTeacher = new ClassSubjectTeacher();
			classSubjectTeacher.setAcademicClass(academicClass);
			classSubjectTeacher.setSubject(subject);
			classSubjectTeacher.setTeacher(teacher);

			classSubjectTeacherService.saveMapping(classSubjectTeacher);

			Utilities.ShowAlert(req, resp, "classsubteachermap.jsp",
					"Subject-Teacher mapping for Academic Class saved successfully", "./classform?cid=" + cid);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid = Integer.parseInt(req.getParameter("cid"));
		int sid = Integer.parseInt(req.getParameter("sid"));
		int tid = Integer.parseInt(req.getParameter("tid"));
		int cstid = Integer.parseInt(req.getParameter("cstid"));

		List<Subject> lstSubjects = subjectService.getAllSubjects();
		List<Teacher> lstTeacher = teacherService.getAllTeachers();
		List<Subject> filteredSubjects = new ArrayList<>();
		AcademicClass academicClass = academicClassService.getAcademicClass(cid);
		List<ClassSubjectTeacher> lstClassSubjectTeachers = new ArrayList<>(academicClass.getClassSubjectTeachers());

		if (lstClassSubjectTeachers.isEmpty()) {
			filteredSubjects = lstSubjects;
		} else {
			for (Subject subject : lstSubjects) {
				if (cstid > 0) {
					if (!lstClassSubjectTeachers.stream()
							.anyMatch(cst -> cst.getId() != cstid && cst.getSubject().getSid() == subject.getSid())) {
						filteredSubjects.add(subject);
					}
				} else {
					if (!lstClassSubjectTeachers.stream()
							.anyMatch(cst -> cst.getSubject().getSid() == subject.getSid())) {
						filteredSubjects.add(subject);
					}
				}

			}
		}

		req.setAttribute("subjects", filteredSubjects);
		req.setAttribute("teachers", lstTeacher);
		req.setAttribute("cid", cid);
		req.setAttribute("sid", sid);
		req.setAttribute("tid", tid);
		req.setAttribute("cstid", cstid);
		RequestDispatcher rd = req.getRequestDispatcher("classsubteachermap.jsp");
		rd.forward(req, resp);
	}
}
