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
import java.util.Iterator;
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
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
public class ComunityAssignImplTest {

    private ComunityAssignKey comunityAssignKey;
    private User user;
    private ComunityAssign comunityAssign;
    private Comunity comunity;
    public static final String REGISTRO_ACADEMICO = "123456789";
    public static final int ID_COMUNIDAD = 1;
    public static final TipoComunityAssign TIPO = TipoComunityAssign.ADMINISTRADOR;
    public static final Timestamp FECHA_DECISION = new Timestamp(System.currentTimeMillis());
    public static final EstadoComunityAssign ESTADO = EstadoComunityAssign.ACTIVO;
    public static final Timestamp FECHA_CREACION = new Timestamp(System.currentTimeMillis());

    @Mock
    private ComunityAssignRepository comunityAssignRepository;

    @InjectMocks
    private ComunityAssignImpl comunityAssignImpl;

    public ComunityAssignImplTest() {
        this.comunityAssignKey = new ComunityAssignKey(REGISTRO_ACADEMICO, ID_COMUNIDAD);
        this.user = new User(REGISTRO_ACADEMICO);
        this.comunity = new Comunity(ID_COMUNIDAD);
        this.comunityAssign = new ComunityAssign(comunityAssignKey, user, comunity, TIPO, FECHA_DECISION, ESTADO, FECHA_CREACION);

    }

    /**
     * Test of save method, of class ComunityAssignImpl.
     */
    @Test
    public void testSave() {
        //Arrange
        System.out.println("save");
        ComunityAssign comunityAssign = this.comunityAssign;
        ComunityAssignImpl spy = Mockito.spy(comunityAssignImpl);
        Mockito.when(comunityAssignRepository.save(ArgumentMatchers.any())).thenReturn(comunityAssign);
        //Act

        ComunityAssign expResult = comunityAssign;
        ComunityAssign result = spy.save(comunityAssign);

        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of findComunityTypeAdminitrationByRegistroAcademico method, of class
     * ComunityAssignImpl.
     */
    @Test
    public void testFindComunityTypeAdminitrationByRegistroAcademico() {
        //Arrange
        System.out.println("findComunityTypeAdminitrationByRegistroAcademico");
        String registroAcademico = "12345678";
        Iterable<ComunityAssign> comunityAssignList = new ArrayList<>();
        ComunityAssignImpl instance = Mockito.spy(comunityAssignImpl);
        Mockito.when(comunityAssignRepository.findComunityTypeAdminitrationByRegistroAcademico(registroAcademico)).thenReturn(comunityAssignList);
        for (ComunityAssign comAssig : comunityAssignList) {
            Mockito.doNothing().when(instance).agregarFotoAComunidad(comAssig);
        }
        //Act
        Iterable<ComunityAssign> expResult = comunityAssignList;
        Iterable<ComunityAssign> result = instance.findComunityTypeAdminitrationByRegistroAcademico(registroAcademico);

        //Arrange
        assertEquals(expResult, result);

    }

    /**
     * Test of findComunityOwnerByIdComunity method, of class
     * ComunityAssignImpl.
     */
    @Test
    public void testFindComunityOwnerByIdComunity() {
        System.out.println("findComunityOwnerByIdComunity");
        ComunityAssignImpl instance = Mockito.spy(comunityAssignImpl);
        Optional<ComunityAssign> com = Optional.of(this.comunityAssign);
        Mockito.when(comunityAssignRepository.findComunityOwnerByIdComunity(ID_COMUNIDAD)).thenReturn(com);

        //Arrange
        Optional<ComunityAssign> expResult = com;
        Optional<ComunityAssign> result = instance.findComunityOwnerByIdComunity(ID_COMUNIDAD);
        //Assert
        assertEquals(expResult.get(), result.get());

    }

    /**
     * Test of findByIdComunityMiembro method, of class ComunityAssignImpl.
     */
    @Test
    public void testFindByIdComunityMiembro() {
        //Arrange
        System.out.println("findByIdComunityMiembro");
        ComunityAssignImpl instance = Mockito.spy(this.comunityAssignImpl);
        Optional<ComunityAssign> comAssign = Optional.of(this.comunityAssign);
        Mockito.when(comunityAssignRepository.findByIdComunityMiembro(ID_COMUNIDAD, REGISTRO_ACADEMICO)).thenReturn(comAssign);
        //Act
        Optional<ComunityAssign> expResult = comAssign;
        Optional<ComunityAssign> result = instance.findByIdComunityMiembro(ID_COMUNIDAD, REGISTRO_ACADEMICO);
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of getFechaActual method, of class ComunityAssignImpl.
     */
    @Test
    public void testGetFechaActual() {
        //Arrange
        System.out.println("getFechaActual");
        ComunityAssignImpl instance = this.comunityAssignImpl;
        //Act
        Timestamp expResult = new Timestamp(System.currentTimeMillis());
        Timestamp result = instance.getFechaActual();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of agregarFotoAComunidad method, of class ComunityAssignImpl.
     */
    @Test
    public void testAgregarFotoAComunidad() {
        //Arrange
        System.out.println("agregarFotoAComunidad");
        ComunityAssignImpl instance = Mockito.spy(comunityAssignImpl);
        RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
        String foto = "src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png";
        this.comunityAssign.getComunity().setFoto(foto);

        //Act
        //byte[] expResult = recuperadorDeImagenesDeDisco.recuperarBytesDeImagen(foto);
        byte[] result = instance.agregarFotoAComunidad(comunityAssign).getComunity().getDatosFoto();
        //Assert
        System.out.println("DATOS FOTO:"+this.comunityAssign.getComunity().getDatosFoto());
        assertNotNull(this.comunityAssign.getComunity().getDatosFoto());

    }

    /**
     * Test of findRequestInEspera method, of class ComunityAssignImpl.
     */
    @Test
    public void testFindRequestInEspera() {
        //Arrange
        System.out.println("findRequestInEspera");
        ComunityAssignImpl instance = Mockito.spy(this.comunityAssignImpl);
        Iterable<ComunityAssign> comunityAssignList = new ArrayList<>();
        Mockito.when(comunityAssignRepository.findUserRequest(ID_COMUNIDAD, REGISTRO_ACADEMICO)).thenReturn(comunityAssignList);
        //Act
        Iterable<ComunityAssign> expResult = comunityAssignList;
        Iterable<ComunityAssign> result = instance.findRequestInEspera(ID_COMUNIDAD, REGISTRO_ACADEMICO);
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of updateStateComunityRequest method, of class ComunityAssignImpl.
     */
    @Test
    public void testUpdateStateComunityRequest() {
        //Arrange
        System.out.println("updateStateComunityRequest");
        ComunityAssignImpl instance = Mockito.spy(this.comunityAssignImpl);
        Mockito.when(comunityAssignRepository.save(this.comunityAssign)).thenReturn(comunityAssign);
        //Act
        Timestamp expResult = this.comunityAssign.getFecha_decision();
        Timestamp result = instance.updateStateComunityRequest(comunityAssign).getFecha_decision();
        //Arrange
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
