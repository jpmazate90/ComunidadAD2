/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jesfrin
 */
@CrossOrigin()
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/getCourses")
    public ResponseEntity<?> getCourses(User user) {
        return ResponseEntity.ok(this.courseService.findAll());
    }

}
