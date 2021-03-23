/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author jesfrin
 */
public class ComunityTest {

    public Comunity comunidad;
    public Course course;

    public ComunityTest() {
        this.course = new Course("001", "MATEMATICA", 0);
        this.comunidad = new Comunity(1, course, "Primera Comunidad", "Descripcion comunidad", "/direccion/foto");
    }

    /**
     * Test of getId method, of class Comunity.
     */
    @Test
    public void testGetId() {
        //Arrange 
        System.out.println("getId");
        Comunity instance = this.comunidad;
        //Act
        int expResult = 1;
        int result = instance.getId();
        //Asert
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class Comunity.
     */
    @Test
    public void testSetId() {
        //Arrange
        System.out.println("setId");
        Comunity instance = this.comunidad;
        int nuevoId=5;
        //Act
        instance.setId(nuevoId);
        int expResult = nuevoId;
        int result = instance.getId();
        //Asset
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourse method, of class Comunity.
     */
    @Test
    public void testGetCourse() {
        //Act
        System.out.println("getCourse");
        Comunity instance = this.comunidad;
        //Arrange
        Course expResult = this.course;
        Course result = instance.getCourse();
        //Asset
        assertEquals(expResult.getCodigoDeCurso(), result.getCodigoDeCurso());
        // TODO review the generated test code and remove the default call to fail.
    }

//    /**
//     * Test of setCourse method, of class Comunity.
//     */
//    @Test
//    public void testSetCourse() {
//        //Act
//        //Arrange
//        //Assert 
//        System.out.println("setCourse");
//        Course course = null;
//        Comunity instance = new Comunity();
//        instance.setCourse(course);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of getNombre method, of class Comunity.
//     */
//    @Test
//    public void testGetNombre() {
//        System.out.println("getNombre");
//        Comunity instance = new Comunity();
//        String expResult = "";
//        String result = instance.getNombre();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNombre method, of class Comunity.
//     */
//    @Test
//    public void testSetNombre() {
//        System.out.println("setNombre");
//        String nombre = "";
//        Comunity instance = new Comunity();
//        instance.setNombre(nombre);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDescripcion method, of class Comunity.
//     */
//    @Test
//    public void testGetDescripcion() {
//        System.out.println("getDescripcion");
//        Comunity instance = new Comunity();
//        String expResult = "";
//        String result = instance.getDescripcion();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDescripcion method, of class Comunity.
//     */
//    @Test
//    public void testSetDescripcion() {
//        System.out.println("setDescripcion");
//        String descripcion = "";
//        Comunity instance = new Comunity();
//        instance.setDescripcion(descripcion);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFoto method, of class Comunity.
//     */
//    @Test
//    public void testGetFoto() {
//        System.out.println("getFoto");
//        Comunity instance = new Comunity();
//        String expResult = "";
//        String result = instance.getFoto();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setFoto method, of class Comunity.
//     */
//    @Test
//    public void testSetFoto() {
//        System.out.println("setFoto");
//        String foto = "";
//        Comunity instance = new Comunity();
//        instance.setFoto(foto);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDatosFoto method, of class Comunity.
//     */
//    @Test
//    public void testGetDatosFoto() {
//        System.out.println("getDatosFoto");
//        Comunity instance = new Comunity();
//        byte[] expResult = null;
//        byte[] result = instance.getDatosFoto();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDatosFoto method, of class Comunity.
//     */
//    @Test
//    public void testSetDatosFoto() {
//        System.out.println("setDatosFoto");
//        byte[] datosFoto = null;
//        Comunity instance = new Comunity();
//        instance.setDatosFoto(datosFoto);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Comunity.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Comunity instance = new Comunity();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
