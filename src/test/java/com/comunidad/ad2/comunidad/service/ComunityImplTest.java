/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.Course;
import com.comunidad.ad2.comunidad.repository.ComunityRepository;
import java.util.LinkedList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
class ComunityImplTest {

    public static final String NOMBRE_COMUNIDAD = "Comunidad AD2";

    @Mock
    private ComunityRepository comunityRepository;

    @InjectMocks
    private ComunityImpl comunityImpl;

    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;

    public ComunityImplTest() {
        this.recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
    }

    @Test
    void testSave() {
        //Arrange
        Comunity comunity = crearComunidad(NOMBRE_COMUNIDAD);
        ComunityImpl spy = Mockito.spy(this.comunityImpl);

        Mockito.when(comunityRepository.save(comunity)).thenReturn(comunity);
        //act
        Comunity resultado = spy.save(comunity);
        //assert
        Assertions.assertEquals(NOMBRE_COMUNIDAD, resultado.getNombre());
    }


    /**
     * Test of guardarImagen method, of class ComunityImpl.
     */
    @Test
    void testGuardarImagen() throws Exception {
        //Arrange
        System.out.println("guardarImagen");
        Comunity comunity = new Comunity();
        comunity.setFoto("/foto");
        ComunityImpl spy = Mockito.spy(this.comunityImpl);
        byte[] bytesImg = this.recuperadorDeImagenesDeDisco.recuperarBytesDeImagen("src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png");
        Path rutaImagen = Paths.get("src/test/java/com/comunidad/ad2/comunidad/controllImage/image2.png");
        MockMultipartFile file = new MockMultipartFile("data", bytesImg);
        //Act
        Mockito.when(spy.guardarImagen(file)).thenReturn(comunity);
        Comunity expResult = comunity;
        Comunity result= spy.guardarImagen(file);
        //Arrange
        Assertions.assertEquals(expResult,result);
    }

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
    void testGetCommunitiesBySearch(){
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
    void testFindAll(){
        List<Comunity> listaCommunities = getCommunitiesList(3);
        //arrange
        ComunityImpl spy = Mockito.spy(comunityImpl);
        Mockito.when(comunityImpl.findAll()).thenReturn(listaCommunities);
        //act
        List<Comunity> resulList = (List<Comunity>) spy.findAll();
        //assert
        Assertions.assertEquals(listaCommunities.size(), resulList.size());
    }
    
    @Test
    void testDeleteById(){
        //Arrange
        //Comunity comunidad = crearComunidad();
        //ComunityAssignRepository spy = Mockito.spy(comunityAssignRepository);
        String idComunidad = "4";
       //doNothing().when(this.comunityRepository).delete(new Comunity(Integer.parseInt(idComunidad)));
        //Act
        boolean expResult = true;
        boolean result = this.comunityImpl.deleteById(idComunidad);
        //Arrange
        assertEquals(expResult, result);
        //verify(this.comunityRepository).delete(new Comunity(Integer.parseInt(idComunidad)));
        
    }
    
     @Test
    void testFindById(){
        //Arrange
        Comunity comunidad = crearComunidad();
        //ComunityAssignRepository spy = Mockito.spy(comunityAssignRepository);
        String idComunidad = "4";
        when(this.comunityRepository.findById(Integer.parseInt(idComunidad))).thenReturn(Optional.of(comunidad));
        //Act
        Optional<Comunity> expResult = Optional.of(comunidad);
        Optional<Comunity> result = this.comunityImpl.findById(idComunidad);
        //Arrange
        assertEquals(expResult.get().getId(), result.get().getId());
        
    }
     private Comunity crearComunidad() {
        return new Comunity(4);
    }

   

    
}
