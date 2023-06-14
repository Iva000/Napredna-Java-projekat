/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.CityDto;
//import com.example.demo.mapper.CityMapper;
import com.example.demo.mapper.CityMapper;
import com.example.demo.model.City;
import com.example.demo.repo.CityRepo;
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
public class CityService {
    
    private final CityRepo cityRepo;
    private final CityMapper cityMapper;
    
    public List<CityDto> getAll(){
        List<City> cities = cityRepo.findAll();
        return cities.stream().map((city)-> cityMapper.toEntityDto(city)).collect(Collectors.toList());
    }
    
}
