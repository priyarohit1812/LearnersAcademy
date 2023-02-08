package org.simplilearn.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.simplilearn.lms.config.HibConfig;
import org.simplilearn.lms.entities.Student;

public class StudentDao implements IStudentDao {
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
		} finally {
			session.close();
		}

	}

	@Override
	public List<Student> getAll() {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Query<Student> query = session.createQuery("Select s from org.simplilearn.lms.entities.Student s",
				Student.class);
		List<Student> allStudents = query.list();
		session.close();
		return allStudents;
	}

	@Override
	public Student getStudent(int stuId) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Student student = session.get(Student.class, stuId);
		session.close();
		return student;
	}

	@Override
	public void deleteStudent(int stuId) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query deleteQuery = session
					.createQuery("DELETE FROM org.simplilearn.lms.entities.Student s WHERE s.stuId = :stuId");
			deleteQuery.setParameter("stuId", stuId);
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
	public void update(Student student) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(student);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
