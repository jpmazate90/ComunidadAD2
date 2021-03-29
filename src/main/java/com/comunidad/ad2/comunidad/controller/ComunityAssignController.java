/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.ComunityAssignFilters;
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
    public ResponseEntity<?> findComunityTypeAdminitrationByRegistroAcademico(@RequestBody User user) throws IOException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.comunityAssignService.findComunityTypeAdminitrationByRegistroAcademico(user.getRegistroAcademico()));
    }

    /**
     * Permite buscar el creador de una comunidad por ID
     *
     * @param com
     * @return
     * @throws IOException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findComunityById")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> findComunityOwnerByIdComunity(@RequestBody Comunity com) throws IOException {
        Optional<ComunityAssign> comunityFind = this.comunityAssignService.findComunityOwnerByIdComunity(Integer.valueOf(com.getId()));
        if (comunityFind.isPresent()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunityFind.get());
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE ENCONTRO LA COMUNIDAD");
    }

    /**
     * Permite buscar un usuario y la comunidad donde es miembro, segun id de comunidad
     * @param comRes
     * @return 
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findMemberComunityById")
    public ResponseEntity<?> findMemberComunityById(@RequestBody ComunityAssign comRes) {
        Optional<ComunityAssign> comAsig = this.comunityAssignService.findByIdComunityMiembro(comRes.getComunity().getId(), comRes.getUser().getRegistroAcademico());
        if (comAsig.isPresent()) {
            ComunityAssign comSend = comAsig.get();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(comSend);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE ENCONTRO LA SUSCRIPCION A LA COMUNIDAD");
    }


    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/comunity/filtrarSolicitudesComunidades")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> findComunityAsignsByIdComunity(@RequestBody ComunityAssignFilters filters) throws IOException {
        System.out.println("\n\n\n\n\n");
        System.out.println(filters.toString());
        System.out.println("\n\n\n\n\n");
        Iterable<ComunityAssign> comunityFind = this.comunityAssignService.findRequestInEspera(filters.getIdComunidad(), filters.getRegistroAcademico());
      
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunityFind);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/updateStateComunityRequest")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> updateStateComunityRequest(@RequestBody ComunityAssign comunityAssign) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comunityAssignService.save(comunityAssign));
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findUserComunitys")
    public ResponseEntity<?> findUserComunitys(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.comunityAssignService.findUserComunitys(user.getRegistroAcademico()));
    }
    

}
