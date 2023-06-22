package com.example.demo.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="adoptionId", nullable = false,updatable = false,unique = true)
    private int adoptionId;
    
    @Column(name="date",nullable = false,updatable = true)
    private LocalDate date;
    
//    @Column(name="firstTime",nullable = false,updatable = true)
//    private boolean firstTime;
    
    @Column(name="vetReport",nullable = false,updatable = true)
    private String vetReport;
    
    @ManyToOne
    @JoinColumn(name="petId",nullable = false,updatable = true)
    private Pet petId;
    
    @ManyToOne
    @JoinColumn(name="personId",nullable = false,updatable = true)
    private Person personId;
    
}
