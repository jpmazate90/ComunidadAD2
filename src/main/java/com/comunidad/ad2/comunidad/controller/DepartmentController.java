/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.Department;
import com.comunidad.ad2.comunidad.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpmazate
 */
@CrossOrigin()
@RestController
public class DepartmentController {
     @Autowired
    private DepartmentService departmentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get/department/getDepartments")
    public ResponseEntity<Iterable<Department>> getDepartments() {
        return ResponseEntity.ok(this.departmentService.findAll());
    }

    /**
     *
     * SOLO CON GET
     *
     * @CrossOrigin(origins = "http://localhost:4200")
     * @PostMapping("/getCourses") public ResponseEntity<?> getCourses() {
     * return ResponseEntity.ok(this.courseService.findAll()); }
     *
     *
     */
}
