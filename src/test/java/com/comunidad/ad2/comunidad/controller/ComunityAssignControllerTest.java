/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.ComunityAssignFilters;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.ComunityAssignRepository;
import com.comunidad.ad2.comunidad.repository.ComunityRepository;
import com.comunidad.ad2.comunidad.repository.UserRepository;
import com.comunidad.ad2.comunidad.service.ComunityAssignService;
import com.comunidad.ad2.comunidad.service.UserServiceImpl;
import com.comunidad.ad2.comunidad.service.enums.EstadoComunityAssign;
import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import com.comunidad.ad2.comunidad.service.enums.GeneroUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import com.comunidad.ad2.comunidad.service.enums.TipoComunityAssign;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterators;
import static java.util.Spliterators.iterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jpmazate
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ComunityAssignControllerTest {

    @Mock
    private ComunityAssignService comunityAssignService;  // es el mock

    @InjectMocks
    private ComunityAssignController comunityAssignController; // es la implementacion

    public ComunityAssignControllerTest() {
    }

    @Test
    public void testCreate() {
        ComunityAssign comunityAssign = createComunityAssign();
        ComunityAssignService spyService = Mockito.spy(comunityAssignService);
        when(spyService.save(comunityAssign)).thenReturn(comunityAssign);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body(comunityAssign);
        ResponseEntity result = this.comunityAssignController.create(comunityAssign);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }


    /**
     * Test of findByRegistroAcademico method, of class
     * ComunityAssignController.
     */
    @Test
    public void testFindByRegistroAcademico() throws IOException {
        User user = crearUsuario(RolUsuario.SUPER);
        ComunityAssignService spyService = Mockito.spy(comunityAssignService);
        Iterable<ComunityAssign> comunidadesAsignadas = obtenerComunitysAsignsList();        
        when(spyService.findByRegistroAcademico(user.getRegistroAcademico())).thenReturn(comunidadesAsignadas);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(comunidadesAsignadas);
        ResponseEntity result = this.comunityAssignController.findByRegistroAcademico(user);
        Object body = result.getBody();
        Object body2 = expResult.getBody();
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
        //falta validar las dos iterables lists
    }

    /**
     * Test of findComunityById method, of class ComunityAssignController.
     */
    @Test
    public void testFindComunityById() throws Exception {
        Comunity com = crearComunidad();
        ComunityAssignController instance = this.comunityAssignController;
        ComunityAssignService spyService = Mockito.spy(comunityAssignService);
        Optional<ComunityAssign> comunidadAsignada = Optional.of(createComunityAssign());        
        Mockito.lenient().when(spyService.findByIdComunity(com.getId())).thenReturn(comunidadAsignada);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body(comunidadAsignada);
        ResponseEntity result = instance.findComunityById(com);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
        
    }

    /**
     * Test of findComunityAsignsByIdComunity method, of class
     * ComunityAssignController.
     */
    @Test
    public void testFindComunityAsignsByIdComunity() throws Exception {
        User user = crearUsuario(RolUsuario.SUPER);
        ComunityAssignService spyService = Mockito.spy(comunityAssignService);
        Iterable<ComunityAssign> comunidadesAsignadas = obtenerComunitysAsignsList();        
        when(spyService.findRequestInEspera(ArgumentMatchers.any(),ArgumentMatchers.any())).thenReturn(comunidadesAsignadas);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(comunidadesAsignadas);
        ResponseEntity result = this.comunityAssignController.findComunityAsignsByIdComunity(new ComunityAssignFilters("1",1));
        Object body = result.getBody();
        Object body2 = expResult.getBody();
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }

    /**
     * Test of updateStateComunityRequest method, of class
     * ComunityAssignController.
     */
    @Test
    public void testUpdateStateComunityRequest() {
        Comunity com = crearComunidad();
        ComunityAssignController instance = this.comunityAssignController;
        ComunityAssignService spyService = Mockito.spy(comunityAssignService);
        Optional<ComunityAssign> comunidadAsignada = Optional.of(createComunityAssign());        
        when(spyService.save(ArgumentMatchers.any())).thenReturn(comunidadAsignada.get());
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body(comunidadAsignada);
        ResponseEntity result = instance.updateStateComunityRequest(comunidadAsignada.get());
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }

    private ComunityAssign createComunityAssign() {
        return new ComunityAssign(TipoComunityAssign.MIEMBRO, EstadoComunityAssign.ESPERA, new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()));
    }
    private User crearUsuario(RolUsuario a){
        User user = new User("201029301","aaa", "aaa", new Timestamp(400000000), GeneroUsuario.N, "aa", "aa@a.com", a, "xela", EstadoUsuario.ACTIVO);
        return user;
    }
    
    private Comunity crearComunidad(){
        return new Comunity(4);
    }
    
    private Iterable<ComunityAssign> obtenerComunitysAsignsList (){
        
        List<ComunityAssign> a = new ArrayList<ComunityAssign>();
        for (int i = 0; i < 2; i++) {
            a.add(createComunityAssign());
        }
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(a.iterator(), 0),false).collect(Collectors.toList());
        
    }

}
