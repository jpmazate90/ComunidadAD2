/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.repository;

import com.comunidad.ad2.comunidad.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import javax.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
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
    
    @Transactional
    @Modifying
    @Query("UPDATE User u set u.password=?2 WHERE u.registroAcademico=?1")
    int changePasswordUser(String registroAcademico, String password);
    
    @Query("SELECT u FROM User u WHERE u.registroAcademico=?1 AND u.password=?2 AND u.estado='ACTIVO'")
    Optional<User> userAuthentication(String registroAcademico,String password);
    
    Optional<User> findByToken(String token);
    
    
    @Query("SELECT u FROM User u WHERE u.token=?1")
    Optional<User> findByOwnToken(String token);
    /***
     * 
         @Query("SELECT u FROM User u WHERE u.registroAcademico=?1 AND u.password=2? AND u.estado='ACTIVO'")
        User userAuthentication(String registroAcademico,String password);
        
        */
     
}
