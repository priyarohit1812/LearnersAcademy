package org.simplilearn.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.lms.config.HibConfig;
import org.simplilearn.lms.entities.Teacher;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public void insert(Teacher teacher) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(teacher);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Teacher> getAll() {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		org.hibernate.query.Query<Teacher> query = session.createQuery("Select t from org.simplilearn.lms.entities.Teacher t");
		session.close();
		return query.list();
	}

	@Override
	public void delete(Teacher teacher) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(teacher);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void update(Teacher teacher) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(teacher);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}		
	}

	@Override
	public Teacher get(int tid) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Teacher teacher = session.get(Teacher.class, tid);
		return teacher;
	}

	@Override
	public Teacher get(String name) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		org.hibernate.query.Query<Teacher> query = session.createQuery("Select t from org.simplilearn.lms.entities.Teacher t where name=?1");
		query.setParameter(1, name);
		return query.getSingleResult();
	}

}
