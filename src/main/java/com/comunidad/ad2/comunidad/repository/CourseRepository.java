/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.repository;

import com.comunidad.ad2.comunidad.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jesfrin
 */
public interface CourseRepository extends JpaRepository<Course,String>{
    
}
