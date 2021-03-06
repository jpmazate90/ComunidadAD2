/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jpmazate
 */
public interface UserService {
    
    public Iterable<User> findAll();
    
    public Page<User> findAll(Pageable pageable);
    
    public Optional<User> findById(String registroAcademico);
    
    public User save(User user);
    
    public void deleteById(Long id);
    
}
