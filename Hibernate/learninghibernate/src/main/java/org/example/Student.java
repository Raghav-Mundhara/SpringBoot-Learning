package org.example;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    @ManyToMany
    private List<Laptop> laptops;

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
    public List<Laptop> getLaptops() {
        return laptops;
    }
    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", laptop=" + laptops + "]";
    }    
 
}