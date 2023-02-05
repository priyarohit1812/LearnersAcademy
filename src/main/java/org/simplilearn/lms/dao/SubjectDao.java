package org.simplilearn.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.simplilearn.lms.config.HibConfig;
import org.simplilearn.lms.entities.Subject;

public class SubjectDao implements ISubject {

	@Override
	public void insert(Subject subject) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(subject);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.clear();
			session.close();
		}

	}

	@Override
	public List<Subject> getAll() {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Query<Subject> query = session
				.createQuery("Select s from org.simplilearn.lms.entities.Subject s", Subject.class);
		List<Subject> allSubjects = query.list();
		session.close();
		return allSubjects;
	}

	@Override
	public Subject get(int sid) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Subject subject = session.get(Subject.class, sid);
		return subject;
	}

	@Override
	public void delete(Subject subject) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(subject);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void update(Subject subject) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(subject);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
