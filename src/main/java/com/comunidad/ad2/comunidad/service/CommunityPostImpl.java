package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosCommunityPost;
import com.comunidad.ad2.comunidad.controllImage.DibujadorDeImagenesEnDisco;
import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.repository.CommunityPostRepository;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fabricio
 */
@Service
public class CommunityPostImpl implements CommunityPostService {

    private CommunityPostRepository CommunityPostRepository;
    private CreadorDeDirectoriosCommunityPost creadorDeDirectoriosCommunityPost;
    private DibujadorDeImagenesEnDisco dibujadorDeImagenes;
    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;
    private CommentPostServiceImpl commenPostServiceImpl;
    
    @Autowired
    public CommunityPostImpl(CommunityPostRepository communityPostRepository,CommentPostServiceImpl commenPostServiceImpl) {
        this.CommunityPostRepository = communityPostRepository;
        this.creadorDeDirectoriosCommunityPost = new CreadorDeDirectoriosCommunityPost();
        this.dibujadorDeImagenes = new DibujadorDeImagenesEnDisco();
        this.recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
        this.commenPostServiceImpl = commenPostServiceImpl;
    }

    @Override
    public CommunityPost save(CommunityPost communityPost) {
        return this.CommunityPostRepository.save(communityPost);
    }

    @Override
    public Iterable<CommunityPost> getAllCommunityPostByIdComunity(int idComunidad) {
        List<CommunityPost> result = new LinkedList<>(this.CommunityPostRepository.getAllCommunityPostByIdComunity(idComunidad));
        for (CommunityPost post : result) {
            agregarFotoAComunidad(post);
        }
        this.commenPostServiceImpl.addCommentsToPost(result);
        return result;
    }

    @Override
    public CommunityPost savePostImage(MultipartFile file) throws IOException {
        CommunityPost post = new CommunityPost();
        this.creadorDeDirectoriosCommunityPost.createDirectory();
        Path rutaImagen = this.creadorDeDirectoriosCommunityPost.getPathOfImage(file.getOriginalFilename());
        this.dibujadorDeImagenes.dibujarImagen(file.getBytes(), rutaImagen);
        post.setPhoto(rutaImagen.toString());
        return post;
    }

    public CommunityPost agregarFotoAComunidad(CommunityPost comunityPost) {
        if (comunityPost.getPhoto() != null) {
            String foto;
            byte[] datosFoto;
            foto = comunityPost.getPhoto();
            datosFoto = this.recuperadorDeImagenesDeDisco.recuperarBytesDeImagen(foto);
            comunityPost.setDatosFoto(datosFoto);
            return comunityPost;
        } else {
            return comunityPost;
        }
    }

}
