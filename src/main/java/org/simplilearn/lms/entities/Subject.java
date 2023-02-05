package org.simplilearn.lms.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Teacher_Subject", joinColumns = @JoinColumn(name = "sid"), inverseJoinColumns = @JoinColumn(name = "tid"))
	private Set<Teacher> teachers = new HashSet<Teacher>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Subject_Class", joinColumns = @JoinColumn(name = "sid"), inverseJoinColumns = @JoinColumn(name = "cid"))
	private Set<AcademicClass> classes = new HashSet<AcademicClass>();

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

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public void setClasses(Set<AcademicClass> classes) {
		this.classes = classes;
	}

	public Set<Teacher> getTeachers() {
		return this.teachers;
	}

	public Set<AcademicClass> getClasses() {
		return this.classes;
	}

	// helper method

	public void addClass(AcademicClass academicClass) {
		this.classes.add(academicClass);
	}

	public void addTeacher(Teacher teacher) {
		this.teachers.add(teacher);
	}

}
