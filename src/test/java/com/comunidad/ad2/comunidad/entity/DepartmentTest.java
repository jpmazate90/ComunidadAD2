/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jesfrin
 */
public class DepartmentTest {

    public static final String NOMBRE_DEPARTAMENTO = "Guatemala";
    public static final Integer ID_DEPARTAMENTO = 5;
    private Department department;

    public DepartmentTest() {
        this.department = new Department(ID_DEPARTAMENTO, NOMBRE_DEPARTAMENTO);
    }

    /**
     * Test of getIdDepartamento method, of class Department.
     */
    @Test
    public void testGetIdDepartamento() {
        //Act
        System.out.println("getIdDepartamento");
        Department instance = this.department;
        //Arrange
        Integer expResult = ID_DEPARTAMENTO;
        Integer result = instance.getIdDepartamento();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdDepartamento method, of class Department.
     */
    @Test
    public void testSetIdDepartamento() {
        //Act
        System.out.println("setIdDepartamento");
        Department instance = this.department;
        Integer nuevoId = 8;
        //Arrange
        instance.setIdDepartamento(nuevoId);
        Integer expResult = nuevoId;
        Integer result = instance.getIdDepartamento();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class Department.
     */
    @Test
    public void testGetNombre() {
        //Act
        System.out.println("getNombre");
        Department instance = this.department;
        //Arrange
        String expResult = NOMBRE_DEPARTAMENTO;
        String result = instance.getNombre();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setNombre method, of class Department.
     */
    @Test
    public void testSetNombre() {
        //Act
        System.out.println("setNombre");
        Department instance = this.department;
        String nuevoNombreDepartamento = "Quetzaltenango";
        //Arrange
        instance.setNombre(nuevoNombreDepartamento);
        String expResult = nuevoNombreDepartamento;
        String result = instance.getNombre();
        //Assert
        assertEquals(expResult, result);

    }

    @Test
    public void testConstructorInteger() {
        //Act
        System.out.println("Test constructor Integer");
        Department department = new Department(ID_DEPARTAMENTO);
        //Assert
        Integer expResult = ID_DEPARTAMENTO;
        Integer result = department.getIdDepartamento();
        //Arrange
        assertEquals(expResult, result);
    }

}
