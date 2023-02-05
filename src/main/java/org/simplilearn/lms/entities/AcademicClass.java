package org.simplilearn.lms.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class AcademicClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String name;
	private int duration;
	@ManyToMany(mappedBy = "classes", cascade = CascadeType.ALL)
	private Set<Subject> subjects = new HashSet<>();
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
	public Set<Subject> getSubjects() {
		return this.subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	//helper method
	
	public void addSubject(Subject subject)
	{
		this.subjects.add(subject);
	}
	
}
