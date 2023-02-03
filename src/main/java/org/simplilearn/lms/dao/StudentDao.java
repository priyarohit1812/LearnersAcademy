package org.simplilearn.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.lms.config.HibConfig;
import org.simplilearn.lms.entities.Student;
import org.simplilearn.lms.entities.Subject;

public class StudentDao implements IStudent{
	@Override
	public void insert(Student student) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		}

	@Override
	public List<Student> getAll() {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		org.hibernate.query.Query<Student> query = session.createQuery("Select s from org.simplilearn.lms.entities.Student s");
		return query.list();
	}

	@Override
	public Student get(int sid) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Student student = session.get(Student.class, sid);
		return student;
	}

	@Override
	public void delete(Student student) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(student);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
				
	}

	@Override
	public void update(Student student) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}		
	}
}
