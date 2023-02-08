package org.simplilearn.lms.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ClassSubjectLinkId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid")
    private AcademicClass academicClass;

//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sid")
    private Subject subject;

	@ManyToOne(cascade = CascadeType.ALL)
//	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "tid")
    private Teacher teacher;
	
	public AcademicClass getAcademicClass() {
		return academicClass;
	}

	public void setAcademicClass(AcademicClass academicClass) {
		this.academicClass = academicClass;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}	
}
