/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import com.comunidad.ad2.comunidad.service.enums.GeneroUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import com.comunidad.ad2.comunidad.service.enums.Visibilidad;
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
public class UserTest {

    public static final String REGISTRO_ACADEMICO = "12345678";
    public static final String NOMBRE_COMPLETO = "Carlos";
    public static final String PASSWORD = "1234";
    public static final Timestamp FECHA_DE_NACIMIENTO = new Timestamp(System.currentTimeMillis());
    public static final GeneroUsuario GENERO_USUARIO = GeneroUsuario.M;
    public static final String FOTO_DE_PERFIL = "foto";
    public static final String CORREO_ELECTRONICO = "correo@correo.com";
    public static final RolUsuario ROL_USUARIO = RolUsuario.COMUNIDAD;
    public static final String CIUDAD = "Guatemala";
    public static final EstadoUsuario ESTADO_USUARIO = EstadoUsuario.ACTIVO;
    public static final String TOKEN = "MI_TOKEN";
    public static final Visibilidad VISIBILIDAD = Visibilidad.PUBLICO;
    private User user;

    public UserTest() {
        this.user = new User(REGISTRO_ACADEMICO, NOMBRE_COMPLETO, PASSWORD, FECHA_DE_NACIMIENTO, GENERO_USUARIO, FOTO_DE_PERFIL, CORREO_ELECTRONICO, ROL_USUARIO, CIUDAD, ESTADO_USUARIO, TOKEN, VISIBILIDAD);
    }

