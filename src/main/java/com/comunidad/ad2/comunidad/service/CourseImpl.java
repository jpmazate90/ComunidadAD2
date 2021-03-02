/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Course;
import com.comunidad.ad2.comunidad.repository.CourseRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jesfrin
 */
public class CourseImpl implements CourseService{
    
    private CourseRepository courseRepository;
    
    @Autowired
    public CourseImpl(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    @Override
    public Optional<Course> findById(String codigoDeCurso) {
        return this.courseRepository.findById(codigoDeCurso);
    }
}
