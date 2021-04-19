/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import com.comunidad.ad2.comunidad.service.enums.GeneroUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import java.sql.Timestamp;

/**
 *
 * @author jpmazate
 */
public class CreacionUsuarioParaPruebas {

    private CreacionUsuarioParaPruebas() {
        throw new IllegalStateException("Utility class");
    }

    public static User crearUsuario(RolUsuario a) {
        return new User("201029301", "aaa", "aaa", new Timestamp(400000000), GeneroUsuario.N, "aa", "aa@a.com", a, "xela", EstadoUsuario.ACTIVO);
    }
}
