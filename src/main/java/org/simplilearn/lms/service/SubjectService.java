package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.dao.ISubjectDao;
import org.simplilearn.lms.dao.SubjectDao;
import org.simplilearn.lms.entities.Subject;

public class SubjectService implements ISubjectService {
	private ISubjectDao iSubjectDao = new SubjectDao();
	@Override
	public void saveSubject(Subject subject) {
		if (subject.getSid() > 0) {
			this.iSubjectDao.update(subject);
		} else {
			this.iSubjectDao.insert(subject);
		}
		
	}
	@Override
	public List<Subject> getAllSubjects() {
		return this.iSubjectDao.getAll();
	}
	@Override
	public Subject getSubject(int sid) {
		return this.iSubjectDao.get(sid);
	}
	@Override
	public void deleteSubject(int sid) {
		this.iSubjectDao.delete(sid);
	}

}
