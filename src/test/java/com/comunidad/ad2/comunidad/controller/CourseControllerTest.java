/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.Course;
import com.comunidad.ad2.comunidad.entity.Department;
import com.comunidad.ad2.comunidad.service.CourseService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jpmazate
 */
@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {
    @Mock
    private CourseService courseService;
    @InjectMocks
    private CourseController courseController;

    
    public CourseControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCourses method, of class CourseController.
     */
    @Test
    public void testGetCourses() {
        List<Course> lista = listaCursos();
        
        ResponseEntity expResult = ResponseEntity.ok(lista);
        ResponseEntity result = this.courseController.getCourses();
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
    
    
    
    private Course crearCurso(){
        return new Course("1", "Mate 1",3);
    }
    
    private List<Course> listaCursos(){
        List<Course> lista = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            lista.add(crearCurso());
        }
        return lista;
    }
    
}
