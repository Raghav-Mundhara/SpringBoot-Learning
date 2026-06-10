package org.example;

import java.util.*;

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

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		
		String[] names = {"Alice", "Bob", "Charlie", "Diana", "Ethan", "Fatima", "George", "Hannah"};
		String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com"};
		String name = names[(int) (Math.random() * names.length)];
		String email = name.toLowerCase() + (int)(Math.random() * 1000) + "@" + domains[(int) (Math.random() * domains.length)];
		
		Student student1 = new Student();
		student1.setId((int) (Math.random() * 100));
		student1.setName(name);
		student1.setEmail(email);

		name = names[(int) (Math.random() * names.length)];
		email = name.toLowerCase() + (int)(Math.random() * 1000) + "@" + domains[(int) (Math.random() * domains.length)];
		
		Student student2 = new Student();
		student2.setId((int) (Math.random() * 100));
		student2.setName(name);
		student2.setEmail(email);
		
		name = names[(int) (Math.random() * names.length)];
		email = name.toLowerCase() + (int)(Math.random() * 1000) + "@" + domains[(int) (Math.random() * domains.length)];

		Student student3 = new Student();
		student3.setId((int) (Math.random() * 100));
		student3.setName(name);
		student3.setEmail(email);

		System.out.println(student1.toString());
		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Student.class);
		SessionFactory sessionfactory = configuration.buildSessionFactory();

		// saveStudent(student, sessionfactory);
		// getStudentById(sessionfactory,0);

		// Student student2 = new Student();
		// student2.setId(0);
		// student2.setName("Ethan");
		// student2.setEmail("ethan123@gmail.com");

		// updateStudent(sessionfactory, student2);
		// deleteStudent(sessionfactory, 0);


		String[] brands = {"Dell", "HP", "Lenovo", "Asus", "Acer", "Apple", "MSI", "Samsung"};
		String[] models = {"XPS 13", "Pavilion", "ThinkPad X1", "ZenBook", "Aspire 5", "MacBook Pro", "Stealth 15", "Galaxy Book"};
		int[] ramOptions = {8, 16, 32, 64};
		
		Laptop laptop1 = new Laptop();
		laptop1.setId((int) (Math.random() * 100));
		laptop1.setBrand(brands[(int) (Math.random() * brands.length)]);
		laptop1.setModel(models[(int) (Math.random() * models.length)]);
		laptop1.setRam(ramOptions[(int) (Math.random() * ramOptions.length)]);
		laptop1.setStudent(Arrays.asList(student1,student2));

		Laptop laptop2 = new Laptop();
		laptop2.setId((int) (Math.random() * 100));
		laptop2.setBrand(brands[(int) (Math.random() * brands.length)]);
		laptop2.setModel(models[(int) (Math.random() * models.length)]);
		laptop2.setRam(ramOptions[(int) (Math.random() * ramOptions.length)]);
		laptop2.setStudent(Arrays.asList(student1,student3));

		Laptop laptop3 = new Laptop();
		laptop3.setId((int) (Math.random() * 100));
		laptop3.setBrand(brands[(int) (Math.random() * brands.length)]);
		laptop3.setModel(models[(int) (Math.random() * models.length)]);
		laptop3.setRam(ramOptions[(int) (Math.random() * ramOptions.length)]);
		laptop3.setStudent(Arrays.asList(student1));

		student1.setLaptops(Arrays.asList(laptop1,laptop2));
		student2.setLaptops(Arrays.asList(laptop1,laptop3));
		student3.setLaptops(Arrays.asList(laptop1));
		
		saveLaptop(laptop1, sessionfactory);
		saveLaptop(laptop2, sessionfactory);
		saveLaptop(laptop3, sessionfactory);
		saveStudent(student1, sessionfactory);
		saveStudent(student2, sessionfactory);
		saveStudent(student3, sessionfactory);
		
		// updateStudent(sessionfactory, student);
	}

}
