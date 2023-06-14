/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.mapper;

import com.example.demo.dto.AdoptionDto;
import com.example.demo.model.Adoption;
import com.example.demo.model.EntityDB;
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
        a.setFirstTime(entityDto.isFirstTime());
        a.setVetReport(entityDto.getVetReport());
        a.setPetId(entityDto.getPetId());
        a.setPersonId(entityDto.getPersonId());
        return a;
    }

    @Override
    public AdoptionDto toEntityDto(Adoption entityDB) {
        AdoptionDto adoption = new AdoptionDto();
        adoption.setAdoptionId(entityDB.getAdoptionId());
        adoption.setDate(entityDB.getDate());
        adoption.setFirstTime(entityDB.isFirstTime());
        adoption.setVetReport(entityDB.getVetReport());
        adoption.setPetId(entityDB.getPetId());
        adoption.setPersonId(entityDB.getPersonId());
        return adoption;
    }
    
}
