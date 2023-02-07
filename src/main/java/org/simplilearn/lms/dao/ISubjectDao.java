package org.simplilearn.lms.dao;

import java.util.List;

import org.simplilearn.lms.entities.Subject;

public interface ISubjectDao {
	void insert(Subject subject);
	List<Subject> getAll();
	Subject get(int sid);
	void delete(int sid);
	void update(Subject subject);
}
