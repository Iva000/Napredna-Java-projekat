/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.mapper;

import com.example.demo.dto.PetDto;
import com.example.demo.model.EntityDB;
import com.example.demo.model.Pet;

/**
 *
 * @author Iva
 */
public class PetMapper implements IMapper<PetDto, Pet>{

    @Override
    public Pet toEntityDB(PetDto entityDto) {
        Pet p = new Pet();
        p.setId(entityDto.getId());
        p.setName(entityDto.getName());
        p.setAge(entityDto.getAge());
        p.setType(entityDto.getType());
        p.setDescription(entityDto.getDescription());
        p.setGender(entityDto.getGender());
        return p;
    }

    @Override
    public PetDto toEntityDto(Pet entityDB) {
        PetDto pet = new PetDto();
        pet.setId(entityDB.getId());
        pet.setName(entityDB.getName());
        pet.setAge(entityDB.getAge());
        pet.setType(entityDB.getType());
        pet.setDescription(entityDB.getDescription());
        pet.setGender(entityDB.getGender());
        return pet;
    }
    
}
