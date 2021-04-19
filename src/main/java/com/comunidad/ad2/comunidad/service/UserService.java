/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.User;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jpmazate
 */
public interface UserService {
    
    public Iterable<User> findAll();
    
    public Optional<User> findById(String registroAcademico);
    
    public User save(User user);
    
    public int adminCreation(String registroAcademico);
    
    public int changePasswordUser(String registroAcademico, String password);

    public User userAuthentication(String registroAcademico,String password);

    public Timestamp formatearFecha(User user);
    
    public String hashearContrasena(User user);
    
    public void asignarEstado(User user);
    
    public String login(String username, String password) ;
    
    public Optional<org.springframework.security.core.userdetails.User> findByToken(String token);
    
    public Optional<User> findByTokenOwnUser(String token);
    
    public User actualizarDatosUser(User user);
    
    public Iterable<User> getByFiltering(User user);

    public Iterable<User> getUsersBySearch(String searchText);
    
    public Iterable<User> filtrarUsuarios(String carnet);
    
    public User guardarImagen(MultipartFile file) throws IOException;
    
}
