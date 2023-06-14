package com.example.demo.model;


import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
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
public class Adoption implements Serializable, EntityDB{
    
    @Id
    @Column(name="adoptionId", nullable = false,updatable = false,unique = true)
    private int adoptionId;
    
    @Column(name="date",nullable = false,updatable = true)
    private LocalDate date;
    
    @Column(name="firstTime",nullable = false,updatable = true)
    private boolean firstTime;
    
    @Column(name="vetReport",nullable = false,updatable = true)
    private String vetReport;
    
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@ManyToOne
    @Column(name="petId",nullable = false,updatable = false,unique = true)
    private int petId;
    
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@ManyToOne
    //joinColumn
    @Column(name="personId",nullable = false,updatable = false,unique = true)
    private String personId;
    
}
