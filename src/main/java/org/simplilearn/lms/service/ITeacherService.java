package org.simplilearn.lms.service;

import org.simplilearn.lms.entities.Teacher;

public interface ITeacherService {
	void addTeacher(Teacher teacher);
	Teacher getTeacher(String name);
}
