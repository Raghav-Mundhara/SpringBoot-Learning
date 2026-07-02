package com.example.practice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.practice.dto.UserDto;

@Repository
public class UserRepository {
    List<UserDto> users = new ArrayList<>();

    public UserRepository(){
        users.add(new UserDto(UUID.randomUUID().toString(), "Raghav", "Raghav@gmail.com"));
        users.add(new UserDto(UUID.randomUUID().toString(), "Aryan", "Aryan@gmail.com"));
        users.add(new UserDto(UUID.randomUUID().toString(), "Anish", "Anish@gmail.com"));
    }

    public List<UserDto> findAll(){
        return this.users;
    }

    public UserDto getById(String id) {
        UserDto user=null;
        for (UserDto u : users) {
            if(u.getId()==id){
                user=u;
            }
        }
        return user;
    }

    public UserDto createUser(UserDto user) {
        users.add(user);
        return user;
    }
    
    
}
