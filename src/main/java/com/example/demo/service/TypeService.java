/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.TypeDto;
import com.example.demo.mapper.TypeMapper;
import com.example.demo.model.Type;
import com.example.demo.repo.TypeRepo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;

/**
 *
 * @author Iva
 */
@Service
@Transactional
@RequiredArgsConstructor
public class TypeService {
    
    private final TypeRepo typeRepo;
    private final TypeMapper typeMapper;
    
    public List<TypeDto> aetAll(){
        List<Type> types = typeRepo.findAll();
        return types.stream().map((type)-> typeMapper.toEntityDto(type)).collect(Collectors.toList());
    }
}
