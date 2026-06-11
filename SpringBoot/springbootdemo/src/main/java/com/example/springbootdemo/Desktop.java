package com.example.springbootdemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer {
    public void coding(){
        System.out.println("Desktop is coding");
    }
}
