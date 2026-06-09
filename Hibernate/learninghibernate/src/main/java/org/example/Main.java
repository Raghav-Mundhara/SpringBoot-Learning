package org.example;

import java.util.TimeZone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		Student student = new Student();
		student.setId((int) (Math.random() * 10000));
		student.setName("John Doe");
		student.setEmail("john.doe@example.com");

		System.out.println(student);
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);

		SessionFactory sessionfactory = configuration.buildSessionFactory();

		Session session = sessionfactory.openSession();

		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();

	}

}