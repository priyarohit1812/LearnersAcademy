package org.simplilearn.lms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.simplilearn.lms.config.HibConfig;
import org.simplilearn.lms.entities.User;

public class UserDao implements IUser {

	@Override
	public void insert(User user) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public User get(String username, String password) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Query<User> query = session.createQuery("select u from org.simplilearn.lms.entities.User u where u.username=?1 and u.password=?2");
		query.setParameter(1, username);
		query.setParameter(2, password);
		
		return query.getSingleResult();
	}

	@Override
	public void update(User user) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
