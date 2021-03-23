/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.Department;
import com.comunidad.ad2.comunidad.service.DepartmentService;
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
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {
    
    @Mock
    private DepartmentService departmentService;
    
    @InjectMocks
    private DepartmentController departmentController;
    
    public DepartmentControllerTest() {
    }
    
    /**
     * Test of getDepartments method, of class DepartmentController.
     */
    @Test
    public void testGetDepartments() {
        System.out.println("getDepartments");
        DepartmentController instance = Mockito.spy(departmentController);
        Iterable<Department> listaDeDepartamentos = new ArrayList<>();
        Mockito.when(departmentService.findAll()).thenReturn(listaDeDepartamentos);
        
        ResponseEntity expResult = ResponseEntity.ok(listaDeDepartamentos);
        ResponseEntity result = instance.getDepartments();
        assertEquals(expResult, result);

    }
    
}
