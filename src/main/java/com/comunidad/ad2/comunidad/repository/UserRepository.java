/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.repository;

import com.comunidad.ad2.comunidad.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpmazate
 */

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    
    @Transactional
    @Modifying
    @Query("UPDATE User u set u.estado='ACTIVO' WHERE u.registroAcademico=?1 AND u.estado='EN_ESPERA'")
    int adminCreation(String registroAcademico);
    
}
