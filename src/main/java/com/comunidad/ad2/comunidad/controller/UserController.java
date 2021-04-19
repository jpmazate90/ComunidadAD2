/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.AuxObject.NumeroCarnet;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jpmazate
 */
@CrossOrigin()
@RestController
//@RequestMapping("/api/users")
public class UserController {

    //@ComponentScan("com.comunidad.ad2.comunidad.service")
    private UserService userService;

   
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/creation/users")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<Object> create(@RequestBody User user) {
        if (userService.findById(user.getRegistroAcademico()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("YA EXISTE EL USUARIO");
        }
    }

    @PostMapping("/api/users/authentication")
    public ResponseEntity<User> authentication(@RequestBody User user) {//Recibe un user, donde se incluira el registro academico y el usuario
        //Este user trae el registroAcademico y la contrasenia
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.userAuthentication(user.getRegistroAcademico(), user.getPassword()));

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findbytoken")
    public ResponseEntity<Object> findUserByToken(@RequestBody User token) {//Recibe un user, donde se incluira el registro academico y el usuario
        //Este user trae el registroAcademico y la contrasenia
        Optional<User> user = userService.findByTokenOwnUser(token.getToken());
        if (user.isPresent()) {
            return ResponseEntity.ok(user);

        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO EXISTE EL TOKEN DE AUTENTICACION");

    }

    @PostMapping("/api/users/adminCreation")
    public ResponseEntity<Integer> adminCreation(@RequestBody User user) {//Recibe un user, donde se incluira el registro academico y el usuario
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.adminCreation(user.getRegistroAcademico()));
    }

    @PostMapping("/api/users/changePassword")
    public ResponseEntity<Integer> changePassword(@RequestBody User user) {//Recibe un user, donde se incluira el registro academico y el usuario
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.changePasswordUser(user.getRegistroAcademico(), user.getPassword()));
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<Optional<User>> read(@PathVariable(value = "id") String userId) {
        Optional<User> oUser = userService.findById(userId);
        if (!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);
    }

    @PostMapping("/api/users/byFiltering")
    public ResponseEntity<Iterable<User>> getByFiltering(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.getByFiltering(user));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/accounts")
    public ResponseEntity<Iterable<User>> all() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @Autowired
    public UserController(@Autowired UserService userService, @Autowired TokenController tokenController) {
        this.userService = userService;
        
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/update/user")
    public ResponseEntity<Object> actualizarDatosUser(@RequestBody User user) {
        if (userService.findById(user.getRegistroAcademico()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.actualizarDatosUser(user));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("NO EXISTE NINGUN USUARIO CON LOS DATOS: " + user);
        }
    }

    @PostMapping("/api/users/search")
    public ResponseEntity<Iterable<User>> getUsersBySearch(@RequestBody OrdinaryObject searchObject) {
        return ResponseEntity.ok(this.userService.getUsersBySearch(searchObject.getStringParam().trim()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/filtrarUsuarios")
    public ResponseEntity<Iterable<User>> filtrarUsuarios(@RequestBody NumeroCarnet carnet) {
        return ResponseEntity.ok(userService.filtrarUsuarios(carnet.getNumeroDeCarnet()));
    }

    @PostMapping("/api/users/find/byId")
    public ResponseEntity<Object> findUserById(@RequestBody User usr) {//Recibe un user, donde se incluira el registro academico y el usuario
        Optional<User> user = userService.findById(usr.getRegistroAcademico());
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO EXISTE EL TOKEN DE AUTENTICACION");

    }

    @PostMapping("/api/users/upload/images/profile")
    public ResponseEntity<Object> uploadImage(@RequestBody MultipartFile file) {
        try {
            User usr = this.userService.guardarImagen(file);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usr);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE RECIBIO LA IMAGEN");
        }
    }

}
