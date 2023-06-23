/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.mapper;

import com.example.demo.dto.AdoptionDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.dto.PetDto;
import com.example.demo.model.Adoption;
import com.example.demo.model.City;
import com.example.demo.model.EntityDB;
import com.example.demo.model.Person;
import com.example.demo.model.Pet;
import com.example.demo.model.Type;
import org.springframework.stereotype.Component;

/**
 *
 * @author Iva
 */
@Component
public class AdoptionMapper implements IMapper<AdoptionDto, Adoption>{

    @Override
    public Adoption toEntityDB(AdoptionDto entityDto) {
        Adoption a = new Adoption();
        a.setAdoptionId(entityDto.getAdoptionId());
        a.setDate(entityDto.getDate());
        //a.setFirstTime(entityDto.isFirstTime());
        a.setVetReport(entityDto.getVetReport());
        a.setPetId(new Pet(entityDto.getPetId().getId(), entityDto.getPetId().getName(), entityDto.getPetId().getAge(), new Type(entityDto.getPetId().getType().getId(), entityDto.getPetId().getType().getName()), entityDto.getPetId().getDescription(), entityDto.getPetId().getGender()));
        a.setPersonId(new Person(entityDto.getPersonId().getJmbg(), entityDto.getPersonId().getName(), entityDto.getPersonId().getSurname(), entityDto.getPersonId().getYear_of_birth(), new City(entityDto.getPersonId().getCity().getId(), entityDto.getPersonId().getCity().getName()), entityDto.getPersonId().getPhone_number(), entityDto.getPersonId().getUsername(), entityDto.getPersonId().getPassword()));
        return a;
    }
    
     public Adoption toEntityDB(AdoptionDto entityDto, Pet pet, Person person) {
        Adoption a = new Adoption();
        a.setAdoptionId(entityDto.getAdoptionId());
        a.setDate(entityDto.getDate());
        //a.setFirstTime(entityDto.isFirstTime());
        a.setVetReport(entityDto.getVetReport());
        a.setPetId(new Pet(pet.getId(), pet.getName(), pet.getAge(), new Type(pet.getType().getId(), pet.getType().getName()), pet.getDescription(), pet.getGender()));
        a.setPersonId(new Person(person.getJmbg(), person.getName(), person.getSurname(), (int)person.getYear_of_birth(), new City(person.getCity().getId(), person.getCity().getName()), person.getPhone_number(), person.getUsername(), person.getPassword()));
        return a;
    }

    @Override
    public AdoptionDto toEntityDto(Adoption entityDB) {
//        AdoptionDto adoption = new AdoptionDto();
//        adoption.setAdoptionId(entityDB.getAdoptionId());
//        adoption.setDate(entityDB.getDate());
//        adoption.setFirstTime(entityDB.isFirstTime());
//        adoption.setVetReport(entityDB.getVetReport());
//        adoption.setPetId(entityDB.getPetId());
//        adoption.setPersonId(entityDB.getPersonId());
        return null;
    }
    
        public AdoptionDto toEntityDto(Adoption entityDB, PetDto petDto, PersonDto personDto) {
          AdoptionDto adoption = new AdoptionDto();
          adoption.setAdoptionId(entityDB.getAdoptionId());
          adoption.setDate(entityDB.getDate());
          //adoption.setFirstTime(entityDB.isFirstTime());
          adoption.setVetReport(entityDB.getVetReport());
          adoption.setPetId(petDto);
          adoption.setPersonId(personDto);
          return adoption;
        }
}
