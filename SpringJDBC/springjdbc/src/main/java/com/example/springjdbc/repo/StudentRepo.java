package com.example.springjdbc.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springjdbc.model.Student;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;
    
    public void save(Student student) {
        String sql = "INSERT INTO students (rollno, name, marks) VALUES (?, ?, ?)";
        int rows = jdbc.update(sql,student.getRollNo(), student.getName(), student.getMarks());
        if (rows > 0) {
            System.out.println("Student saved successfully!");
        } else {
            System.out.println("Failed to save student.");
        }
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        RowMapper<Student> rowMapper = new RowMapper<Student>(){
            @Override
            public Student mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Student student = new Student();
                student.setRollNo(rs.getInt("rollno"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getInt("marks"));
                return student;
            }
        };
        List<Student> students = jdbc.query(sql, rowMapper);
        return students;
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
