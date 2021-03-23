/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.Course;
import com.comunidad.ad2.comunidad.service.CourseService;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {
    
    @Mock
    private CourseService courseService;
      
    @InjectMocks
    private CourseController courseController;        
    
    /**
     * Test of getCourses method, of class CourseController.
     */
    @Test
    public void testGetCourses() {
        System.out.println("getCourses");
        CourseController instance = Mockito.spy(courseController);
        Iterable<Course> listaCursos = new ArrayList<>();
        Mockito.when(courseService.findAll()).thenReturn(listaCursos);

        ResponseEntity expResult = ResponseEntity.ok(listaCursos);
        ResponseEntity result = instance.getCourses();
        assertEquals(expResult, result);

    }
    
}
