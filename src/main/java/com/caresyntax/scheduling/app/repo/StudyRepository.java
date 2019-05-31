/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caresyntax.scheduling.app.repo;

import com.caresyntax.scheduling.app.model.Study;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nandom Gusen
 */
public interface StudyRepository extends JpaRepository<Study, Long> {
    
    Optional<Study> findByPatient_PatientId(long id);

}
