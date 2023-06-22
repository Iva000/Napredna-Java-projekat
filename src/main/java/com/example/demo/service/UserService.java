/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Iva
 */

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    
    public String login(String username, String password){
        try{
            User user = userRepo.findByUsername(username);//.orElse(null);
            if(user !=null){
                if(user.getPassword().equals(password)){
                return "Welcome back " + user.getFirstname()+ " " + user.getLastname()+"!";
                }
            }
        }catch(Exception ex){
            return "Wrong username or password!";
        }
        return "Wrong username or password!";
    }
}
