/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repo;

import com.example.demo.model.Adoption;
import com.example.demo.model.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Iva
 */
public interface AdoptionRepo extends JpaRepository<Adoption, Integer>{
    
    @Query(value="SELECT * FROM adoption ", nativeQuery = true)
//            + "INNER JOIN PET ON ADOPTION.PETID = PET.ID INNER JOIN PERSON ON ADOPTION.PERSONID = PERSON.JMBG "
//            + "INNER JOIN TYPE ON PET.TYPE = TYPE.ID "
    List<Adoption> getAllAdoptions();
    
    List<Adoption> findByPersonId(Person person);
    
    List<Adoption> findByStatus(int status);
}
