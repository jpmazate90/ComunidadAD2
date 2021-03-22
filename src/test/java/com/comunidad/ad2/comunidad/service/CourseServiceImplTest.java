/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.comunidad.ad2.comunidad.entity.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentMatchers;
/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {
    
    public static final String CODIGO_DE_CURSO="000";
    //public static final List<Course> cursos= crearListaDeCursos();
   // public static final Course curso = new Course(CODIGO_DE_CURSO);
    
    @Mock
    private CourseRepository courseRepository;
    
    @InjectMocks
    private CourseImpl courseImpl;//Se crea un CourseIMpl y se le inyecta un CourseRepository
    
    public CourseServiceImplTest(){
        
    }
    
    //Test para recuperar todos los cursos
    @Test
    public void testFindAll(){
        //arrange
        
        CourseImpl spy = Mockito.spy(courseImpl);
        Mockito.when(courseRepository.findAll()).thenReturn(crearListaDeCursos());
        //act
        Iterable<Course> misCursos = spy.findAll();
        ArrayList<Course> resultado =(ArrayList<Course>)misCursos;
        //assert
        Assertions.assertEquals(CODIGO_DE_CURSO,(resultado.get(0).getCodigoDeCurso()));
        //Assertions.assertEquals(CODIGO_DE_CURSO,"HOLA");

    }
    
    @Test
    public void testFindById(){
        //arrange
        Mockito.when(courseRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.of(new Course("1")));
        //act
        Optional<Course> curso = Optional.of(new Course("1"));
        Optional<Course> result = this.courseImpl.findById("1");
        //assert
        Assertions.assertEquals(result.get().getCodigoDeCurso(),curso.get().getCodigoDeCurso());
        //Assertions.assertEquals(CODIGO_DE_CURSO,"HOLA");

    }
    
    public  List<Course> crearListaDeCursos(){
         List<Course> courses= new ArrayList<>();
         courses.add(new Course(CODIGO_DE_CURSO));
         return courses;
    }

    
    
    
    
}
