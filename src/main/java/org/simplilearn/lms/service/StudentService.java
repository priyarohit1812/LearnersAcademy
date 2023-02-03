package org.simplilearn.lms.service;

import org.simplilearn.lms.dao.IStudent;
import org.simplilearn.lms.dao.StudentDao;
import org.simplilearn.lms.entities.Student;

public class StudentService implements IStudentService {
	private IStudent iStudent = new StudentDao();
	@Override
	public void addStudent(Student student) {
		iStudent.insert(student);
			
	}

}
