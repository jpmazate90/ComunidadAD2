package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.CommunityPostRepository;
import com.comunidad.ad2.comunidad.service.enums.CommunityPostState;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.mock.web.MockMultipartFile;

/**
 *
 * @author fabricio
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CommunityPostImplTest {

    @Mock
    private CommunityPostRepository communityPostRepository;  // es el mock
    
    @Mock
    private ValorationPostService valorationPostService;
    
    @InjectMocks
    private CommunityPostImpl communityPostImpl;
    
    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;

    public CommunityPostImplTest() {
        this.recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
    }
    
    private CommunityPost createCommunityPost(){
        return new CommunityPost();
    }
    
    private List<CommunityPost> getPostList(int sizeList){
        List<CommunityPost> result = new LinkedList<>();
        for (int i = 0; i < sizeList; i++) {
            result.add(createCommunityPost());
        }
        return result;
    }
    
    @Test
    public void testSave(){
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
    public void testSavePostImage() throws IOException{
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
        Assertions.assertEquals(expResult,result);
    }
    
   @Test
    public void testGetAllCommunityPostByIdComunity(){
        //Arrange
        OrdinaryObject ordinaryObject = new OrdinaryObject();
        ordinaryObject.setNumberParam(10);
        ordinaryObject.setStringParam("111111111");
        List<CommunityPost> expListPost = getPostList(3);
        CommunityPostImpl spy = Mockito.spy(this.communityPostImpl);
        //Act
        Mockito.when(spy.getAllCommunityPostByIdComunity(ordinaryObject)).thenReturn(expListPost);
        //List<CommunityPost> result = (List <CommunityPost>) spy.getAllCommunityPostByIdComunity(ordinaryObject);
        //Assert
        assertEquals(expListPost, expListPost);
    }
    
    
    @Test
    public void testAgregarFotoAComunidad(){
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
    
}
