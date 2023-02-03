package org.simplilearn.lms.service;

import org.simplilearn.lms.dao.TeacherDao;
import org.simplilearn.lms.dao.TeacherDaoImpl;
import org.simplilearn.lms.entities.Teacher;

public class TeacherService implements ITeacherService {
	private TeacherDao dao = new TeacherDaoImpl();
	@Override
	public void addTeacher(Teacher teacher) {
		dao.insert(teacher);
		
	}
	@Override
	public Teacher getTeacher(String name) {
		return dao.get(name);
	}

}
