/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.encriptacion.Hash;
import com.comunidad.ad2.comunidad.entity.Department;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.UserRepository;
import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import static com.comunidad.ad2.comunidad.service.enums.EstadoUsuario.EN_ESPERA;
import com.comunidad.ad2.comunidad.service.enums.GeneroUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import java.sql.Timestamp;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import static org.junit.Assert.assertEquals;


//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.StringUtil;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author jpmazate
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;  // es el mock

    @InjectMocks
    private UserServiceImpl userService; // es la implementacion

    public UserServiceImplTest() {
    }
    
    /*@BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }*/
 
    /**
     * Test of findAll method, of class UserServiceImpl.
     */
    @Test
    public void testSave() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        UserServiceImpl spy = Mockito.spy(userService);
        
        when(spy.hashearContrasena(usuario)).thenReturn("xxxxx");
        doNothing().when(spy).asignarEstado(usuario);
        when(userRepository.save(usuario)).thenReturn(usuario);
        
        //act
        User resultado =  spy.save(usuario);
        
        //assert
        //assertEquals(EN_ESPERA, resultado.getEstado());
        assertEquals("xxxxx", resultado.getPassword());
        verify(spy).asignarEstado(usuario);
        verify(userRepository).save(usuario);
        
    }
    
    @Test
    public void testAsignarEstadoWhenRoleIsCOMUNIDAD() {
        // arreange
        User usuario = crearUsuario(RolUsuario.COMUNIDAD);
        
        // act
        userService.asignarEstado(usuario);
        
        //assert
        assertEquals(EN_ESPERA, usuario.getEstado());
    }
    
    @Test
    public void testAsignarEstadoWhenRoleIsSUPER() {
        // arreange
        User usuario = crearUsuario(RolUsuario.SUPER);
        
        // act
        userService.asignarEstado(usuario);
        
        //assert
        assertEquals(EN_ESPERA, usuario.getEstado());
    }
    
    private User crearUsuario(RolUsuario a){
        User user = new User("201029301","aaa", "aaa", new Timestamp(400000000), GeneroUsuario.N, "aa", "aa@a.com", a, "xela", EstadoUsuario.ACTIVO);
        return user;
    }
    
    
    @Test
    public void testFindById() {
        // arreange
        User usuario = crearUsuario(RolUsuario.COMUNIDAD);
        when(userRepository.findById("201029301")).thenReturn(Optional.of(usuario));
        // act
        Optional<User> resultado = userService.findById("201029301");
        
        //assert
        assertEquals(resultado.get().getRegistroAcademico(), usuario.getRegistroAcademico());
    }
    
    @Test
    public void testLoginWhenUserIsPresent() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        when(userRepository.userAuthentication("111111111",Hash.md5("Juan1!"))).thenReturn(Optional.of(usuario));
        when(userRepository.save(usuario)).thenReturn(usuario);
        
        //act
        String resultado =  userService.login("111111111","Juan1!");
        
        
        Assertions.assertNotNull(resultado);
        
        
    }
    
    @Test
    public void testLoginWhenUserIsNotPresent() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        when(userRepository.userAuthentication("111111111",Hash.md5("Juan1!"))).thenReturn(Optional.empty());
        //act
        String resultado =  userService.login("111111111","Juan1!");

        assertEquals(resultado, StringUtils.EMPTY);
        
    }
    
    @Test
    public void testFormatearFecha() {
        // arrange
        int SEIS_HORAS = 21600000;
        User usuario = crearUsuario(RolUsuario.SUPER);
        Long resultadoEsperado = usuario.getFechaDeNacimiento().getTime() + SEIS_HORAS;
        //act
        
        Timestamp resultado = userService.formatearFecha(usuario);
        
        
        //assert
        assertEquals(resultado.getTime(), resultadoEsperado);
        
    }
     @Test
    public void testHashearContrasena() {
        // arrange
        String resultadoEsperado = "9ab340dd9f14971aaacb0a6d4f8ffa9a";
        User usuario = crearUsuario(RolUsuario.SUPER);
        usuario.setPassword("Juan1!");
        //act
        String resultado = userService.hashearContrasena(usuario);
        //assert
        assertEquals(resultado, resultadoEsperado);
    }
    @Test
    public void testFindByOwnUser() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        when(userRepository.findByOwnToken("token")).thenReturn(Optional.of(usuario));
        //act
        Optional<User> resultado = userService.findByTokenOwnUser("token");
        //assert
        assertEquals(resultado.get().getRegistroAcademico(),usuario.getRegistroAcademico());
    }
    @Test
    public void testActualizarDatos() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        when(userRepository.save(usuario)).thenReturn(usuario);
        //act
        User resultado = userService.actualizarDatosUser(usuario);
        //assert
        assertEquals(resultado.getRegistroAcademico(),usuario.getRegistroAcademico());
    }
    @Test
    public void testAdminCreation(){
        // arrange
        UserServiceImpl spy = Mockito.spy(userService);
        Mockito.when(userRepository.adminCreation("201832431")).thenReturn(1);
        
        //act
        int admin = spy.adminCreation("201832431");
        int response = admin;
        
        //assert
        Assertions.assertEquals(1, response);
    }
    
    @Test
    public void testChangePasswordUser(){
        // arrange
        UserServiceImpl spy = Mockito.spy(userService);
        Mockito.when(userRepository.changePasswordUser("201832431", Hash.md5("xxxx"))).thenReturn(1);
        
        //act
        int changePass = spy.changePasswordUser("201832431", "xxxx");
        int response = changePass;
        
        //assert
        Assertions.assertEquals(1, response);
    }
    
    

}
