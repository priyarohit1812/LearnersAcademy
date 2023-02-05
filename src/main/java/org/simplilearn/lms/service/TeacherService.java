package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.dao.TeacherDao;
import org.simplilearn.lms.dao.TeacherDaoImpl;
import org.simplilearn.lms.entities.Teacher;

public class TeacherService implements ITeacherService {
	private TeacherDao dao = new TeacherDaoImpl();
	@Override
	public void saveTeacher(Teacher teacher) {
		if (teacher.getTid() > 0) {
			dao.update(teacher);
		} else {
			dao.insert(teacher);
		}
	}
	@Override
	public Teacher getTeacher(String name) {
		return dao.get(name);
	}
	@Override
	public List<Teacher> getAllTeachers() {
		return dao.getAll();
	}
	@Override
	public Teacher getTeacher(int tid) {
		return dao.get(tid);
	}

}
