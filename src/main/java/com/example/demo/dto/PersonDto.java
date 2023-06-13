/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Iva
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDto implements EntityDto{
    
    private String jmbg;
    private String name;
    private String surname;
    private int year_of_birth;
    private CityDto city;
    private String phone_number;
    
}
