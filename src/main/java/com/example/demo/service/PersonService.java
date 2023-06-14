/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.PersonDto;
import com.example.demo.mapper.CityMapper;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.repo.CityRepo;
import com.example.demo.repo.PersonRepo;
import com.example.demo.response.SearchRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Iva
 */
@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {
        
    private final PersonRepo personRepo;
    private final PersonMapper personMapper;
    private final CityRepo cityRepo;
    private final CityMapper cityMapper;
    
    public List<PersonDto> getAll(){
        List<Person> people = personRepo.findAll();
        return people.stream().map((person)-> personMapper.toEntityDto(person, cityMapper.toEntityDto(person.getCity()))).collect(Collectors.toList());
    }
    
    public List<PersonDto> searchPeople(SearchRequest searchDto){
        List<Person> people;
        if(searchDto.getSearchField()==""){
            people = personRepo.findAll();
        }else //if(searchDto.getSearchType().equals("Name"))
        {
            people = personRepo.getPersonByCriteria(searchDto.getSearchField());
        }
        return people.stream().map((person)-> personMapper.toEntityDto(person,cityMapper.toEntityDto(person.getCity()))).collect(Collectors.toList());
    }
    
    public void addPerson(PersonDto person){
        personRepo.save(personMapper.toEntityDB(person));
    }
    
    public String deletePerson(String personId){
        try{
            personRepo.deleteById(personId);
            return "Person is successfully deleted1";
        } catch(Exception ex){
            return "Error! Person can not be deleted!";
        }
    }
    
    public PersonDto getPerson(String personId){
        Person p = personRepo.findById(personId).orElse(null);
        List<Person> people = new ArrayList<>();
        PersonDto person = personMapper.toEntityDto(p, cityMapper.toEntityDto(p.getCity()));
        people.add(p);
        return person;
    }
    
    public String updatePerson(PersonDto person){
        try{
            personRepo.save(personMapper.toEntityDB(person));
            return "Person has been successfully updated!";
        }catch(Exception ex){
            return "Error! Person can not be updated!";
        }
    }
    
}
