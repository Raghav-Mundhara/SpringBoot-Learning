package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Programmer {
    @Autowired
    Laptop laptop;

    public void proramming(){
        laptop.coding();
    }
}
