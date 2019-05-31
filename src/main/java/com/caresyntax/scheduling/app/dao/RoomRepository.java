/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caresyntax.scheduling.app.dao;

import com.caresyntax.scheduling.app.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nandom Gusen
 */
public interface RoomRepository extends JpaRepository<Room, Long>{
    
}
