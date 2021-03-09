/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.UserRepository;
import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import static com.comunidad.ad2.comunidad.service.enums.EstadoUsuario.EN_ESPERA;
import com.comunidad.ad2.comunidad.service.enums.GeneroUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import java.sql.Timestamp;
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
    
    private User crearUsuario(RolUsuario a){
        User user = new User("201029301","aaa", "aaa", new Timestamp(400000000), GeneroUsuario.N, "aa", "aa@a.com", a, "xela", EstadoUsuario.ACTIVO);
        return user;
    }

}
