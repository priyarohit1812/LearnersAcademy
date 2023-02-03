package org.simplilearn.lms.dao;

import java.util.List;

import org.simplilearn.lms.entities.AcademicClass;

public interface IAcademicClass {
	void insert(AcademicClass academicClass);
	List<AcademicClass> getAll();
	AcademicClass get(int cid);
	void delete(AcademicClass academicClass);
	void update(AcademicClass academicClass);
}
