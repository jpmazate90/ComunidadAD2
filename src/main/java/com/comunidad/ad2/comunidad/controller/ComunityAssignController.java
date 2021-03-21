/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.ComunityAssignService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jesfrin
 */
@CrossOrigin
@RestController
public class ComunityAssignController {

    private ComunityAssignService comunityAssignService;

    @Autowired
    public ComunityAssignController(ComunityAssignService comunityAssignService) {
        this.comunityAssignService = comunityAssignService;
    }

    /**
     * Permite crear una tupla que sera el intermedio entre Comunidad y Usuario
     *
     * @param comunityAssign
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/assignComunity")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> create(@RequestBody ComunityAssign comunityAssign) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comunityAssignService.save(comunityAssign));
    }

    /**
     * Permite buscar todas las comunidades que haya creado un usuario, ya sea
     * de COMUNIDAD, o SUPER
     *
     * @param user
     * @return
     * @throws IOException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findComunityByRegistroAcademico")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> findByRegistroAcademico(@RequestBody User user) throws IOException {
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("User registro academico:" + user.getRegistroAcademico());
        System.out.println("\n\n\n\n\n\n\n");
        //Iterable
        //Recuperar las fotos
        //Eniar el iterable
        Iterable<ComunityAssign> comunidadesAsignadas = this.comunityAssignService.findByRegistroAcademico(user.getRegistroAcademico());
        for (ComunityAssign comunityAssign : comunidadesAsignadas) {
            if (comunityAssign.getComunity().getFoto() != null) {
                Path rutaImagen = Paths.get(comunityAssign.getComunity().getFoto());//Ruta de la imagen
                byte[] imagenBytes = Files.readAllBytes(rutaImagen);
                comunityAssign.getComunity().setDatosFoto(imagenBytes);
            }

        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunidadesAsignadas);
    }

    /**
     * Permite buscar una comunidad por un ID
     *
     * @param com
     * @return
     * @throws IOException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findComunityById")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> findComunityById(@RequestBody Comunity com) throws IOException {
        System.out.println("\n\n\n\n\n");
        System.out.println(com.toString());
        System.out.println("\n\n\n\n\n");
        Optional<ComunityAssign> comunityFind = this.comunityAssignService.findByIdComunity(Integer.valueOf(com.getId()));
        if (comunityFind.isPresent()) {
            ComunityAssign comunityAssign = comunityFind.get();
            if (comunityAssign.getComunity().getFoto() != null) {
                Path rutaImagen = Paths.get(comunityAssign.getComunity().getFoto());//Ruta de la imagen
                byte[] imagenBytes = Files.readAllBytes(rutaImagen);
                comunityAssign.getComunity().setDatosFoto(imagenBytes);
            }
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunityAssign);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE ENCONTRO LA COMUNIDAD");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findMemberComunityById")
    public ResponseEntity<?> findMemberComunityById(@RequestBody ComunityAssign comRes) {
        
        System.out.println("\n\n\n\n\n\n");
        System.out.println("Id comunidad:"+comRes.getComunity().getId());
        System.out.println("Registro Academico:"+comRes.getUser().getRegistroAcademico());
        System.out.println("\n\n\n\n\n\n");
        Optional<ComunityAssign> comAsig = this.comunityAssignService.findByIdComunityMiembro(comRes.getComunity().getId(),comRes.getUser().getRegistroAcademico());
        if (comAsig.isPresent()) {
            ComunityAssign comSend = comAsig.get();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(comSend);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE ENCONTRO LA SUSCRIPCION A LA COMUNIDAD");
    }

}
