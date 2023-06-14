/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.EntityDB;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author Iva
 */
@Component
public class UserMapper implements IMapper<UserDto, User>{

    @Override
    public User toEntityDB(UserDto entityDto) {
        User u = new User();
        u.setId(entityDto.getId());
        u.setFirstname(entityDto.getFirstname());
        u.setLastname(entityDto.getLastname());
        u.setUsername(entityDto.getUsername());
        u.setPassword(entityDto.getPassword());
        return u;
    }

    @Override
    public UserDto toEntityDto(User entityDB) {
        UserDto user = new UserDto();
        user.setId(entityDB.getId());
        user.setFirstname(entityDB.getFirstname());
        user.setLastname(entityDB.getLastname());
        user.setUsername(entityDB.getUsername());
        user.setPassword(entityDB.getPassword());
        return user;
    }
    
}
