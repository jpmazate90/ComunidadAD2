/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.repository;

import com.comunidad.ad2.comunidad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpmazate
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    
    
}