    /**
     * Test of getRegistroAcademico method, of class User.
     */
    @Test
    public void testGetRegistroAcademico() {
        //Act
        System.out.println("getRegistroAcademico");
        User instance = this.user;
        //Arrange
        String expResult = REGISTRO_ACADEMICO;
        String result = instance.getRegistroAcademico();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setRegistroAcademico method, of class User.
     */
    @Test
    public void testSetRegistroAcademico() {
        //Act
        System.out.println("getRegistroAcademico");
        User instance = this.user;
        String nuevoRegistroAcademico = "852147";
        //Arrange
        instance.setRegistroAcademico(nuevoRegistroAcademico);
        String expResult = nuevoRegistroAcademico;
        String result = instance.getRegistroAcademico();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of getNombreCompleto method, of class User.
     */
    @Test
    public void testGetNombreCompleto() {
        //Act
        System.out.println("getNombreCompleto");
        User instance = this.user;
        //Assert
        String expResult = NOMBRE_COMPLETO;
        String result = instance.getNombreCompleto();
        //Arrange
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setNombreCompleto method, of class User.
     */
    @Test
    public void testSetNombreCompleto() {
        //Act
        System.out.println("getNombreCompleto");
        User instance = this.user;
        String nuevoNombre = "Nuevo nombre";
        //Assert
        instance.setNombreCompleto(nuevoNombre);
        String expResult = nuevoNombre;
        String result = instance.getNombreCompleto();
        //Arrange
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        //Act
        System.out.println("getPassword");
        User instance = this.user;
        //Assert
        String expResult = PASSWORD;
        String result = instance.getPassword();
        //Arrange
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        //Act
        System.out.println("SetPassword");
        User instance = this.user;
        String newPassword = "741";
        //Assert
        instance.setPassword(newPassword);
        String expResult = newPassword;
        String result = instance.getPassword();
        //Arrange
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getFechaDeNacimiento method, of class User.
     */
    @Test
    public void testGetFechaDeNacimiento() {
        //Act
        System.out.println("getFechaDeNacimiento");
        User instance = this.user;
        //Arrange
        Timestamp expResult = FECHA_DE_NACIMIENTO;
        Timestamp result = instance.getFechaDeNacimiento();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setFechaDeNacimiento method, of class User.
     */
    @Test
    public void testSetFechaDeNacimiento() {
        //Act
        System.out.println("SetFechaDeNacimiento");
        User instance = this.user;
        Timestamp nuevaFecha = new Timestamp(System.currentTimeMillis());
        //Arrange
        instance.setFechaDeNacimiento(nuevaFecha);
        Timestamp expResult = nuevaFecha;
        Timestamp result = instance.getFechaDeNacimiento();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getGenero method, of class User.
     */
    @Test
    public void testGetGenero() {
        //Act
        System.out.println("getGenero");
        User instance = this.user;
        //Arrange
        GeneroUsuario expResult = GENERO_USUARIO;
        GeneroUsuario result = instance.getGenero();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setGenero method, of class User.
     */
    @Test
    public void testSetGenero() {
        //Act
        System.out.println("setGenero");
        User instance = this.user;
        GeneroUsuario nuevoGenero = GeneroUsuario.N;
        //Arrange
        instance.setGenero(nuevoGenero);
        GeneroUsuario expResult = nuevoGenero;
        GeneroUsuario result = instance.getGenero();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of getFotoDePerfil method, of class User.
     */
    @Test
    public void testGetFotoDePerfil() {
        //Act
        System.out.println("getFotoDePerfil");
        User instance = this.user;
        //Arrange
        String expResult = FOTO_DE_PERFIL;
        String result = instance.getFotoDePerfil();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of setFotoDePerfil method, of class User.
     */
    @Test
    public void testSetFotoDePerfil() {
        //Act
        System.out.println("getFotoDePerfil");
        User instance = this.user;
        String nuevaFotoDePerfil = "/NuevaFoto";
        //Arrange
        instance.setFotoDePerfil(nuevaFotoDePerfil);
        String expResult = nuevaFotoDePerfil;
        String result = instance.getFotoDePerfil();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getCorreoElectronico method, of class User.
     */
    @Test
    public void testGetCorreoElectronico() {
        //Act
        System.out.println("getCorreoElectronico");
        User instance = this.user;
        //Arrange
        String expResult = CORREO_ELECTRONICO;
        String result = instance.getCorreoElectronico();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setCorreoElectronico method, of class User.
     */
    @Test
    public void testSetCorreoElectronico() {
        //Act
        System.out.println("setCorreoElectronico");
        User instance = this.user;
        String nuevoCorreo = "c@gmail.com";
        //Arrange
        instance.setCorreoElectronico(nuevoCorreo);
        String expResult = nuevoCorreo;
        String result = instance.getCorreoElectronico();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of getRolUsuario method, of class User.
     */
    @Test
    public void testGetRolUsuario() {
        //Act
        System.out.println("getRolUsuario");
        User instance = this.user;
        //Arrange
        RolUsuario expResult = ROL_USUARIO;
        RolUsuario result = instance.getRolUsuario();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setRolUsuario method, of class User.
     */
    @Test
    public void testSetRolUsuario() {
        //Act
        System.out.println("getRolUsuario");
        User instance = this.user;
        RolUsuario nuevoRol = RolUsuario.SUPER;
        //Arrange
        instance.setRolUsuario(nuevoRol);
        RolUsuario expResult = nuevoRol;
        RolUsuario result = instance.getRolUsuario();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getCiudad method, of class User.
     */
    @Test
    public void testGetCiudad() {
        //Act
        System.out.println("getCiudad");
        User instance = this.user;
        //Arrange
        String expResult = CIUDAD;
        String result = instance.getCiudad();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setCiudad method, of class User.
     */
    @Test
    public void testSetCiudad() {
        //Act
        System.out.println("setCiudad");
        User instance = this.user;
        String nuevaCiudad="Nueva ciudad";
        //Arrange
        instance.setCiudad(nuevaCiudad);
        String expResult = nuevaCiudad;
        String result = instance.getCiudad();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstado method, of class User.
     */
    @Test
    public void testGetEstado() {
        //Act
        System.out.println("getEstado");
        User instance = this.user;
        //Arrange
        EstadoUsuario expResult = ESTADO_USUARIO;
        EstadoUsuario result = instance.getEstado();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setEstado method, of class User.
     */
    @Test
    public void testSetEstado() {
        //Act
        System.out.println("setEstado");
        User instance = this.user;
        EstadoUsuario nuevoEstado = EstadoUsuario.EN_ESPERA;
        //Arrange
        instance.setEstado(nuevoEstado);
        EstadoUsuario expResult = nuevoEstado;
        EstadoUsuario result = instance.getEstado();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getToken method, of class User.
     */
    @Test
    public void testGetToken() {
        //Act
        System.out.println("getToken");
        User instance = this.user;
        //Arrange
        String expResult = TOKEN;
        String result = instance.getToken();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setToken method, of class User.
     */
    @Test
    public void testSetToken() {
        //Act
        System.out.println("getToken");
        User instance = this.user;
        String nuevoToken="NuevoToken";
        //Arrange
        instance.setToken(nuevoToken);
        String expResult = nuevoToken;
        String result = instance.getToken();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrivacidad method, of class User.
     */
    @Test
    public void testGetPrivacidad() {
        //Act
        System.out.println("getPrivacidad");
        User instance = this.user;
        //Arrange
        Visibilidad expResult = VISIBILIDAD;
        Visibilidad result = instance.getPrivacidad();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setPrivacidad method, of class User.
     */
    @Test
    public void testSetPrivacidad() {
        //Act
        System.out.println("setPrivacidad");
        User instance = this.user;
        Visibilidad nuevaVisibilidad=Visibilidad.PRIVADO;
        //Arrange
        instance.setPrivacidad(nuevaVisibilidad);
        Visibilidad expResult = nuevaVisibilidad;
        Visibilidad result = instance.getPrivacidad();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        //Act
        System.out.println("toString");
        User instance = this.user;
        //Arrange
        String expResult = "User{" + "registroAcademico=" + REGISTRO_ACADEMICO + ", nombreCompleto=" + NOMBRE_COMPLETO + ", password=" + PASSWORD + ", fechaDeNacimiento=" + FECHA_DE_NACIMIENTO + ", genero=" + GENERO_USUARIO + ", fotoDePerfil=" + FOTO_DE_PERFIL + ", correoElectronico=" + CORREO_ELECTRONICO + ", rolUsuario=" + ROL_USUARIO + ", ciudad=" + CIUDAD + ", estado=" + ESTADO_USUARIO + ", token=" + TOKEN + ", privacidad=" + VISIBILIDAD + '}';
        String result = instance.toString();
        //Assert
        assertEquals(expResult, result);

    }
    
    @Test
    public void testConstructorRegistroAcademicoPassword(){
        //Act
        User user = new User(REGISTRO_ACADEMICO, PASSWORD);
        //Arrange
        String expResult=REGISTRO_ACADEMICO;
        String result=user.getRegistroAcademico();
        //Assert
        assertEquals(expResult, result);
    }

}
