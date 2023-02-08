package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.dao.ITeacherDao;
import org.simplilearn.lms.dao.TeacherDao;
import org.simplilearn.lms.entities.Teacher;

public class TeacherService implements ITeacherService {
	private ITeacherDao iTeacherDao = new TeacherDao();
	@Override
	public void saveTeacher(Teacher teacher) {
		if (teacher.getTid() > 0) {
			this.iTeacherDao.update(teacher);
		} else {
			this.iTeacherDao.insert(teacher);
		}
	}
	@Override
	public Teacher getTeacher(String name) {
		return this.iTeacherDao.get(name);
	}
	@Override
	public List<Teacher> getAllTeachers() {
		return this.iTeacherDao.getAll();
	}
	@Override
	public Teacher getTeacher(int tid) {
		return this.iTeacherDao.get(tid);
	}
	@Override
	public void deleteTeacher(int tid) {
		this.iTeacherDao.delete(tid);
		
	}

}
