package org.simplilearn.lms.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.simplilearn.lms.entities.AcademicClass;
import org.simplilearn.lms.entities.Student;
import org.simplilearn.lms.entities.Subject;
import org.simplilearn.lms.entities.Teacher;
import org.simplilearn.lms.entities.User;

public class HibConfig {
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/testdb1");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "Namish@1602");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(Teacher.class);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(AcademicClass.class);
		configuration.addAnnotatedClass(User.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
		}
	}
		