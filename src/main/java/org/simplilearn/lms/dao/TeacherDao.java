package org.simplilearn.lms.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.simplilearn.lms.config.HibConfig;
import org.simplilearn.lms.entities.Teacher;

public class TeacherDao implements ITeacherDao {

	@Override
	public void insert(Teacher teacher) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(teacher);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Teacher> getAll() {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Query<Teacher> query = session.createQuery("Select t from org.simplilearn.lms.entities.Teacher t",
				Teacher.class);
		List<Teacher> allTeachers = query.list();
		session.close();
		return allTeachers;
	}

	
	@Override
	public void update(Teacher teacher) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(teacher);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public Teacher get(int tid) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Teacher teacher = session.get(Teacher.class, tid);
		Hibernate.initialize(teacher.getClassSubjectTeachers());
		session.close();
		return teacher;
	}

	@Override
	public Teacher get(String name) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Query<Teacher> query = session.createQuery("Select t from org.simplilearn.lms.entities.Teacher t where name=?1",
				Teacher.class);
		query.setParameter(1, name);
		Teacher result = query.getSingleResult();
		session.close();
		return result;
	}

	@Override
	public void delete(int tid) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query deleteQuery = session.createQuery("DELETE FROM org.simplilearn.lms.entities.Teacher t WHERE t.tid = :tid");
			deleteQuery.setParameter("tid", tid);
			deleteQuery.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		
	}

}
