/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.TokenCreated;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.UserRepository;
import com.comunidad.ad2.comunidad.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpmazate
 */
@CrossOrigin()
@RestController
public class TokenController {
    
    @Autowired
    private UserService userService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody User user){//Metodo al que se llama cuando se inicia sesion y actualiza el token en la base de datos si encuentra al usuario
       String token= userService.login(user.getRegistroAcademico(),user.getPassword());
       if(StringUtils.isEmpty(token)){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR, USUARIO O CONTRASENA INVALIDO");
       }
       return ResponseEntity.status(HttpStatus.CREATED).body(new TokenCreated(token));  
    }
    
    @Autowired
    public TokenController(UserService userService){
        this.userService = userService;
    }
    
    
    
}
