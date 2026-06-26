package com.springsecurity.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    @GetMapping("hello")
    public String greet(HttpServletRequest request) {
        System.out.println("Hello function called");
        return "Hello " + request.getSession().getId();
    }
    
}
