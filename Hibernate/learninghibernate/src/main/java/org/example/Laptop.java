package org.example;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
// Embeddable class to represent the Laptop details of a Student. This class will be embedded in the Student entity.
// @Embeddable
@Entity
public class Laptop {
    @Id
    private int id;
    private String brand;
    private String model;
    private int ram;
    @ManyToOne
    private Student student;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Override
    public String toString() {
        return "Laptop [id=" + id + ", brand=" + brand + ", model=" + model + ", ram=" + ram + ", student=" + student + "]";
    }

}
