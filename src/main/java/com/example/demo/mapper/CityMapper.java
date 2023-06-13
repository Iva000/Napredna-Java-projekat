/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.mapper;

import com.example.demo.dto.CityDto;
import com.example.demo.model.City;
import com.example.demo.model.EntityDB;

/**
 *
 * @author Iva
 */
public class CityMapper implements IMapper<CityDto, City>{

    @Override
    public City toEntityDB(CityDto entityDto) {
        City c = new City();
        c.setId(entityDto.getId());
        c.setName(entityDto.getName());
        return c;
    }

    @Override
    public CityDto toEntityDto(City entityDB) {
        CityDto city = new CityDto();
        city.setId(entityDB.getId());
        city.setName(entityDB.getName());
        return city;
    }
    
}
