package org.simplilearn.lms.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String name;
	private String address;
	private String designation;
	private String skill;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClassSubjectTeacher> classSubjectTeachers;
		
	//Helper method
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Set<ClassSubjectTeacher> getClassSubjectTeachers() {
		return classSubjectTeachers;
	}

	public void setClassSubjectTeachers(Set<ClassSubjectTeacher> classSubjectTeachers) {
		this.classSubjectTeachers = classSubjectTeachers;
	}
	
	public void addClassSubjectTeacher(ClassSubjectTeacher classSubjectTeacher)
	{
		this.classSubjectTeachers.add(classSubjectTeacher);
	}
	
	public void removeClassSubjectTeacher(ClassSubjectTeacher classSubjectTeacher)
	{
		this.classSubjectTeachers.remove(classSubjectTeacher);
	}
}
