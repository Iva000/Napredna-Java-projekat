/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.AdoptionDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.mapper.AdoptionMapper;
import com.example.demo.mapper.CityMapper;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.mapper.PetMapper;
import com.example.demo.mapper.TypeMapper;
import com.example.demo.model.Adoption;
import com.example.demo.model.Person;
import com.example.demo.repo.AdoptionRepo;
import com.example.demo.repo.PersonRepo;
import com.example.demo.repo.PetRepo;
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
public class AdoptionServise {
    
    public final AdoptionRepo adoptionRepo;
    public final AdoptionMapper adoptionMapper;
    public final PetRepo petRepo;
    public final PetMapper petMapper;
    public final PersonRepo personRepo;
    public final PersonMapper personMapper;
    public final TypeMapper typeMapper;
    public final CityMapper cityMapper;
    
    public List<AdoptionDto> getAll(){
        List<Adoption> adoptions = adoptionRepo.findAll();
        return adoptions.stream().map((adoption)-> adoptionMapper.toEntityDto(adoption, petMapper.toEntityDto(adoption.getPetId(), typeMapper.toEntityDto(adoption.getPetId().getType())), personMapper.toEntityDto(adoption.getPersonId(), cityMapper.toEntityDto(adoption.getPersonId().getCity())))).collect(Collectors.toList());
    }
    
    public List<AdoptionDto> getPersonsAdoptions(PersonDto person){
        List<Adoption> adoptions = adoptionRepo.findByPersonId(personMapper.toEntityDB(person));
        return adoptions.stream().map((adoption)-> adoptionMapper.toEntityDto(adoption, petMapper.toEntityDto(adoption.getPetId(), typeMapper.toEntityDto(adoption.getPetId().getType())), personMapper.toEntityDto(adoption.getPersonId(), cityMapper.toEntityDto(adoption.getPersonId().getCity())))).collect(Collectors.toList());
    }
    
    public List<AdoptionDto> getAdoptionStatus(int status){
        List<Adoption> adoptions = adoptionRepo.findByStatus(status);
        return adoptions.stream().map((adoption)-> adoptionMapper.toEntityDto(adoption, petMapper.toEntityDto(adoption.getPetId(), typeMapper.toEntityDto(adoption.getPetId().getType())), personMapper.toEntityDto(adoption.getPersonId(), cityMapper.toEntityDto(adoption.getPersonId().getCity())))).collect(Collectors.toList());
    }
    
    public void addAdoption(AdoptionDto adoption){
        adoptionRepo.save(adoptionMapper.toEntityDB(adoption));
    }
    
    public String deleteAdoption(int adoptionId){
        try{
            adoptionRepo.deleteById(adoptionId);
            return "Adoption is successfully deleted1";
        } catch(Exception ex){
            return "Error! Adoption can not be deleted!";
        }
    }
    
    public AdoptionDto getAdoption(int adoptionId){
        Adoption a = adoptionRepo.findById(adoptionId).orElse(null);
        List<Adoption> adoptions = new ArrayList<>();
        AdoptionDto adoption = adoptionMapper.toEntityDto(a, petMapper.toEntityDto(a.getPetId(), typeMapper.toEntityDto(a.getPetId().getType())), personMapper.toEntityDto(a.getPersonId(), cityMapper.toEntityDto(a.getPersonId().getCity())));
        adoptions.add(a);
        return adoption;
    }
    
    public String updateAdoption(AdoptionDto adoption){
        try{
            adoptionRepo.save(adoptionMapper.toEntityDB(adoption, petMapper.toEntityDB(adoption.getPetId(), typeMapper.toEntityDB(adoption.getPetId().getType())), personMapper.toEntityDB(adoption.getPersonId(), cityMapper.toEntityDB(adoption.getPersonId().getCity()))));
            return "Adoption has been successfully updated!";
        }catch(Exception ex){
            return "Error! Adoption can not be updated!";
        }
    }
    
}
