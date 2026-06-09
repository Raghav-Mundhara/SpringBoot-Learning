package org.example;

import java.util.TimeZone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void saveStudent(Student student, SessionFactory sessionfactory) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
		session.close();
	}

	public static void getStudentById(SessionFactory sessionfactory,int Id){
		Session session = sessionfactory.openSession();
		Student s=session.find(Student.class, Id);
		System.out.println(s.toString());
		session.close();
	}
	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		Student student = new Student();

		String[] names = {"Alice", "Bob", "Charlie", "Diana", "Ethan", "Fatima", "George", "Hannah"};
		String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com"};
		String name = names[(int) (Math.random() * names.length)];
		String email = name.toLowerCase() + (int)(Math.random() * 1000) + "@" + domains[(int) (Math.random() * domains.length)];
		
		student.setId((int) (Math.random() * 100));
		student.setName(name);
		student.setEmail(email);

		System.out.println(student);
		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class);
		SessionFactory sessionfactory = configuration.buildSessionFactory();

		saveStudent(student, sessionfactory);
		getStudentById(sessionfactory,0);
	}

}
