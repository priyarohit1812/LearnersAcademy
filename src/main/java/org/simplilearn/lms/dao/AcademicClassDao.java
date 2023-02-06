package org.simplilearn.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.simplilearn.lms.config.HibConfig;
import org.simplilearn.lms.entities.AcademicClass;

public class AcademicClassDao implements IAcademicClassDao {
	@Override
	public void insert(AcademicClass academicClass) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(academicClass);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public List<AcademicClass> getAll() {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Query<AcademicClass> query = session
				.createQuery("SELECT a FROM org.simplilearn.lms.entities.AcademicClass a ORDER BY a.cid", AcademicClass.class);
		List<AcademicClass> classes = query.list();
		session.close();
		return classes;
	}

	@Override
	public AcademicClass get(int cid) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		AcademicClass academicClass = session.get(AcademicClass.class, cid);
		return academicClass;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void delete(int cid) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query deleteQuery = session.createQuery("DELETE FROM org.simplilearn.lms.entities.AcademicClass a WHERE a.cid = :cid");
			deleteQuery.setParameter("cid", cid);
			deleteQuery.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void update(AcademicClass academicClass) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(academicClass);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
