package com.example.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practice.dto.UserDto;
import com.example.practice.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public List<UserDto> getAllUsers(){
        return this.userRepository.findAll();
    }
    public UserDto getUserById(String id){
        return this.userRepository.getById(id);
    }

    public UserDto createUser(UserDto user) {
        return this.userRepository.createUser(user);
    }
}
