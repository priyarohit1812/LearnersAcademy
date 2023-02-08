package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.dao.AcademicClassDao;
import org.simplilearn.lms.dao.IAcademicClassDao;
import org.simplilearn.lms.entities.AcademicClass;

public class AcademicClassService implements IAcademicClassService {
	private IAcademicClassDao iAcademicClassDao = new AcademicClassDao();

	@Override
	public void saveAcademicClass(AcademicClass academicClass) {
		if (academicClass.getCid() > 0) {
			this.iAcademicClassDao.update(academicClass);
		} else {
			this.iAcademicClassDao.insert(academicClass);
		}
	}

	@Override
	public AcademicClass getAcademicClass(int cid) {
		return this.iAcademicClassDao.get(cid);
	}

	@Override
	public List<AcademicClass> getAllAcademicClasses() {
		return this.iAcademicClassDao.getAll();
	}

	@Override
	public void deleteAcademicClass(int cid) {
		this.iAcademicClassDao.delete(cid);		
	}

}