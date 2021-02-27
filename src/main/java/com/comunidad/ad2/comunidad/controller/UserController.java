/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.encriptacion.Hash;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.UserService;
import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import java.sql.Timestamp;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpmazate
 */
@CrossOrigin()
@RestController
//@RequestMapping("/api/users")
public class UserController {

    //@ComponentScan("com.comunidad.ad2.comunidad.service")
    private UserService userService;
    
    private TokenController tokenController;
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        if (userService.findById(user.getRegistroAcademico()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("YA EXISTE EL USUARIO");
        }
    }

    @PostMapping("/api/users/authentication")
    public ResponseEntity<?> authentication(@RequestBody User user) {//Recibe un user, donde se incluira el registro academico y el usuario
        //Este user trae el registroAcademico y la contrasenia
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.userAuthentication(user.getRegistroAcademico(), user.getPassword()));

    }

    @PostMapping("/api/users/adminCreation")
    public ResponseEntity<?> adminCreation(@RequestBody User user) {//Recibe un user, donde se incluira el registro academico y el usuario
        //Este user trae el registroAcademico y el estado
        System.out.println("********************/*********************/*********************\n\n\n\n\n\n\n");
        System.out.println("user" + user.getRegistroAcademico());
        System.out.println("********************/*********************/*********************\n\n\n\n\n\n\n");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.adminCreation(user.getRegistroAcademico()));
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") String userId) {
        Optional<User> oUser = userService.findById(userId);
        if (!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);
    }

    @GetMapping("/api/users/accounts")
    public Iterable<?> all() {
        return userService.findAll();
    }

    public UserController(@Autowired UserService userService, @Autowired TokenController tokenController) {
        this.userService = userService;
        this.tokenController = tokenController;
    }

}
