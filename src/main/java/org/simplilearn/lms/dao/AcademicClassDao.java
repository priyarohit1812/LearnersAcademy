package org.simplilearn.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.lms.config.HibConfig;
import org.simplilearn.lms.entities.AcademicClass;

public class AcademicClassDao implements IAcademicClass {
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
		org.hibernate.query.Query<AcademicClass> query = session.createQuery("Select a from org.simplilearn.lms.entities.AcademicClass a");
		return query.list();
	}

	@Override
	public AcademicClass get(int cid) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		AcademicClass academicClass = session.get(AcademicClass.class, cid);
		return academicClass;
	}

	@Override
	public void delete(AcademicClass academicClass) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(academicClass);
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
			session.save(academicClass);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}		
	}
}
