/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.ValorationPost;
import com.comunidad.ad2.comunidad.service.ValorationPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jesfrin
 */
@CrossOrigin()
@RestController
public class ValorationPostController {
    
    private ValorationPostService valorationPostService;
    
    @Autowired
    public ValorationPostController(ValorationPostService valorationPostService){
        this.valorationPostService = valorationPostService;
    }
    
    public ResponseEntity<ValorationPost> create(@RequestBody ValorationPost valorationPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.valorationPostService.save(valorationPost));
    } 
    
}
