/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.PetDto;
import com.example.demo.response.HttpResponse;
import com.example.demo.response.Response;
import com.example.demo.response.SearchRequest;
import com.example.demo.service.PetService;
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
@RequestMapping("/pets")
public class PetController {
    
    private final PetService petService;
    
    @GetMapping("/all")
    public ResponseEntity<Response> getAll(){
        System.out.println("usao u uzimanje svih");
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Pets have been successuffly imporeted!", Map.of("values",petService.getAll()), HttpStatus.OK));

    }
    
    @GetMapping("/search/{searchRequest}")
    public ResponseEntity<Response> searchPet(@PathVariable("searchRequest") String searchRequest){
        System.out.println("usao u kontroler");
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Searched pets: ", Map.of("values", petService.searchPets(searchRequest)), HttpStatus.OK));
    }
    
    @PostMapping("/delete")
    public ResponseEntity<Response> deletePet(@RequestBody int petId){
        System.out.println("Usao u brisanje");
        petService.deletePet(petId);
        return ResponseEntity.ok(HttpResponse.getResponse("Pet has been successfully deleted!", HttpStatus.OK));
    
        //return ResponseEntity.ok(HttpResponse.getResponseWithData("Pet has been successfully deleted!", Map.of("values", petService.deletePet(petId)), HttpStatus.OK));
    }
    
    @PostMapping("/add")
    public ResponseEntity<Response> addPet(@RequestBody PetDto pet){
        System.out.println("Usao u kontrolera za dodavanje");
        petService.addPet(pet);
        return ResponseEntity.ok(HttpResponse.getResponse("Pet has been successfully added!", HttpStatus.OK));
    }
    
    @GetMapping("/getPet/{petId}")
    public ResponseEntity<Response> findPetById(@PathVariable("petId") int petId){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Pet has been found!", Map.of("values", petService.getPet(petId)), HttpStatus.OK));
    }
    
    
    
    @PostMapping("/update")
    public ResponseEntity<Response> updatePet(@RequestBody PetDto pet){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Pet has been successfully updated!", Map.of("value", petService.updatePet(pet)), HttpStatus.OK));
    }
    
}
