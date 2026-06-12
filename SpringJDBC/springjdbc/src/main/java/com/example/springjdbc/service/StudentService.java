package com.example.springjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springjdbc.model.Student;
import com.example.springjdbc.repo.StudentRepo;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    public StudentRepo getStudentRepo() {
        return studentRepo;
    }
    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    public void addStudent(Student student) {
        studentRepo.save(student);
    }
    public List<Student> getStudents() {
        // In a real application, this would fetch data from the database
        return studentRepo.findAll();
    }
}
