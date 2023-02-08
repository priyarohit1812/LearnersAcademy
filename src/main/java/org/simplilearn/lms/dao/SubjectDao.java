package org.simplilearn.lms.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.simplilearn.lms.config.HibConfig;
import org.simplilearn.lms.entities.Subject;

public class SubjectDao implements ISubjectDao {

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
		Hibernate.initialize(subject.getClassSubjectTeachers());
		session.close();
		return subject;
	}

	@Override
	public void delete(int sid) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query deleteQuery = session.createQuery("DELETE FROM org.simplilearn.lms.entities.Subject s WHERE s.sid = :sid");
			deleteQuery.setParameter("sid", sid);
			deleteQuery.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void update(Subject subject) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(subject);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
