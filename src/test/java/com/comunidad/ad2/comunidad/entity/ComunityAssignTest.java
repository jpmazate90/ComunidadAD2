/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.EstadoComunityAssign;
import com.comunidad.ad2.comunidad.service.enums.TipoComunityAssign;
import java.sql.Timestamp;
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
public class ComunityAssignTest {
    
    private ComunityAssignKey comunityAssignKey;
    private User user;
    private ComunityAssign comunityAssign;
    private Comunity comunity;
    public static final String REGISTRO_ACADEMICO="123456789";
    public static final int ID_COMUNIDAD=1;
    public static final TipoComunityAssign TIPO=TipoComunityAssign.ADMINISTRADOR;
    public static final Timestamp FECHA_DECISION= new Timestamp(System.currentTimeMillis());
    public static final EstadoComunityAssign ESTADO = EstadoComunityAssign.ACTIVO;
    public static final Timestamp FECHA_CREACION= new Timestamp(System.currentTimeMillis());
    
    public ComunityAssignTest() {
        this.comunityAssignKey= new ComunityAssignKey(REGISTRO_ACADEMICO,ID_COMUNIDAD);
        this.user = new User(REGISTRO_ACADEMICO);
        this.comunity= new Comunity(ID_COMUNIDAD);
        this.comunityAssign = new ComunityAssign(comunityAssignKey, user, comunity, TIPO, FECHA_DECISION, ESTADO, FECHA_CREACION);
    }
    
    @Test
    public void testSimpleTest(){
        ComunityAssign ca = new ComunityAssign();
        assertEquals(ca, ca);
    }


