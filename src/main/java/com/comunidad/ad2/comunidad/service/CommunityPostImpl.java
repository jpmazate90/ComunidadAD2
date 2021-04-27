package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.AuxObject.FiltrosComunityPost;
import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosCommunityPost;
import com.comunidad.ad2.comunidad.controllImage.DibujadorDeImagenesEnDisco;
import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.repository.CommunityPostRepository;
import static com.comunidad.ad2.comunidad.specifications.EspecificacionesPersonalizadas.*;


import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fabricio
 */
@Service
public class CommunityPostImpl implements CommunityPostService {

    private CommunityPostRepository communityPostRepository;
    private CreadorDeDirectoriosCommunityPost creadorDeDirectoriosCommunityPost;
    private DibujadorDeImagenesEnDisco dibujadorDeImagenes;
    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;
    private CommentPostService commenPostService;
    private ValorationPostService valorationPostService;

    @Autowired
    public CommunityPostImpl(CommunityPostRepository communityPostRepository, CommentPostService commenPostService, ValorationPostService valorationPostService) {
        this.communityPostRepository = communityPostRepository;
        this.creadorDeDirectoriosCommunityPost = new CreadorDeDirectoriosCommunityPost();
        this.dibujadorDeImagenes = new DibujadorDeImagenesEnDisco();
        this.recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
        this.commenPostService = commenPostService;
        this.valorationPostService = valorationPostService;
    }

    @Override
    public CommunityPost save(CommunityPost communityPost) {
        return this.communityPostRepository.save(communityPost);
    }

    //Agregar el like o dislike del usuario
    @Override
    public Iterable<CommunityPost> getAllCommunityPostByIdComunity(OrdinaryObject ordinaryObject) {
        List<CommunityPost> result = new LinkedList<>(this.communityPostRepository.getAllCommunityPostByIdComunity(ordinaryObject.getNumberParam()));
        for (CommunityPost post : result) {
            agregarFotoAComunidad(post);
        }
        this.commenPostService.addCommentsToPost(result);
        this.valorationPostService.addValoration(result, ordinaryObject.getStringParam());
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

//    public static Specification<CommunityPost> realizarFiltrosQuery(FiltrosComunityPost filtros) {
//        return (Root<CommunityPost> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//            if(filtros.getUsuario()!=null) {
//                predicates.add(builder.and(builder.equal(root.get("user.nombreCompleto"), filtros.getUsuario())));
//            }
//            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
//        };
//    }
    @Override
    public Iterable<CommunityPost> getAllCommunityPostByIdComunityWithFilters(FiltrosComunityPost filtros) {

        //List<CommunityPost> result = this.communityPostRepository.findAll(realizarFiltrosQuery(filtros));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<CommunityPost> result = new LinkedList<>(this.communityPostRepository.getAllCommunityPostByIdComunityWithFilters(filtros.getIdComunidad(), filtros.getUsuario(), filtros.getFechaInicial(), filtros.getFechaFinal()));
        for (CommunityPost post : result) {
            agregarFotoAComunidad(post);
        }
        this.commenPostService.addCommentsToPost(result);
        this.valorationPostService.addValoration(result, filtros.getRegistroAcademico());
        return result;
    }
        @Override
        public Iterable<CommunityPost> getAllCommunityPostByIdComunityWithDinamicFilters(FiltrosComunityPost filtros) {
        
            //List<CommunityPost> result = new LinkedList<>(this.communityPostRepository.findAll(Specification.where(filtros.getUsuario() == null ? null : contieneUsuario(filtros.getUsuario()))));
            List<CommunityPost> result = new LinkedList<>(this.communityPostRepository.findAll(Specification.where(
                    filtros.getFechaInicial().equals("") ? null : contieneFechaInicial(filtros.getFechaInicial()))
                    .and(filtros.getFechaFinal().equals("") ? null : contieneFechaFinal(filtros.getFechaFinal()))
                    .and(filtros.getUsuario().equals("") ? null : contieneUsuario(filtros.getUsuario()))
                    .and(contieneIdComunidad(filtros.getIdComunidad(),filtros.getValoracion()))
                    .and(esComunidadActiva()
                        .or(esComunidadPrivada())
                        )));
            for (CommunityPost post : result) {
            agregarFotoAComunidad(post);
        }
        this.commenPostService.addCommentsToPost(result);
        this.valorationPostService.addValoration(result, filtros.getRegistroAcademico());
        return result;
            
            
            
        }

    
}
