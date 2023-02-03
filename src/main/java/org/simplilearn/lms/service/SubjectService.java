package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.dao.ISubject;
import org.simplilearn.lms.dao.SubjectDao;
import org.simplilearn.lms.entities.Subject;

public class SubjectService implements ISubjectService {
	private ISubject iSubject = new SubjectDao();
	@Override
	public void addSubject(Subject subject) {
		iSubject.insert(subject);
		
	}
	@Override
	public List<Subject> getSubjects() {
		return iSubject.getAll();
	}

}
