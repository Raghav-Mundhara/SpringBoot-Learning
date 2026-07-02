package com.example.practice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.practice.dto.UserDto;

@Repository
public class UserRepository {
    List<UserDto> users = new ArrayList<>();

    public UserRepository(){
        users.add(new UserDto(1L, "Raghav", "Raghav@gmail.com"));
        users.add(new UserDto(2L, "Aryan", "Aryan@gmail.com"));
        users.add(new UserDto(3L, "Anish", "Anish@gmail.com"));
    }
    
}
