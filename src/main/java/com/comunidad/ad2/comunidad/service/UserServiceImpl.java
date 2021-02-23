/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.encriptacion.Hash;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpmazate
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<User> findAll() {
        
        return userRepository.findAll();
        
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(String registroAcademico) {
        return userRepository.findById(registroAcademico);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

//    @Override
//    @Transactional
//    public void deleteById(Long id) {
//        userRepository.deleteById(id);
//    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User userAuthentication(String registroAcademico,String password) {
        return userRepository.userAuthentication(registroAcademico,Hash.md5(password));
    }
    
    
}
