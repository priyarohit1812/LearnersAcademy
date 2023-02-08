package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.entities.AcademicClass;

public interface IAcademicClassService {
	void saveAcademicClass(AcademicClass academicClass); 
	void deleteAcademicClass(int cid); 
	AcademicClass getAcademicClass(int cid);
	List<AcademicClass> getAllAcademicClasses();
}
