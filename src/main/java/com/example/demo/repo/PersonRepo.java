/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repo;

import com.example.demo.model.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author Iva
 */
public interface PersonRepo extends JpaRepository<Person, String>{
    
    @Query(value="SELECT * FROM person INNER JOIN city on person.city = city.id", nativeQuery = true)
    List<Person> getAllPeople();
    
    @Query(value="SELECT * FROM person INNER JOIN city on person.city = city.id WHERE jmbg=: personJmbg", nativeQuery = true)
    List<Person> getPerson(@Param("personJmbg") String personJmbg);
    
    @Query(value="SELECT * FROM person INNER JOIN type on city on person.city = city.id WHERE person.surname like '%:searchParam%'", nativeQuery = true)
    List<Person> getPersonByCriteria(@Param("searchParam") String searchParam);
    
    List<Person> findBySurnameStartsWith(String name);
    
    void deleteByJmbg(String jmbg);
    
    Person findByUsername(String username);
}
