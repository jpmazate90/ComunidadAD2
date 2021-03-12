/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Course;
import com.comunidad.ad2.comunidad.entity.Department;
import java.util.Optional;

/**
 *
 * @author jpmazate
 */
public interface DepartmentService {
    public Optional<Department> findById(Integer idDepartamento);
    
    public Iterable<Department> findAll();
}
