package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;

    private Laptop laptop;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Laptop getLaptop() {
        return laptop;
    }
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", laptop=" + laptop + "]";
    }    
 
}