/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Department;
import com.comunidad.ad2.comunidad.repository.DepartmentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author jpmazate
 */
@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    
    @Mock
    private DepartmentRepository departmentRepository;  // es el mock

    @InjectMocks
    private DepartmentServiceImpl departmentService;
    
    public DepartmentServiceImplTest() {
    }
    
    /**
     * Test of findById method, of class DepartmentServiceImpl.
     */
    @Test
    void testFindById() {
        
        Integer idDepartamento = 1;
        Department expect = crearDepartamento();
        when(departmentRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.of(expect));
        
        Optional<Department> expResult = Optional.of(expect);
        Optional<Department> result = this.departmentService.findById(idDepartamento);
        assertEquals(expResult.get().getIdDepartamento(), result.get().getIdDepartamento());
        
    }

    /**
     * Test of findAll method, of class DepartmentServiceImpl.
     */
    @Test
    void testFindAll() {
       
        List<Department> list = obtenerDepartmentsList();
        when(departmentRepository.findAll()).thenReturn(list);
        Iterable<Department> expResult = list;
        Iterable<Department> result = this.departmentService.findAll();
        assertEquals(((List<Department> )expResult).size(),((List<Department> ) result).size());
         
    }
    
    public Department crearDepartamento(){
        return new Department(1, "Xela");
    }
    
    private List<Department> obtenerDepartmentsList (){
        List<Department> a = new ArrayList<Department>();
        for (int i = 0; i < 2; i++) {
            a.add(crearDepartamento());
        }
        return a;
    }
    
}
