package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.entities.Student;

public interface IStudentService {
	void saveStudent(Student student);
	List<Student> getAllStudents(); 
	Student getStudent(int stuId); 
	void deleteStudent(int stuId);
	
}
