/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repo;

import com.example.demo.model.Pet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Iva
 */
public interface PetRepo extends JpaRepository<Pet, Integer>{
    
    @Query(value="SELECT * FROM pet INNER JOIN type on pet.type = type.id", nativeQuery = true)
    List<Pet> getAllPets();
    
    @Query(value="SELECT * FROM pet INNER JOIN type on pet.type = type.id WHERE id=: petId", nativeQuery = true)
    List<Pet> getPet(@Param("petId") Integer petId);
    
    @Query(value="SELECT * FROM pet INNER JOIN type on pet.type = type.id WHERE pet.name like '%:searchParam%'", nativeQuery = true)
    List<Pet> getPetByCriteria(@Param("searchParam") String searchParam);
}
