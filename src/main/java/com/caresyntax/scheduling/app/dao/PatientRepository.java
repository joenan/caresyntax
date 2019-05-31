/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caresyntax.scheduling.app.dao;

import com.caresyntax.scheduling.app.model.Patient;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Nandom Gusen
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select c from Patient c where c.name=?1")
    Optional<Patient> findPatientByName(String patientName);

    @Query("select c from Patient c where c.name LIKE ?1 OR c.sex=?1 OR c.dateOfBirth=?1")
    List<Patient> findBySearchValue(String searchValue);

}
