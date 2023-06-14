/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.response.HttpResponse;
import com.example.demo.response.Response;
import com.example.demo.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Iva
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/types")
public class TypeController {
    
    private final TypeService typeService;
    
    @GetMapping("/all")
    public ResponseEntity<Response> getAll(){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Types have been successfully imported!", Map.of("values", typeService.getAll()), HttpStatus.OK));
    }
    
}
