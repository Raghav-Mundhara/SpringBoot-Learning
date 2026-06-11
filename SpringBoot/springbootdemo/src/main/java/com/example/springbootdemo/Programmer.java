package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Programmer {
    private Computer com;
    @Value("25")
    private int age;
    
    public Computer getComputer() {
        return com;
    }
    @Autowired
    @Qualifier("laptop")
    public void setComputer(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    public void proramming(){
        com.coding();
    }
}
