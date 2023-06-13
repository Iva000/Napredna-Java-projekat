/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.response;

import com.example.demo.dto.EntityDto;
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
public class SearchRequest implements EntityDto{
    
    String searchType;
    String searchField;
}
