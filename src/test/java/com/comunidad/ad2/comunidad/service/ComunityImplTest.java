/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.Course;
import com.comunidad.ad2.comunidad.repository.ComunityRepository;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
public class ComunityImplTest {

    public static final String NOMBRE_COMUNIDAD = "Comunidad AD2";

    @Mock
    private ComunityRepository comunityRepository;

    @InjectMocks
    private ComunityImpl comunityImpl;

    public ComunityImplTest() {

    }

    @Test
    public void testSave() {
        //Arrange
        Comunity comunity = crearComunidad(NOMBRE_COMUNIDAD);
        ComunityImpl spy = Mockito.spy(this.comunityImpl);

        Mockito.when(comunityRepository.save(comunity)).thenReturn(comunity);
        //act
        Comunity resultado = spy.save(comunity);
        //assert
        Assertions.assertEquals(NOMBRE_COMUNIDAD, resultado.getNombre());
        //Assertions.assertEquals(NOMBRE_COMUNIDAD,"d");

    }

//    /**
//     * Test of findById method, of class ComunityImpl.
//     */
//    @Test
//    public void testFindById() {
//        System.out.println("findById");
//        Integer idComunidad = null;
//        ComunityImpl instance = null;
//        Optional<Comunity> expResult = null;
//        Optional<Comunity> result = instance.findById(idComunidad);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of guardarImagen method, of class ComunityImpl.
//     */
//    @Test
//    public void testGuardarImagen() throws Exception {
//        System.out.println("guardarImagen");
//        MultipartFile file = null;
//        ComunityImpl instance = null;
//        Comunity expResult = null;
//        Comunity result = instance.guardarImagen(file);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    public Comunity crearComunidad(String nombreComunidad) {
        Course curso = new Course();
        return new Comunity(curso, nombreComunidad, "");
    }
    
    private List<Comunity> getCommunitiesList(int sizeList){
        List<Comunity> result = new LinkedList<>();
        for (int i = 0; i < sizeList; i++) {
            result.add(crearComunidad("n" + i));
        }
        return result;
    }
    
    @Test
    public void testGetCommunitiesBySearch(){
        List<Comunity> listaCommunities = getCommunitiesList(3);
        String param = NOMBRE_COMUNIDAD;
        //arrange
        ComunityImpl spy = Mockito.spy(comunityImpl);
        Mockito.when(comunityImpl.getCommunitiesBySearch(param)).thenReturn(listaCommunities);
        //act
        List<Comunity> resulList = (List<Comunity>) spy.getCommunitiesBySearch(param);
        //assert
        Assertions.assertEquals(listaCommunities.size(), resulList.size());
    }
    
    @Test
    public void testFindAll(){
        List<Comunity> listaCommunities = getCommunitiesList(3);
        //arrange
        ComunityImpl spy = Mockito.spy(comunityImpl);
        Mockito.when(comunityImpl.findAll()).thenReturn(listaCommunities);
        //act
        List<Comunity> resulList = (List<Comunity>) spy.findAll();
        //assert
        Assertions.assertEquals(listaCommunities.size(), resulList.size());
    }
    
}
