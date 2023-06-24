/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.mapper;

import com.example.demo.dto.PetDto;
import com.example.demo.dto.TypeDto;
import com.example.demo.model.EntityDB;
import com.example.demo.model.Pet;
import com.example.demo.model.Type;
import org.springframework.stereotype.Component;

/**
 *
 * @author Iva
 */
@Component
public class PetMapper implements IMapper<PetDto, Pet>{

    @Override
    public Pet toEntityDB(PetDto entityDto) {
        Pet p = new Pet();
        p.setId(entityDto.getId());
        p.setName(entityDto.getName());
        p.setAge(entityDto.getAge());
        p.setType(new Type(entityDto.getType().getId(), entityDto.getType().getName()));
        p.setDescription(entityDto.getDescription());
        p.setGender(entityDto.getGender());
        p.setStatus(entityDto.getStatus());
        return p;
    }
    
    public Pet toEntityDB(PetDto entityDto, Type type){
        Pet p = new Pet();
        p.setId(entityDto.getId());
        p.setName(entityDto.getName());
        p.setAge((int)entityDto.getAge());
        System.out.println("iz mappera tip je: "+ entityDto.getType().getName()+ " tip: "+ type.getName());
        p.setType(new Type((int)type.getId(), type.getName()));
        p.setDescription(entityDto.getDescription());
        p.setGender(entityDto.getGender());
        p.setStatus(entityDto.getStatus());
        return p;
    }

    @Override
    public PetDto toEntityDto(Pet entityDB) {
        return null;
    }
    
    public PetDto toEntityDto(Pet entityDB, TypeDto typeDto) {
        PetDto pet = new PetDto();
        pet.setId(entityDB.getId());
        pet.setName(entityDB.getName());
        pet.setAge(entityDB.getAge());
        pet.setType(typeDto);
        pet.setDescription(entityDB.getDescription());
        pet.setGender(entityDB.getGender());
        pet.setStatus(entityDB.getStatus());
        return pet;
    }
    
}
