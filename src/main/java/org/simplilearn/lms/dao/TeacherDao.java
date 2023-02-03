	package org.simplilearn.lms.dao;

import java.util.List;

import org.simplilearn.lms.entities.Teacher;

public interface TeacherDao {
	void insert(Teacher teacher);
	List<Teacher> getAll();
	Teacher get(String name);
	Teacher get(int tid);
	void delete(Teacher teacher);
	void update(Teacher teacher);
	
}
