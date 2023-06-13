package com.example.demo.model;


import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Iva
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable, EntityDB{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,updatable = false,unique = true)
    private int id;
    
    @Column(name="firstname",nullable = false,updatable = true)
    private String firstname;
    
    @Column(name="lastname",nullable = false,updatable = true)
    private String lastname;
    
    @Column(name="username",nullable = false,updatable = true)
    private String username;
    
    @Column(name="password",nullable = false,updatable = true)
    private String password;
}
