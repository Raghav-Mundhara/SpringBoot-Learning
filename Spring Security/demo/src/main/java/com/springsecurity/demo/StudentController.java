package com.springsecurity.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
        new Student(1,"Raghav","Nodejs"),
        new Student(2,"Aryan","CPP"),
        new Student(3,"Anish","Java")
    ));

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("students")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
        System.out.println(students);
    }
    
}
