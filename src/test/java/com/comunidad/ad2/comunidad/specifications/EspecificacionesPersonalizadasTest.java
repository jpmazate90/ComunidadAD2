/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.specifications;

import com.comunidad.ad2.comunidad.entity.CommunityPost;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author jpmazate
 */
public class EspecificacionesPersonalizadasTest {
    
    
    
    public EspecificacionesPersonalizadasTest() {
        
    }
    
    
    
    @Test
    public void testContieneUsuario() {
        String usuario = "user";
        Specification<CommunityPost> result = EspecificacionesPersonalizadas.contieneUsuario(usuario);
        assertNotNull(result);
        
    }
    
    @Test
    public void testConvertirFecha() {
        String fecha = "2000-01-01";
        LocalDateTime expect = LocalDateTime.of(2000, Month.JANUARY, 1, 0, 0);
        LocalDateTime result = EspecificacionesPersonalizadas.convertirFecha(fecha);
        assertEquals(expect, result);
        
    }
    
    @Test
    public void testConvertirFechaError() {
        String fecha = "2000/01/01";
        LocalDateTime expect = LocalDateTime.now();
        LocalDateTime result = EspecificacionesPersonalizadas.convertirFecha(fecha);
        assertEquals(result.getDayOfYear(),expect.getDayOfYear());
        assertEquals(result.getMonth(),expect.getMonth());
        assertEquals(result.getYear(),expect.getYear());
        
    }
    
    @Test
    public void testContains() {
        String expresion = "hola";
        String expect = "%"+expresion+"%";
        String result = EspecificacionesPersonalizadas.contains(expresion);
        assertEquals(result,expect);
        
        
    }
//
//    /**
//     * Test of contieneFechaInicial method, of class EspecificacionesPersonalizadas.
//     */
//    @Test
//    public void testContieneFechaInicial() {
//        
//        String fechaInicial = "";
//        Specification<CommunityPost> expResult = null;
//        Specification<CommunityPost> result = EspecificacionesPersonalizadas.contieneFechaInicial(fechaInicial);
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of contieneFechaFinal method, of class EspecificacionesPersonalizadas.
//     */
//    @Test
//    public void testContieneFechaFinal() {
//        System.out.println("contieneFechaFinal");
//        String fechaFinal = "";
//        Specification<CommunityPost> expResult = null;
//        Specification<CommunityPost> result = EspecificacionesPersonalizadas.contieneFechaFinal(fechaFinal);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of contieneIdComunidad method, of class EspecificacionesPersonalizadas.
//     */
//    @Test
//    public void testContieneIdComunidad() {
//        System.out.println("contieneIdComunidad");
//        Integer id = null;
//        String val = "";
//        Specification<CommunityPost> expResult = null;
//        Specification<CommunityPost> result = EspecificacionesPersonalizadas.contieneIdComunidad(id, val);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of esComunidadActiva method, of class EspecificacionesPersonalizadas.
//     */
//    @Test
//    public void testEsComunidadActiva() {
//        System.out.println("esComunidadActiva");
//        Specification<CommunityPost> expResult = null;
//        Specification<CommunityPost> result = EspecificacionesPersonalizadas.esComunidadActiva();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of esComunidadPrivada method, of class EspecificacionesPersonalizadas.
     */
    @Test
    public void testEsComunidadPrivada() {
        Specification<CommunityPost> result = EspecificacionesPersonalizadas.esComunidadPrivada();
        assertNotNull( result);
    }
    
}
