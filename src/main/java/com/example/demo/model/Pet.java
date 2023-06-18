package com.example.demo.model;


import com.example.demo.dto.TypeDto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Pet implements Serializable, EntityDB{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,updatable = false,unique = true)
    private int id;
    
    @Column(name="name",nullable = false,updatable = true)
    private String name;
    
    @Column(name="age",nullable = false,updatable = true)
    private int age;
    
    @ManyToOne
    @JoinColumn(name="type",nullable = false,updatable = true)
    private Type type;
    
    @Column(name="description",nullable = false,updatable = true)
    private String description;
    
    @Column(name="gender",nullable = false,updatable = true)
    private String gender;
}
