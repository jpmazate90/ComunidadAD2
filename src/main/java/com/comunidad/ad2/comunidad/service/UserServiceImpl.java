/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosProfile;
import com.comunidad.ad2.comunidad.controllImage.DibujadorDeImagenesEnDisco;
import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.encriptacion.Hash;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.UserRepository;
import java.util.List;
import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jpmazate
 */
@Service
public class UserServiceImpl implements UserService {

    private final int SEIS_HORAS = 21600000;
    public final String NOT_VALUE = " *";

    private UserRepository userRepository;
    private CreadorDeDirectoriosProfile creadorDeDirectoriosProfile;
    private DibujadorDeImagenesEnDisco dibujadorDeImagenes;
    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.creadorDeDirectoriosProfile = new CreadorDeDirectoriosProfile();
        this.dibujadorDeImagenes = new DibujadorDeImagenesEnDisco();
        this.recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
    }

    @Override
    public Iterable<User> findAll() {
        List<User> users = new LinkedList<>();
        users.addAll(this.userRepository.findAll());
        for (User user : users) {
            addUserProfileImage(user);
        }
        return users;
    }

     

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(String registroAcademico) {
        return userRepository.findById(registroAcademico);
    }

    @Override
    @Transactional
    public User save(User user) {
        user.setFechaDeNacimiento(formatearFecha(user));
        user.setPassword(hashearContrasena(user)); // mock
        asignarEstado(user); // ver super o comunidad
        return userRepository.save(user); // mock
    }


    

    @Override
    @Modifying
    public int adminCreation(String registroAcademico) {
        return userRepository.adminCreation(registroAcademico); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @Modifying
    public int changePasswordUser(String registroAcademico, String password) {
        return userRepository.changePasswordUser(registroAcademico, Hash.md5(password)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User userAuthentication(String registroAcademico, String password) {
        return userRepository.userAuthentication(registroAcademico, Hash.md5(password)).get();
    }

    @Override
    public String login(String username, String password) {
        Optional<User> user = userRepository.userAuthentication(username, Hash.md5(password));
        if (user.isPresent()) {
            String token = UUID.randomUUID().toString();
            User datosUser = user.get();
            datosUser.setToken(token);
            userRepository.save(datosUser);
            return token;
        }

        return StringUtils.EMPTY;
    }

    public Timestamp formatearFecha(User user) {
        Timestamp time = new Timestamp(user.getFechaDeNacimiento().getTime() + SEIS_HORAS);
        return time;
    }

    @Override
    public String hashearContrasena(User user) {
        String contrasena = Hash.md5(user.getPassword());
        return contrasena;

    }

    @Override
    public void asignarEstado(User user) {
        if (user.getRolUsuario() == RolUsuario.COMUNIDAD) {
            user.setEstado(EstadoUsuario.EN_ESPERA);
        } else if (user.getRolUsuario() == RolUsuario.SUPER) {
            user.setEstado(EstadoUsuario.EN_ESPERA);
        }
    }

    @Override
    public Optional<org.springframework.security.core.userdetails.User> findByToken(String token) {
        Optional<User> customer = userRepository.findByToken(token);
        if (customer.isPresent()) {
            User ownUser = customer.get();
            org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(ownUser.getRegistroAcademico(), ownUser.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByTokenOwnUser(String token) {
        Optional<User> user = userRepository.findByOwnToken(token);
        if(user.isPresent()){
            addUserProfileImage(user.get());
        }
        return user;
    }

    @Override
    public User actualizarDatosUser(User user) {
        User response = userRepository.save(user);
        return addUserProfileImage(response);
    }

    @Override
    public Iterable<User> filtrarUsuarios(String carnet) {
//    return null;
        return userRepository.filtrarUsuarios(carnet);
    }

    @Override
    public Iterable<User> getByFiltering(User user) {
        user.setRegistroAcademico(user.getRegistroAcademico().trim());
        user.setNombreCompleto(user.getNombreCompleto().trim());
        user.setCorreoElectronico(user.getCorreoElectronico().trim());
        if(user.getRegistroAcademico().isEmpty())
            user.setRegistroAcademico(NOT_VALUE);
        if(user.getNombreCompleto().isEmpty())
            user.setNombreCompleto(NOT_VALUE);
        if(user.getCorreoElectronico().isEmpty())
            user.setCorreoElectronico(NOT_VALUE);
        System.out.println(":::::::::::: Registro: " + user.getRegistroAcademico() + ", Nombre: " + user.getNombreCompleto() + "Correo: " + user.getCorreoElectronico());
        List<User> users = new LinkedList<>();
        users.addAll(this.userRepository.getUsersByFiltering(user.getRegistroAcademico(), user.getNombreCompleto(), user.getCorreoElectronico()));
        for (User usr : users) {
            addUserProfileImage(usr);
        }
        return users;
//        return userRepository.getUsersByFiltering(user.getRegistroAcademico(), user.getNombreCompleto(), user.getCorreoElectronico());
    }

    @Override
    public Iterable<User> getUsersBySearch(String searchText) {
        return userRepository.getUsersBySearch(searchText);
    }

    @Override
    public User guardarImagen(MultipartFile file) throws IOException {
        User usr = new User();
        System.out.println("Resultado:::: " + this.creadorDeDirectoriosProfile.createDirectory()); 
        Path pathImage = this.creadorDeDirectoriosProfile.getPathOfImage(file.getOriginalFilename());
        System.out.println("PATH::: " + pathImage.toAbsolutePath());
        this.dibujadorDeImagenes.dibujarImagen(file.getBytes(), pathImage);
        usr.setFotoDePerfil(pathImage.toString());
        return usr;
    }

    public User addUserProfileImage(User usr){
        String foto;
        byte[] datosFoto;
        if(usr.getFotoDePerfil() != null){
            foto = usr.getFotoDePerfil();
            datosFoto = this.recuperadorDeImagenesDeDisco.recuperarBytesDeImagen(foto);
            usr.setDatosFoto(datosFoto);
        }
        return usr;
    }
    
}
