/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.response.HttpResponse;
import com.example.demo.response.Response;
import com.example.demo.response.SearchRequest;
import com.example.demo.service.PersonService;
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
@RequestMapping("/people")
public class PersonController {
    
    private final PersonService personService;
    
    @GetMapping("/all")
    public ResponseEntity<Response> getAll(){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("People have been successuffly imporeted!", Map.of("values",personService.getAll()), HttpStatus.OK));

    }
    
    @GetMapping("/search/{searchRequest}")
    public ResponseEntity<Response> searchPerson(@PathVariable("searchRequest") String searchRequest){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Searched people: ", Map.of("values", personService.searchPeople(searchRequest)), HttpStatus.OK));
    }
    
    @PostMapping("/add")
    public ResponseEntity<Response> addPerson(@RequestBody PersonDto person){
        personService.addPerson(person);
        return ResponseEntity.ok(HttpResponse.getResponse("Person has been successfully added!", HttpStatus.OK));
    }
    
    @GetMapping("/getPerson/{personId}")
    public ResponseEntity<Response> findPersonById(@PathVariable("personId") String personId){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Person has been found!", Map.of("values", personService.getPerson(personId)), HttpStatus.OK));
    }
    
    @PostMapping("/delete")
    public ResponseEntity<Response> deletePerson(@RequestBody String personId){
        personService.deletePerson(personId);
        return ResponseEntity.ok(HttpResponse.getResponse("Person has been successfully deleted!", HttpStatus.OK));
    }
    
    @PostMapping("/update")
    public ResponseEntity<Response> updatePerson(@RequestBody PersonDto person){
        return ResponseEntity.ok(HttpResponse.getResponseWithData("Person has been successfully updated!", Map.of("value", personService.updatePerson(person)), HttpStatus.OK));
    }
}
