package org.simplilearn.lms.dao;

import java.util.List;

import org.simplilearn.lms.entities.AcademicClass;

public interface IAcademicClassDao {
	void insert(AcademicClass academicClass);
	List<AcademicClass> getAll();
	AcademicClass get(int cid);
	void delete(int cid);
	void update(AcademicClass academicClass);
}
