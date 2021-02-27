/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    
    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
       String token= userService.login(username,password);
       if(StringUtils.isEmpty(token)){
           return ResponseEntity.status(HttpStatus.CREATED).body("NO TOKEN FOUND");
       }
       return ResponseEntity.status(HttpStatus.CONFLICT).body(token);
       
    }
    
    
}
