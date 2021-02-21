/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.repository;

import com.comunidad.ad2.comunidad.entity.User;
import java.util.List;
import javax.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpmazate
 */

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    
    @Query("SELECT u FROM User u WHERE u.registroAcademico=?1 AND u.password=?2 AND u.estado='ACTIVO'")
    User userAuthentication(String registroAcademico,String password);
    
    /***
     * 
         @Query("SELECT u FROM User u WHERE u.registroAcademico=?1 AND u.password=2? AND u.estado='ACTIVO'")
        User userAuthentication(String registroAcademico,String password);
        
        */
     
    
}
