/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.PetDto;
import com.example.demo.mapper.PetMapper;
import com.example.demo.mapper.TypeMapper;
import com.example.demo.model.Pet;
import com.example.demo.repo.PetRepo;
import com.example.demo.repo.TypeRepo;
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
public class PetService {
    
    private final PetRepo petRepo;
    private final PetMapper petMapper;
    private final TypeRepo typeRepo;
    private final TypeMapper typeMapper;
    
    public List<PetDto> getAll(){
        List<Pet> pets = petRepo.findAll();
        return pets.stream().map((pet)-> petMapper.toEntityDto(pet, typeMapper.toEntityDto(pet.getType()))).collect(Collectors.toList());
    }
    
    public List<PetDto> searchPets(SearchRequest searchDto){
        List<Pet> pets;
        if(searchDto.getSearchField()==""){
            pets = petRepo.findAll();
        }else //if(searchDto.getSearchType().equals("Name"))
        {
            pets = petRepo.getPetByCriteria(searchDto.getSearchField());
        }
        return pets.stream().map((pet)-> petMapper.toEntityDto(pet, typeMapper.toEntityDto(pet.getType()))).collect(Collectors.toList());
    }
    
    public void addPet(PetDto pet){
        petRepo.save(petMapper.toEntityDB(pet));
    }
    
    public String deletePet(int petId){
        try{
            petRepo.deleteById(petId);
            return "Pet is successfully deleted1";
        } catch(Exception ex){
            return "Error! Pet can not be deleted!";
        }
    }
    
    public PetDto getPet(int petId){
        Pet p = petRepo.findById(petId).orElse(null);
        List<Pet> pets = new ArrayList<>();
        PetDto pet = petMapper.toEntityDto(p, typeMapper.toEntityDto(p.getType()));
        pets.add(p);
        return pet;
    }
    
    public String updatePet(PetDto pet){
        try{
            petRepo.save(petMapper.toEntityDB(pet));
            return "Pet has been successfully updated!";
        }catch(Exception ex){
            return "Error! Pet can not be updated!";
        }
    }
}   
