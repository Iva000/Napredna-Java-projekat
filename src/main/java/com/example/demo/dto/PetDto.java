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
public class PetDto implements EntityDto{
    private int id;
    private String name;
    private int age;
    private TypeDto type;
    private String description;
    private String gender;
}
