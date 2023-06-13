/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.mapper;

import com.example.demo.dto.EntityDto;
import com.example.demo.model.EntityDB;

/**
 *
 * @author Iva
 */
public interface IMapper <Dto extends EntityDto, DB extends EntityDB>{
    
	public DB toEntityDB(Dto entityDto);

	public Dto toEntityDto(DB entityDB);

}
