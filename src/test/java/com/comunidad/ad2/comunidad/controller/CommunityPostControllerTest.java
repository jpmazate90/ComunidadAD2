package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.CommunityPostService;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

/**
 *
 * @author fabricio
 */
@ExtendWith(MockitoExtension.class)
public class CommunityPostControllerTest {
    
    private CommunityPost communityPost;
    private Comunity comunity;
    private User user;

    @Mock
    private CommunityPostService communityPostService;
    
    @InjectMocks
    private CommunityPostController communityPostController;

    public CommunityPostControllerTest() {
        this.comunity = new Comunity(10);
        this.user = new User("201023214");
        this.communityPost = new CommunityPost(comunity, user, "title", "message", "photo");
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
    public void testCreate(){
        //Arrange
        CommunityPost post = this.communityPost;
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        //Act
        Mockito.when(this.communityPostService.save(post)).thenReturn(post);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body(this.communityPostService.save(post));
        ResponseEntity result = instance.create(post);
        //Assert
        assertEquals(expResult, result);
    }
    
        @Test
    public void testCreateError(){
        //Arrange
        CommunityPost post = this.communityPost;
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        //Act
        Mockito.when(this.communityPostService.save(post)).thenReturn(null);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE PUDO CREAR EL POST");;
        ResponseEntity result = instance.create(post);
        //Assert
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testGetAllCommunityPostByIdComunity() throws IOException{
        //Arrange
        int numParam = 10;
        String stringParam="111111111";
        OrdinaryObject input = new OrdinaryObject();
        input.setNumberParam(numParam);
        input.setStringParam(stringParam);
        List<CommunityPost> expListPost = getPostList(3);
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        Mockito.when(this.communityPostService.getAllCommunityPostByIdComunity(input)).thenReturn(expListPost);
        //Act
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(this.communityPostService.getAllCommunityPostByIdComunity(input));
        ResponseEntity result = instance.getAllCommunityPostByIdComunity(input);
        //Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUploadPostImage() throws IOException{
        //Arrange
        String photo = "src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png";
        CommunityPost post = this.communityPost;
        RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
        byte[] bytesImg = recuperadorDeImagenesDeDisco.recuperarBytesDeImagen(photo);
        MockMultipartFile file = new MockMultipartFile("Imagen", bytesImg);
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        post.setPhoto(photo);
        Mockito.when(this.communityPostService.savePostImage(file)).thenReturn(post);
        //Act
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(this.communityPostService.savePostImage(file));
        ResponseEntity result = instance.uploadPostImage(file);
        //Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUploadPostImageError() throws IOException{
        //Arrange
        String photo = "src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png";
        CommunityPost post = this.communityPost;
        RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
        byte[] bytesImg = recuperadorDeImagenesDeDisco.recuperarBytesDeImagen(photo);
        MockMultipartFile file = new MockMultipartFile("Imagen", bytesImg);
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        post.setPhoto(photo);
        Mockito.when(this.communityPostService.savePostImage(null)).thenReturn(null);
        //Act
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE RECIBIO LA IMAGEN");
        ResponseEntity result = instance.uploadPostImage(file);
        //Assert
        assertEquals(expResult, result);
    }
    
}
