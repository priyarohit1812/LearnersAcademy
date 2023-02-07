package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.entities.Subject;

public interface ISubjectService {
	void saveSubject(Subject subject);
	List<Subject> getAllSubjects(); 
	Subject getSubject(int sid); 
	void deleteSubject(int sid);
}
