package org.simplilearn.lms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	private String address;
	private int age;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cid")
	private AcademicClass academicClass;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public AcademicClass getAcademicClass() {
		return academicClass;
	}
	public void setAcademicClass(AcademicClass academicClass) {
		this.academicClass = academicClass;
	}
	
}
