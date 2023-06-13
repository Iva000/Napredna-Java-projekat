/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.mapper;

import com.example.demo.dto.TypeDto;
import com.example.demo.model.EntityDB;
import com.example.demo.model.Type;

/**
 *
 * @author Iva
 */
public class TypeMapper implements IMapper<TypeDto, Type>{

    @Override
    public Type toEntityDB(TypeDto entityDto) {
        Type t = new Type();
        t.setId(entityDto.getId());
        t.setName(entityDto.getName());
        return t;
    }

    @Override
    public TypeDto toEntityDto(Type entityDB) {
        TypeDto type = new TypeDto();
        type.setId(entityDB.getId());
        type.setName(entityDB.getName());
        return type;
    }
    
}
