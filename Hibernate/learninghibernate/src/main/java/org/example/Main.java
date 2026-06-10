package org.example;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


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

	public static void updateStudent(SessionFactory sessionfactory,Student student){
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.merge(student);
		session.getTransaction().commit();
		session.close();
	}

	public static void deleteStudent(SessionFactory sessionfactory,int Id){
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Student s=session.find(Student.class, Id);
		session.remove(s);
		session.getTransaction().commit();
		session.close();
	}

	public static void saveLaptop(Laptop laptop, SessionFactory sessionfactory) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.persist(laptop);
		session.getTransaction().commit();
		session.close();
	}

	public static void getLaptopByRam(SessionFactory sessionfactory,int ram){
		Session session = sessionfactory.openSession();
		Query<Laptop> query = session.createQuery("from Laptop where ram = :ram", Laptop.class);
		query.setParameter("ram", ram);
		List<Laptop> laptops = query.getResultList();
		for(Laptop laptop : laptops) {
			System.out.println(laptop.toString());
		}
		session.close();
	}
	
	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		
		
		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Student.class);
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Laptop laptop1 = new Laptop();
		laptop1.setId(1);
		laptop1.setBrand("Dell");
		laptop1.setModel("XPS 13");
		laptop1.setRam(16);

		saveLaptop(laptop1, sessionfactory);

		Laptop laptop2 = new Laptop();
		laptop2.setId(2);
		laptop2.setBrand("Apple");
		laptop2.setModel("MacBook Pro");
		laptop2.setRam(16);

		saveLaptop(laptop2, sessionfactory);

		Laptop laptop3 = new Laptop();
		laptop3.setId(3);
		laptop3.setBrand("HP");
		laptop3.setModel("Spectre x360");
		laptop3.setRam(8);
		saveLaptop(laptop3, sessionfactory);

		Laptop laptop4 = new Laptop();
		laptop4.setId(4);
		laptop4.setBrand("Lenovo");
		laptop4.setModel("ThinkPad X1 Carbon");
		laptop4.setRam(16);
		saveLaptop(laptop4, sessionfactory);


		getLaptopByRam(sessionfactory, 8);
		
		
		
	}

}
