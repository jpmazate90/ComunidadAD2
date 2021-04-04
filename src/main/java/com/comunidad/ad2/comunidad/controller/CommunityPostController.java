package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.service.CommunityPostService;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fabricio
 */
@CrossOrigin()
@RestController
public class CommunityPostController {
    
    private CommunityPostService communityPostService;

    @Autowired
    public CommunityPostController(CommunityPostService communityPostService) {
        this.communityPostService = communityPostService;
    }
    
    /**
     * 
     * @param comunityPost
     * @return 
     */
    @PostMapping("/api/community/post/create")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> create(@RequestBody CommunityPost comunityPost) {
        CommunityPost postFind = this.communityPostService.save(comunityPost);
        if(postFind != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(this.communityPostService.save(comunityPost));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE PUDO CREAR EL POST");
    }
    
    /**
     * 
     * @param params
     * @return
     * @throws IOException 
     */
    @PostMapping("/api/community/post/get/allByCommunity")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> getAllCommunityPostByIdComunity(@RequestBody OrdinaryObject params) throws IOException {
        Iterable<CommunityPost> communityPost = this.communityPostService.getAllCommunityPostByIdComunity(params.getNumberParam());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(communityPost);
    }
    
    @PostMapping("/api/community/post/upload/images")
    public ResponseEntity<?> uploadPostImage(@RequestBody MultipartFile file) {
        try {
            CommunityPost post = this.communityPostService.savePostImage(file);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(post);//Si se crea la entidad Imagen, devolver el objeto de tipo imagen
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE RECIBIO LA IMAGEN");
        }
    }
    
}
