/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Course;
import java.util.Optional;

/**
 *
 * @author jesfrin
 */
public interface CourseService {
    
    public Optional<Course> findById(String codigoDeCurso);
    
}
