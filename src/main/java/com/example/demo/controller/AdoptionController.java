/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.AdoptionDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.response.HttpResponse;
import com.example.demo.response.Response;
import com.example.demo.response.SearchRequest;
import com.example.demo.service.AdoptionServise;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Iva
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/adoptions")
public class AdoptionController {
    
    private final AdoptionServise adoptionService;
    
    @GetMapping("/all")
    public ResponseEntity<Response> getAll(){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Adoptions have been successuffly imporeted!", Map.of("values",adoptionService.getAll()), HttpStatus.OK));

    }
    
    @PostMapping("/add")
    public ResponseEntity<Response> addAdoption(@RequestBody AdoptionDto adoption){
        adoptionService.addAdoption(adoption);
        return ResponseEntity.ok(HttpResponse.getResponse("Adoption has been successfully added!", HttpStatus.OK));
    }
    
    @GetMapping("/getAdoption/{adoptionId}")
    public ResponseEntity<Response> findAdoptionById(@PathVariable("adoptionId") int adoptionId){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Adoption has been found!", Map.of("values", adoptionService.getAdoption(adoptionId)), HttpStatus.OK));
    }
    
    @PostMapping("/delete")
    public ResponseEntity<Response> deleteAdoption(@RequestBody int adoptionId){
        adoptionService.deleteAdoption(adoptionId);
        return ResponseEntity.ok(HttpResponse.getResponse("Adoption has been successfully deleted!", HttpStatus.OK));
    }
    
    @PostMapping("/update")
    public ResponseEntity<Response> updateAdoption(@RequestBody AdoptionDto adoption){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Adoption has been successfully updated!", Map.of("value", adoptionService.updateAdoption(adoption)), HttpStatus.OK));
    }
    
}
