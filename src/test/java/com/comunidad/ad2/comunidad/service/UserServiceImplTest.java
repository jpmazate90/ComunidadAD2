/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.AuxObject.CreacionUsuarioParaPruebas;
import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.encriptacion.Hash;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.UserRepository;
import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import static com.comunidad.ad2.comunidad.service.enums.EstadoUsuario.EN_ESPERA;
import com.comunidad.ad2.comunidad.service.enums.GeneroUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 *
 * @author jpmazate
 */
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;  // es el mock

    @InjectMocks
    private UserServiceImpl userService; // es la implementacion

    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;

    public UserServiceImplTest() {
        this.recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
    }

    private User createUser(String id) {
        return new User(id);
    }

    private List<User> getUsersList(int sizeList) {
        List<User> result = new LinkedList<>();
        for (int i = 0; i < sizeList; i++) {
            result.add(createUser(Integer.toString(i)));
        }
        return result;
    }

    /**
     * Test of findAll method, of class UserServiceImpl.
     */
    @Test
    void testSave() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        UserServiceImpl spy = Mockito.spy(userService);
        when(spy.hashearContrasena(usuario)).thenReturn("xxxxx");
        doNothing().when(spy).asignarEstado(usuario);
        when(userRepository.save(usuario)).thenReturn(usuario);
        //act
        User resultado = spy.save(usuario);
        //assert
        assertEquals("xxxxx", resultado.getPassword());
        verify(spy).asignarEstado(usuario);
        verify(userRepository).save(usuario);
    }

    @Test
    void testAsignarEstadoWhenRoleIsCOMUNIDAD() {
        // arreange
        User usuario = crearUsuario(RolUsuario.COMUNIDAD);
        // act
        userService.asignarEstado(usuario);
        //assert
        assertEquals(EN_ESPERA, usuario.getEstado());
    }

    @Test
    void testAsignarEstadoWhenRoleIsSUPER() {
        // arreange
        User usuario = crearUsuario(RolUsuario.SUPER);
        // act
        userService.asignarEstado(usuario);
        //assert
        assertEquals(EN_ESPERA, usuario.getEstado());
    }

    private User crearUsuario(RolUsuario a) {
        User user = new User("201029301", "aaa", "aaa", new Timestamp(400000000), GeneroUsuario.N, "aa", "aa@a.com", a, "xela", EstadoUsuario.ACTIVO);
        return user;
    }

    @Test
    void testFindById() {
        // arreange
        User usuario = crearUsuario(RolUsuario.COMUNIDAD);
        when(userRepository.findById("201029301")).thenReturn(Optional.of(usuario));
        // act
        Optional<User> resultado = userService.findById("201029301");

        //assert
        assertEquals(resultado.get().getRegistroAcademico(), usuario.getRegistroAcademico());
    }

    @Test
    void testFindAll() {
        // arreange
        User usuario = crearUsuario(RolUsuario.COMUNIDAD);
        List<User> lista = obtenerUserList();
        when(userRepository.findAll()).thenReturn(lista);
        // act
        Iterable<User> resultado = userService.findAll();

        //assert
        assertEquals(tamanio(resultado), lista.size());
    }

    private int tamanio(Iterable<User> a) {
        int contador = 0;
        for (User as : a) {
            contador++;
        }
        return contador;
    }

    private List<User> obtenerUserList() {
        List<User> a = new ArrayList<User>();
        for (int i = 0; i < 2; i++) {
            a.add(CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER));
        }
        return a;

    }

    @Test
    void testLoginWhenUserIsPresent() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        when(userRepository.userAuthentication("111111111", Hash.md5("Juan1!"))).thenReturn(Optional.of(usuario));
        when(userRepository.save(usuario)).thenReturn(usuario);

        //act
        String resultado = userService.login("111111111", "Juan1!");

        Assertions.assertNotNull(resultado);

    }

    @Test
    void testLoginWhenUserIsNotPresent() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        when(userRepository.userAuthentication("111111111", Hash.md5("Juan1!"))).thenReturn(Optional.empty());
        //act
        String resultado = userService.login("111111111", "Juan1!");
        assertEquals(resultado,StringUtils.EMPTY);
    }

    @Test
    void testFormatearFecha() {
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
    void testHashearContrasena() {
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
    void testFindByOwnUser() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        when(userRepository.findByOwnToken("token")).thenReturn(Optional.of(usuario));
        //act
        Optional<User> resultado = userService.findByTokenOwnUser("token");
        //assert
        assertEquals(resultado.get().getRegistroAcademico(), usuario.getRegistroAcademico());
    }

    @Test
    void testActualizarDatos() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        when(userRepository.save(usuario)).thenReturn(usuario);
        //act
        User resultado = userService.actualizarDatosUser(usuario);
        //assert
        assertEquals(resultado.getRegistroAcademico(), usuario.getRegistroAcademico());
    }

    @Test
    void testAdminCreation() {
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
    void testChangePasswordUser() {
        // arrange
        UserServiceImpl spy = Mockito.spy(userService);
        Mockito.when(userRepository.changePasswordUser("201832431", Hash.md5("xxxx"))).thenReturn(1);
        //act
        int changePass = spy.changePasswordUser("201832431", "xxxx");
        int response = changePass;
        //assert
        Assertions.assertEquals(1, response);
    }

    @Test
    void testGetUsersBySearch() {
        String param = "1";
        List<User> listaUsuarios = getUsersList(3);
        //arrange
        UserServiceImpl spy = Mockito.spy(userService);
        Mockito.when(userRepository.getUsersBySearch(param)).thenReturn(listaUsuarios);
        //act
        List<User> resultList = (List<User>) spy.getUsersBySearch(param);
        //assert
        Assertions.assertEquals(listaUsuarios.size(), resultList.size());
    }

    @Test
    void testfindByToken() {
        // arrange
        UserServiceImpl spy = Mockito.spy(userService);
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        Mockito.when(userRepository.findByToken(ArgumentMatchers.any())).thenReturn(Optional.of(user));
        org.springframework.security.core.userdetails.User expect = new org.springframework.security.core.userdetails.User(user.getRegistroAcademico(), user.getPassword(), true, true, true, true,
                AuthorityUtils.createAuthorityList("USER"));
        //act
        Optional<org.springframework.security.core.userdetails.User> result = this.userService.findByToken("1");
        //assert
        Assertions.assertEquals(expect.getUsername(), result.get().getUsername());
    }

    @Test
    void testfindByTokenWhenNotExists() {
        // arrange
        UserServiceImpl spy = Mockito.spy(userService);
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        Mockito.when(userRepository.findByToken(ArgumentMatchers.any())).thenReturn(Optional.empty());
        Optional<org.springframework.security.core.userdetails.User> expect = Optional.empty();
        //act
        Optional<org.springframework.security.core.userdetails.User> result = this.userService.findByToken("1");
        //assert
        Assertions.assertEquals(expect.isEmpty(), result.isEmpty());
    }

    @Test
    void testUserAuthentication() {
        // arrange
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        Mockito.when(userRepository.userAuthentication(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(Optional.of(user));
        //act
        User result = this.userService.userAuthentication("1", "1");
        //assert
        Assertions.assertEquals(user.getRegistroAcademico(), result.getRegistroAcademico());
    }

    @Test
    void testGetByFiltering() {
        User usr = new User("1", "n1", "xxxxx", null, GeneroUsuario.N, "foto", "c1", RolUsuario.SUPER, "c1", EN_ESPERA);
        List<User> listaUsuarios = getUsersList(3);
        //arrange
        UserServiceImpl spy = Mockito.spy(userService);
        Mockito.when(userRepository.getUsersByFiltering(usr.getRegistroAcademico(), usr.getNombreCompleto(), usr.getCorreoElectronico())).thenReturn(listaUsuarios);
        //act
        List<User> resultList = (List<User>) spy.getByFiltering(usr);

        //assert
        Assertions.assertEquals(listaUsuarios.size(), resultList.size());
    }

    @Test
    void testGetByFiltering2() {
        User usr = new User(" ", " ", "xxxxx", null, GeneroUsuario.N, "foto", " ", RolUsuario.SUPER, "c1", EN_ESPERA);
        List<User> listaUsuarios = getUsersList(3);
        //arrange
        UserServiceImpl spy = Mockito.spy(userService);
        Mockito.when(userRepository.getUsersByFiltering(spy.NOT_VALUE, spy.NOT_VALUE, spy.NOT_VALUE)).thenReturn(listaUsuarios);
        //act
        List<User> resultList = (List<User>) spy.getByFiltering(usr);

        //assert
        Assertions.assertEquals(listaUsuarios.size(), resultList.size());
    }

    @Test
    void testGuardarImagen() throws IOException {
        //Arrange
        String fotoDePerfil = "foto.jpg";
        User usr = new User();
        usr.setFotoDePerfil(fotoDePerfil);
        UserServiceImpl spy = Mockito.spy(userService);
        String absolutePath = "src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png";
        byte[] bytesImg = this.recuperadorDeImagenesDeDisco.recuperarBytesDeImagen(absolutePath);
        Path rutaImagen = Paths.get(absolutePath);
        MockMultipartFile file = new MockMultipartFile("data", bytesImg);
        //Act
        Mockito.when(spy.guardarImagen(file)).thenReturn(usr);
        User expResult = usr;
        User result = spy.guardarImagen(file);
        //Assert
        Assertions.assertEquals(expResult, result);
    }

}
