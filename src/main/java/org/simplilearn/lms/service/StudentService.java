package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.dao.IStudentDao;
import org.simplilearn.lms.dao.StudentDao;
import org.simplilearn.lms.entities.Student;

public class StudentService implements IStudentService {
	private IStudentDao iStudentDao = new StudentDao();
		
	@Override
	public void saveStudent(Student student) {
		if (student.getstuId() > 0) {
			this.iStudentDao.update(student);
		} else {
			this.iStudentDao.insert(student);
		}
		
	}
	
	@Override
	public List<Student> getAllStudents() {
		return this.iStudentDao.getAll();
	}
	@Override
	public Student getStudent(int stuId) {
		return this.iStudentDao.getStudent(stuId);
	}
	@Override
	public void deleteStudent(int stuId) {
	    this.iStudentDao.deleteStudent(stuId);
		
	}

}
