package com.example.demo.model;


import com.example.demo.dto.CityDto;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Person implements Serializable, EntityDB{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="jmbg",nullable = false,updatable = false,unique = true)
    private String jmbg;
    
    @Column(name="name", nullable = false, updatable = true)
    private String name;
    
    @Column(name="surname", nullable = false, updatable = true)
    private String surname;
    
    @Column(name="year_of_birth", nullable = false, updatable = true)
    private int year_of_birth;
    
    @ManyToOne
    @JoinColumn(name="city", nullable = false, updatable = true)
    private CityDto city;
    
    @Column(name="phone_number", nullable = false, updatable = true)
    private String phone_number;
    
}