package com.springsecurity.demo;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    @GetMapping("hello")
    public String greet(HttpServletRequest request) {
        return "Hello" + request.getSession().getId();
    }
    
}
