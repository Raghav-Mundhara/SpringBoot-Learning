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


		Laptop laptop1 = new Laptop();
		String[] brands = {"Dell", "HP", "Lenovo", "Asus", "Acer", "Apple", "MSI", "Samsung"};
		String[] models = {"XPS 13", "Pavilion", "ThinkPad X1", "ZenBook", "Aspire 5", "MacBook Pro", "Stealth 15", "Galaxy Book"};
		int[] ramOptions = {8, 16, 32, 64};

		laptop1.setId((int) (Math.random() * 100));
		laptop1.setBrand(brands[(int) (Math.random() * brands.length)]);
		laptop1.setModel(models[(int) (Math.random() * models.length)]);
		laptop1.setRam(ramOptions[(int) (Math.random() * ramOptions.length)]);
		laptop1.setStudent(student);
		Laptop laptop2 = new Laptop();
		laptop2.setId((int) (Math.random() * 100));
		laptop2.setBrand(brands[(int) (Math.random() * brands.length)]);
		laptop2.setModel(models[(int) (Math.random() * models.length)]);
		laptop2.setRam(ramOptions[(int) (Math.random() * ramOptions.length)]);
		laptop2.setStudent(student);

		List<Laptop> laptops = Arrays.asList(laptop1, laptop2);
		student.setLaptops(laptops);
		
		saveStudent(student, sessionfactory);
		saveLaptop(laptop1, sessionfactory);
		saveLaptop(laptop2, sessionfactory);
		
		// updateStudent(sessionfactory, student);
	}

}
