package org.simplilearn.lms.service;

import java.util.List;

import org.simplilearn.lms.entities.AcademicClass;

public interface IAcademicClassService {
	void save(AcademicClass academicClass); 
	void delete(int cid); 
	AcademicClass get(int cid);
	List<AcademicClass> getAll();
}
