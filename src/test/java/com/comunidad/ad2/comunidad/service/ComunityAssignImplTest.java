/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.entity.ComunityAssignKey;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.ComunityAssignRepository;
import com.comunidad.ad2.comunidad.service.enums.EstadoComunityAssign;
import com.comunidad.ad2.comunidad.service.enums.TipoComunityAssign;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author jpmazate
 */
@ExtendWith(MockitoExtension.class)
public class ComunityAssignImplTest {
    @Mock
    private ComunityAssignRepository comunityAssignRepository;
    
    @Mock
    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;
    
    @InjectMocks
    private ComunityAssignImpl comunityAsignImpl;

    
    public ComunityAssignImplTest() {
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
     * Test of save method, of class ComunityAssignImpl.
     */
    @Test
    public void testSave() {
        
        ComunityAssign asignar = crearComunityAsign();
        when(this.comunityAssignRepository.save(ArgumentMatchers.any())).thenReturn(asignar);

        ComunityAssign expResult = asignar;
        ComunityAssign result = this.comunityAsignImpl.save(asignar);
        assertEquals(expResult.getTipo(), result.getTipo());
        
    }

    
    private ComunityAssign crearComunityAsign(){
        return new ComunityAssign(new ComunityAssignKey("1", 1), new User("1"), new Comunity(1), TipoComunityAssign.ADMINISTRADOR, new Timestamp(new Date().getTime()), EstadoComunityAssign.ACTIVO, new Timestamp(new Date().getTime()));
    }
    
    private List<ComunityAssign> obtenerListaComunityAsign(){
        List<ComunityAssign> a = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            a.add(crearComunityAsign());
        }
        return a;
    }
    /**
     * Test of findComunityTypeAdminitrationByRegistroAcademico method, of class ComunityAssignImpl.
     */
    @Test
    public void testFindComunityTypeAdminitrationByRegistroAcademico() {
        String registroAcademico = "123456789";
        List<ComunityAssign> lista = obtenerListaComunityAsign();
        
        ComunityAssignImpl spy = Mockito.spy(comunityAsignImpl);
        when(this.comunityAssignRepository.findComunityTypeAdminitrationByRegistroAcademico(registroAcademico)).thenReturn(lista);
        
        when(spy.agregarFotoAComunidad(lista.get(0))).thenReturn(lista.get(0));
        
        
        Iterable<ComunityAssign> result = spy.findComunityTypeAdminitrationByRegistroAcademico(registroAcademico);
        
        
        assertEquals(((List<ComunityAssign>)result).size(), lista.size());
        
    }

//    /**
//     * Test of findComunityOwnerByIdComunity method, of class ComunityAssignImpl.
//     */
    @Test
    public void testFindComunityOwnerByIdComunity() {
                
        ComunityAssign a = crearComunityAsign();
        when(comunityAssignRepository.findComunityOwnerByIdComunity(1)).thenReturn(Optional.of(a));
        Optional<ComunityAssign> result = this.comunityAsignImpl.findComunityOwnerByIdComunity(1);
        assertEquals(a.getEstado(), result.get().getEstado());
        
    }

//    /**
//     * Test of findByIdComunityMiembro method, of class ComunityAssignImpl.
//     */
//    @Test
//    public void testFindByIdComunityMiembro() {
//        System.out.println("findByIdComunityMiembro");
//        int idComunidad = 0;
//        String registroAcademico = "";
//        ComunityAssignImpl instance = null;
//        Optional<ComunityAssign> expResult = null;
//        Optional<ComunityAssign> result = instance.findByIdComunityMiembro(idComunidad, registroAcademico);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFechaActual method, of class ComunityAssignImpl.
//     */
//    @Test
//    public void testGetFechaActual() {
//        System.out.println("getFechaActual");
//        ComunityAssignImpl instance = null;
//        Timestamp expResult = null;
//        Timestamp result = instance.getFechaActual();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of agregarFotoAComunidad method, of class ComunityAssignImpl.
//     */
//    @Test
//    public void testAgregarFotoAComunidad() {
//        System.out.println("agregarFotoAComunidad");
//        ComunityAssign comunityAssign = null;
//        ComunityAssignImpl instance = null;
//        ComunityAssign expResult = null;
//        ComunityAssign result = instance.agregarFotoAComunidad(comunityAssign);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findRequestInEspera method, of class ComunityAssignImpl.
//     */
    @Test
    public void testFindRequestInEspera() {
        
        List<ComunityAssign> lista = obtenerListaComunityAsign();
        when(this.comunityAssignRepository.findUserRequest(1,"1")).thenReturn(lista);        
        Iterable<ComunityAssign> result = this.comunityAsignImpl.findRequestInEspera(1, "1");
        assertEquals(lista.size(), ((List<ComunityAssign>)result).size());
         
    }

    /**
     * Test of updateStateComunityRequest method, of class ComunityAssignImpl.
     */
    @Test
    public void testUpdateStateComunityRequest() {
        ComunityAssign comunityAssign = crearComunityAsign();
        when(this.comunityAssignRepository.save(ArgumentMatchers.any())).thenReturn(comunityAssign);
        
        ComunityAssign result = this.comunityAsignImpl.updateStateComunityRequest(comunityAssign);
        assertEquals(comunityAssign.getEstado(), result.getEstado());
        
    }
    
}
