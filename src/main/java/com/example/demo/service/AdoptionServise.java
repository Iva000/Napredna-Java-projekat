/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.AdoptionDto;
import com.example.demo.mapper.AdoptionMapper;
import com.example.demo.model.Adoption;
import com.example.demo.repo.AdoptionRepo;
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
    
    public List<AdoptionDto> getAll(){
        List<Adoption> adoptions = adoptionRepo.findAll();
        return adoptions.stream().map((adoption)-> adoptionMapper.toEntityDto(adoption)).collect(Collectors.toList());
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
        AdoptionDto adoption = adoptionMapper.toEntityDto(a);
        adoptions.add(a);
        return adoption;
    }
    
    public String updateAdoption(AdoptionDto adoption){
        try{
            adoptionRepo.save(adoptionMapper.toEntityDB(adoption));
            return "Adoption has been successfully updated!";
        }catch(Exception ex){
            return "Error! Adoption can not be updated!";
        }
    }
}
