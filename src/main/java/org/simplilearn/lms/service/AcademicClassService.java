package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.dao.AcademicClassDao;
import org.simplilearn.lms.dao.IAcademicClassDao;
import org.simplilearn.lms.entities.AcademicClass;

public class AcademicClassService implements IAcademicClassService {
	private IAcademicClassDao iAcademicClassDao = new AcademicClassDao();

	@Override
	public void save(AcademicClass academicClass) {
		if (academicClass.getCid() > 0) {
			this.iAcademicClassDao.update(academicClass);
		} else {
			this.iAcademicClassDao.insert(academicClass);
		}
	}

	@Override
	public AcademicClass get(int cid) {
		return this.iAcademicClassDao.get(cid);
	}

	@Override
	public List<AcademicClass> getAll() {
		return this.iAcademicClassDao.getAll();
	}

	@Override
	public void delete(int cid) {
		this.iAcademicClassDao.delete(cid);		
	}

}