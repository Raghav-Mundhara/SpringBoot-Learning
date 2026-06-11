package com.example.springbootdemo;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    public void coding(){
        System.out.println("Coding... Laptop is coding");
    }
}
