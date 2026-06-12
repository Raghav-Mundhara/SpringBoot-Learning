package com.example.springjdbc;

import java.util.List;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.springjdbc.model.Student;
import com.example.springjdbc.service.StudentService;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		ApplicationContext context = SpringApplication.run(SpringjdbcApplication.class, args);

		Student s= context.getBean(Student.class);

		s.setRollNo(1);
		s.setName("John Doe");
		s.setMarks(85);

		StudentService studentService = context.getBean(StudentService.class);

		studentService.addStudent(s);

	 	List<Student> students = studentService.getStudents();
		System.out.println("Students: " + students);
	}

}
