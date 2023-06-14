/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.mapper;

import com.example.demo.dto.CityDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.model.City;
import com.example.demo.model.EntityDB;
import com.example.demo.model.Person;
import org.springframework.stereotype.Component;

/**
 *
 * @author Iva
 */
@Component
public class PersonMapper implements IMapper<PersonDto, Person>{

    @Override
    public Person toEntityDB(PersonDto entityDto) {
        Person p = new Person();
        p.setJmbg(entityDto.getJmbg());
        p.setName(entityDto.getName());
        p.setSurname(entityDto.getSurname());
        p.setYear_of_birth(entityDto.getYear_of_birth());
        p.setCity(new City(entityDto.getCity().getId(), entityDto.getCity().getName()));
        p.setPhone_number(entityDto.getPhone_number());
        return p;
    }

    @Override
    public PersonDto toEntityDto(Person entityDB) {
//        PersonDto person = new PersonDto();
//        person.setJmbg(entityDB.getJmbg());
//        person.setName(entityDB.getName());
//        person.setSurname(entityDB.getSurname());
//        person.setYear_of_birth(entityDB.getYear_of_birth());
//        person.setCity(entityDB.getCity());
//        person.setPhone_number(entityDB.getPhone_number());
//        return person;
            return null;
    }
    
    public PersonDto toEntityDto(Person entityDB, CityDto cityDto) {
        PersonDto person = new PersonDto();
        person.setJmbg(entityDB.getJmbg());
        person.setName(entityDB.getName());
        person.setSurname(entityDB.getSurname());
        person.setYear_of_birth(entityDB.getYear_of_birth());
        person.setCity(cityDto);
        person.setPhone_number(entityDB.getPhone_number());
        return person;
    }
    
}
