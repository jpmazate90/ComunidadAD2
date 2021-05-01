package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.AuxObject.FiltrosComunityPost;
import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.repository.CommunityPostRepository;
import static com.comunidad.ad2.comunidad.specifications.EspecificacionesPersonalizadas.contieneFechaFinal;
import static com.comunidad.ad2.comunidad.specifications.EspecificacionesPersonalizadas.contieneFechaInicial;
import static com.comunidad.ad2.comunidad.specifications.EspecificacionesPersonalizadas.contieneIdComunidad;
import static com.comunidad.ad2.comunidad.specifications.EspecificacionesPersonalizadas.contieneUsuario;
import static com.comunidad.ad2.comunidad.specifications.EspecificacionesPersonalizadas.esComunidadActiva;
import static com.comunidad.ad2.comunidad.specifications.EspecificacionesPersonalizadas.esComunidadPrivada;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.mock.web.MockMultipartFile;

/**
 *
 * @author fabricio
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CommunityPostImplTest {

    @Mock
    private CommunityPostRepository communityPostRepository;  // es el mock

    @Mock
    private ValorationPostService valorationPostService;

    @Mock
    private CommentPostService commentPostService;

    @InjectMocks
    private CommunityPostImpl communityPostImpl;

    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;

    public CommunityPostImplTest() {
        this.recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
    }

    private CommunityPost createCommunityPost() {
        return new CommunityPost();
    }

    private List<CommunityPost> getPostList(int sizeList) {
        List<CommunityPost> result = new LinkedList<>();
        for (int i = 0; i < sizeList; i++) {
            result.add(createCommunityPost());
        }
        return result;
    }

    @Test
    void testSave() {
        //Arrange
        int rated = 0;
        CommunityPost post = createCommunityPost();
        CommunityPostImpl spy = Mockito.spy(this.communityPostImpl);
        when(communityPostRepository.save(post)).thenReturn(post);
        //Act
        CommunityPost result = spy.save(post);
        //Assert
        assertEquals(post.getRated(), rated);
    }

    @Test
    void testSavePostImage() throws IOException {
        //Arrange
        String fotoDePerfil = "foto.jpg";
        CommunityPost post = new CommunityPost();
        post.setPhoto(fotoDePerfil);
        CommunityPostImpl spy = Mockito.spy(this.communityPostImpl);
        String absolutePath = "src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png";
        byte[] bytesImg = this.recuperadorDeImagenesDeDisco.recuperarBytesDeImagen(absolutePath);
        Path rutaImagen = Paths.get(absolutePath);
        MockMultipartFile file = new MockMultipartFile("data", bytesImg);
        //Act
        Mockito.when(spy.savePostImage(file)).thenReturn(post);
        CommunityPost expResult = post;
        CommunityPost result = spy.savePostImage(file);
        //Assert
        Assertions.assertEquals(expResult, result);
    }

    @Test
    void testGetAllCommunityPostByIdComunity() {
        //Arrange
        OrdinaryObject ordinaryObject = new OrdinaryObject();
        ordinaryObject.setNumberParam(10);
        ordinaryObject.setStringParam("111111111");
        List<CommunityPost> expListPost = getPostList(3);
        CommunityPostImpl spy = Mockito.spy(this.communityPostImpl);
        //Act
        Mockito.when(this.communityPostRepository.getAllCommunityPostByIdComunity(10)).thenReturn(expListPost);
        List<CommunityPost> result = (List<CommunityPost>) spy.getAllCommunityPostByIdComunity(ordinaryObject);
        //Assert
        assertEquals(expListPost, result);
    }

    @Test
    void testAgregarFotoAComunidad() {
        //Arrange
        byte[] datosFoto = "DatosFoto".getBytes();
        String photo = "foto.jpg";
        CommunityPost input = createCommunityPost();
        input.setPhoto(photo);
        CommunityPost expResult = createCommunityPost();
        expResult.setDatosFoto(datosFoto);
        expResult.setPhoto(photo);
        CommunityPostImpl spy = Mockito.spy(this.communityPostImpl);
        //Act
        Mockito.when(spy.agregarFotoAComunidad(input)).thenReturn(expResult);
        CommunityPost result = spy.agregarFotoAComunidad(input);
        //Assert
        assertEquals(expResult.getDatosFoto(), result.getDatosFoto());
    }
    
    @Test
    void testGetAllCommunityPostByIdComunityWithFilters(){
        //Arrange
        int numParam = 10;
        String stringParam = "111111111";
        
        FiltrosComunityPost filtros = new FiltrosComunityPost(numParam, stringParam, "", "", "","");
        List<CommunityPost> expListPost = getPostList(0);
        //Act
        Mockito.when(this.communityPostRepository.findAll()).thenReturn(expListPost);
        
        Mockito.doNothing().when(this.commentPostService).addCommentsToPost(expListPost);
        Mockito.when(this.valorationPostService.addValoration(expListPost, filtros.getRegistroAcademico())).thenReturn(expListPost);
        //Mockito.when(this.communityPostImpl.agregarFotoAComunidad(expListPost.get(0))).thenReturn(expListPost.get(0));
        
        
        
        List<CommunityPost> result = (List <CommunityPost>) this.communityPostImpl.getAllCommunityPostByIdComunityWithFilters(filtros);
        //Assert
        assertEquals(expListPost.size(), result.size());
    }
    

    @Test
    void testDeletedCommunityPost() {
        int idComunityPost = 1;
        int enteroADevolver = 0;
        Mockito.when(this.communityPostRepository.deletedCommunityPost(idComunityPost)).thenReturn(enteroADevolver);
        CommunityPostImpl instance = Mockito.spy(this.communityPostImpl);
        int expResult = enteroADevolver;
        int result = instance.deletedCommunityPost(idComunityPost);
        assertEquals(expResult, result);
    }

    @Test
    void testGetComunityPostById() {
        //Arrange
        int idComunityPost = 0;
        CommunityPostImpl instance = Mockito.spy(this.communityPostImpl);
        CommunityPost communityPost = new CommunityPost();
        communityPost.setId(idComunityPost);
        Mockito.when(this.communityPostRepository.getComunityPostById(idComunityPost)).thenReturn(Optional.of(communityPost));
        CommunityPost expResult = communityPost;
        CommunityPost result = instance.getComunityPostById(idComunityPost).get();
        assertEquals(expResult.getId(), result.getId());
    }

}
