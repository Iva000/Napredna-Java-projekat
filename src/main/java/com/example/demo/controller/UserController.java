/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.response.HttpResponse;
import com.example.demo.response.Response;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Iva
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;
    
    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<Response> deletePet(@PathVariable("username") String username, @PathVariable("password") String password){
        String message = userService.login(username, password);
        return ResponseEntity.ok(HttpResponse.getResponse(message, HttpStatus.OK));
    }
            
    
}
