package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.entities.Teacher;

public interface ITeacherService {
	void saveTeacher(Teacher teacher);
	Teacher getTeacher(String name);
	Teacher getTeacher(int tid);
	List<Teacher> getAllTeachers();
	void deleteTeacher(int tid);
}
