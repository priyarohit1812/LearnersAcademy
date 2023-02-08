package org.simplilearn.lms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.simplilearn.lms.config.HibConfig;
import org.simplilearn.lms.entities.User;

public class UserDao implements IUserDao {

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
		} finally {
			session.close();
		}
	}

	@Override
	public User get(String username, String password) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		User user = null;
		try {
			Query<User> query = session.createQuery(
					"select u from org.simplilearn.lms.entities.User u where u.username= :username and u.password=:password",
					User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			user = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return user;
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
		} finally {
			session.close();
		}
	}

}
