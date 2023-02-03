package org.simplilearn.lms.dao;

import java.util.List;

import org.simplilearn.lms.entities.Subject;

public interface ISubject {
	void insert(Subject subject);
	List<Subject> getAll();
	Subject get(int sid);
	void delete(Subject subject);
	void update(Subject subject);
}
