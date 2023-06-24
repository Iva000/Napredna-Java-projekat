/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repo;

import com.example.demo.model.Pet;
import com.example.demo.model.Type;
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
    
    @Query(value="SELECT * FROM pet INNER JOIN type on pet.type = type.id WHERE pet.name LIKE '%:searchParam%'", nativeQuery = true)
    List<Pet> getPetByCriteria(@Param("searchParam") String searchParam);
    
    @Query(value="INSERT INTO pet(name, type, age, gender) values(:petName, :petType, :petAge, :petGender) INNER JOIN type on pet.type = type.id", nativeQuery=true)
    void addPet(@Param("petName") String petName, @Param("petType") Type petType,@Param("petAge") Integer petAge,@Param("petGender") String petGender);

    List<Pet> findByNameStartsWith(String name);
    
    List<Pet> findByStatus(int status);
}
