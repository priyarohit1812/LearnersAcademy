/**
 * 
 */
package org.simplilearn.lms.entities;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class ClassSubjectTeacher {
	@EmbeddedId
	private ClassSubjectLinkId linkPk = new ClassSubjectLinkId();
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "tid")
    private Teacher teacher;
	
	@Transient
    public AcademicClass getAcademicClass() {
        return getLinkPk().getAcademicClass();
    }

    @Transient
    public Subject getSubject() {
        return getLinkPk().getSubject();
    }

	public ClassSubjectLinkId getLinkPk() {
		return linkPk;
	}

	public void setLinkPk(ClassSubjectLinkId linkPk) {
		this.linkPk = linkPk;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}		
}
