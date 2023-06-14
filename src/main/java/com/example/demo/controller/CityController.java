/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.response.HttpResponse;
import com.example.demo.response.Response;
import com.example.demo.service.CityService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Iva
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {
    
    private final CityService cityService;
    @GetMapping("/all")
    public ResponseEntity<Response> getAll(){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Cities have been successuffly imporeted!", Map.of("values",cityService.getAll()), HttpStatus.OK));
    }
    
}
