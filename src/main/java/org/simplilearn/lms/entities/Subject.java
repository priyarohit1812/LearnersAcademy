package org.simplilearn.lms.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	
	@OneToMany(mappedBy = "subject", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClassSubjectTeacher> classSubjectTeachers;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<ClassSubjectTeacher> getClassSubjectTeachers() {
		return classSubjectTeachers;
	}

	public void setClassSubjectTeachers(Set<ClassSubjectTeacher> classSubjectTeachers) {
		this.classSubjectTeachers = classSubjectTeachers;
	}

	// helper method

	public void addClassSubjectTeacher(ClassSubjectTeacher classSubjectTeacher)
	{
		this.classSubjectTeachers.add(classSubjectTeacher);
	}

}
