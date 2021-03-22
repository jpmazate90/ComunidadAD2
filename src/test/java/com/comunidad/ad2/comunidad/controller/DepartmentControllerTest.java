/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.Department;
import com.comunidad.ad2.comunidad.repository.UserRepository;
import com.comunidad.ad2.comunidad.service.DepartmentService;
import com.comunidad.ad2.comunidad.service.UserServiceImpl;
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
public class DepartmentControllerTest {
    
    @Mock
    private DepartmentService departmentService;  // es el mock

    @InjectMocks
    private DepartmentController departmentController;
    
    public DepartmentControllerTest() {
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
     * Test of getDepartments method, of class DepartmentController.
     */
    @Test
    public void testGetDepartments() {  
        List<Department> lista = listaDepartamentos();
        when(this.departmentService.findAll()).thenReturn(lista);
        ResponseEntity expResult = ResponseEntity.ok(lista);
        ResponseEntity result = this.departmentController.getDepartments();
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
        
    }
    
    
    private Department crearDepartamento(){
        return new Department(1, "Xela");
    }
    
    private List<Department> listaDepartamentos(){
        List<Department> lista = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            lista.add(crearDepartamento());
        }
        return lista;
    }
    
}
