/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Course;
import com.comunidad.ad2.comunidad.entity.Department;
import com.comunidad.ad2.comunidad.repository.CourseRepository;
import com.comunidad.ad2.comunidad.repository.DepartmentRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpmazate
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentRepository departmentRepository;
    
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Optional<Department> findById(Integer idDepartamento) {
        return this.departmentRepository.findById(idDepartamento);
    }

    @Override
    public Iterable<Department> findAll() {
        return this.departmentRepository.findAll();
    }

    
}
