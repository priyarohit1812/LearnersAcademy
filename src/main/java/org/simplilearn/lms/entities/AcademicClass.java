package org.simplilearn.lms.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AcademicClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String name;
	private int duration;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "linkPk.academicClass", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClassSubjectTeacher> classSubjectTeachers;
    	
	@OneToMany(mappedBy = "academicClass", cascade = CascadeType.ALL)
	private Set<Student> students= new HashSet<>();
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	public Set<ClassSubjectTeacher> getClassSubjectTeachers() {
		return classSubjectTeachers;
	}

	public void setClassSubjectTeachers(Set<ClassSubjectTeacher> classSubjectTeachers) {
		this.classSubjectTeachers = classSubjectTeachers;
	}
	
	//helper method
	
	public void addClassSubjectTeacher(ClassSubjectTeacher classSubjectTeacher)
	{
		this.classSubjectTeachers.add(classSubjectTeacher);
	}
	
}