    /**
     * Test of getIdComunityAssign method, of class ComunityAssign.
     */
    @Test
    public void testGetIdComunityAssign() {
        //Act
        System.out.println("getIdComunityAssign");
        ComunityAssign instance = this.comunityAssign;
        //Arrange
        ComunityAssignKey expResult = comunityAssignKey;
        ComunityAssignKey result = instance.getIdComunityAssign();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdComunityAssign method, of class ComunityAssign.
     */
    @Test
    public void testSetIdComunityAssign() {
        //Act
        System.out.println("setIdComunityAssign");
        ComunityAssign instance = this.comunityAssign;
        ComunityAssignKey nuevo = new ComunityAssignKey("123", ID_COMUNIDAD);
        //Arrange
        instance.setIdComunityAssign(nuevo);
        ComunityAssignKey expResult = nuevo;
        ComunityAssignKey result = instance.getIdComunityAssign();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class ComunityAssign.
     */
    @Test
    public void testGetUser() {
        //Act
        System.out.println("getUser");
        ComunityAssign instance = this.comunityAssign;
        //Arrange
        User expResult = this.user;
        User result = instance.getUser();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of setUser method, of class ComunityAssign.
     */
    @Test
    public void testSetUser() {
        //Act
        System.out.println("setUser");
        ComunityAssign instance = this.comunityAssign;
        User nuevo = new User();
        //Arrange
        instance.setUser(nuevo);
        User expResult = nuevo;
        User result = instance.getUser();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getComunity method, of class ComunityAssign.
     */
    @Test
    public void testGetComunity() {
        //Act
        System.out.println("getComunity");
        ComunityAssign instance = this.comunityAssign;
        //Arrange
        Comunity expResult = this.comunity;
        Comunity result = instance.getComunity();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setComunity method, of class ComunityAssign.
     */
    @Test
    public void testSetComunity() {
        //Act
        System.out.println("getComunity");
        ComunityAssign instance = this.comunityAssign;
        Comunity nuevo = new Comunity();
        //Arrange
        instance.setComunity(nuevo);
        Comunity expResult = nuevo;
        Comunity result = instance.getComunity();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of getTipo method, of class ComunityAssign.
     */
    @Test
    public void testGetTipo() {
        //Act
        System.out.println("getTipo");
        ComunityAssign instance =this.comunityAssign;
        //Arrange
        TipoComunityAssign expResult = TIPO;
        TipoComunityAssign result = instance.getTipo();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setTipo method, of class ComunityAssign.
     */
    @Test
    public void testSetTipo() {
        //Act
        System.out.println("setTipo");
        ComunityAssign instance =this.comunityAssign;
        TipoComunityAssign nuevo = TipoComunityAssign.MIEMBRO;
        //Arrange
        instance.setTipo(nuevo);
        TipoComunityAssign expResult = nuevo;
        TipoComunityAssign result = instance.getTipo();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of getFecha_decision method, of class ComunityAssign.
     */
    @Test
    public void testGetFecha_decision() {
        //Act
        System.out.println("getFecha_decision");
        ComunityAssign instance = this.comunityAssign;
        //Arrange
        Timestamp expResult = FECHA_DECISION;
        Timestamp result = instance.getFecha_decision();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of setFecha_decision method, of class ComunityAssign.
     */
    @Test
    public void testSetFecha_decision() {
        //Act
        System.out.println("setFecha_decision");
        ComunityAssign instance = this.comunityAssign;
        Timestamp nuevo = new Timestamp(System.currentTimeMillis());
        //Arrange
        instance.setFecha_decision(nuevo);
        Timestamp expResult = nuevo;
        Timestamp result = instance.getFecha_decision();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstado method, of class ComunityAssign.
     */
    @Test
    public void testGetEstado() {
        //Act
        System.out.println("getEstado");
        ComunityAssign instance = this.comunityAssign;
        //Arrange
        EstadoComunityAssign expResult = ESTADO;
        EstadoComunityAssign result = instance.getEstado();
        //aSSERT
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstado method, of class ComunityAssign.
     */
    @Test
    public void testSetEstado() {
        //Act
        System.out.println("setEstado");
        ComunityAssign instance = this.comunityAssign;
        EstadoComunityAssign nuevo = EstadoComunityAssign.DENEGADO;
        //Arrange
        instance.setEstado(nuevo);
        EstadoComunityAssign expResult = nuevo;
        EstadoComunityAssign result = instance.getEstado();
        //aSSERT
        assertEquals(expResult, result);
    }

    /**
     * Test of getFechaCreacion method, of class ComunityAssign.
     */
    @Test
    public void testGetFechaCreacion() {
        //Act
        System.out.println("getFechaCreacion");
        ComunityAssign instance = this.comunityAssign;
        //Arrange
        Timestamp expResult = FECHA_CREACION;
        Timestamp result = instance.getFechaCreacion();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setFechaCreacion method, of class ComunityAssign.
     */
    @Test
    public void testSetFechaCreacion() {
        //Act
        System.out.println("setFechaCreacion");
        ComunityAssign instance = this.comunityAssign;
        Timestamp nuevo = new Timestamp(System.currentTimeMillis());
        //Arrange
        instance.setFechaCreacion(nuevo);
        Timestamp expResult = nuevo;
        Timestamp result = instance.getFechaCreacion();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ComunityAssign.
     */
    @Test
    public void testToString() {
        //Act
        System.out.println("toString");
        ComunityAssign instance = this.comunityAssign;
        //Arrange
        String expResult = "ComunityAssign{" + "registro,id=" + comunityAssignKey.getRegistroAcademico() +"  "+comunityAssignKey.getIdComunidad()+ ", user=" + user + ", comunity=" + comunity + ", tipo=" + TIPO + ", fecha_decision=" + FECHA_DECISION + ", estado=" + ESTADO + ", fechaCreacion_O_Aceptacion=" + FECHA_CREACION + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test void testConstructor(){
        //Act
        ComunityAssign comunityAssign = new ComunityAssign(comunityAssignKey, TIPO, FECHA_DECISION, ESTADO, FECHA_CREACION);
        //Arrange
        String expResult = REGISTRO_ACADEMICO;
        String result = comunityAssign.getIdComunityAssign().getRegistroAcademico();
        //Assert
        assertEquals(expResult,result);
    }
}
