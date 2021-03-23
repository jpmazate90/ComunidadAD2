/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author jesfrin
 */
public class ComunityTest {

    private Comunity comunidad;
    private Course course;

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
        int nuevoId = 5;
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

    /**
     * Test of setCourse method, of class Comunity.
     */
    @Test
    public void testSetCourse() {
        //Act
        System.out.println("getCourse");
        Comunity instance = this.comunidad;
        Course newCourse = new Course("005", "Otro curso", 1);
        //Arrange
        instance.setCourse(newCourse);
        Course expResult = newCourse;
        Course result = instance.getCourse();
        //Asset
        assertEquals(expResult.getCodigoDeCurso(), result.getCodigoDeCurso());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombre method, of class Comunity.
     */
    @Test
    public void testGetNombre() {
        //Act
        System.out.println("getNombre");
        Comunity instance = this.comunidad;
        //Assert
        String expResult = "Primera Comunidad";
        String result = instance.getNombre();
        //Arrange
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNombre method, of class Comunity.
     */
    @Test
    public void testSetNombre() {
        //Act
        System.out.println("setNombre");
        String nombre = "";
        Comunity instance = this.comunidad; //Arrange
        //Assert
        instance.setNombre(nombre);
        String expResult = nombre;
        String result = instance.getNombre();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescripcion method, of class Comunity.
     */
    @Test
    public void testGetDescripcion() {
        //Act
        System.out.println("getDescripcion");
        Comunity instance = this.comunidad;
        //Arrange
        String expResult="Descripcion comunidad";
        String result=instance.getDescripcion();
        //Assert
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setDescripcion method, of class Comunity.
     */
    @Test
    public void testSetDescripcion() {
     //Act
        System.out.println("getDescripcion");
        Comunity instance = this.comunidad;
        String newDescription="newDescription";
        //Arrange
        instance.setDescripcion(newDescription);
        String expResult=newDescription;
        String result=instance.getDescripcion();
        //Assert
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFoto method, of class Comunity.
     */
    @Test
    public void testGetFoto() {
        //Act
         System.out.println("getFoto");
        Comunity instance = new Comunity();
        instance.setFoto("/direccion/foto");
        //Arrange
        String expResult="/direccion/foto";
        String result = instance.getFoto();
        //Asset        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class Comunity.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Comunity instance = this.comunidad;
        String expResult = "Comunity{" + "id=" + instance.getId() + ", course=" + instance.getCourse() + ", nombre=" + instance.getNombre() + ", descripcion=" + instance.getDescripcion() + ", foto=" + instance.getFoto() + ", datosFoto=" + instance.getDatosFoto() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
