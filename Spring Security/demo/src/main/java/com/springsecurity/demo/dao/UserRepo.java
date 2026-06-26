package com.springsecurity.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.demo.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    User findByUsername(String username);
}
