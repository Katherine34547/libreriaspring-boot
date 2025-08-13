package com.distribuida.controller;

import com.distribuida.model.Libro;
import com.distribuida.service.LibroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class LibroControllerTestUnitario {
    @InjectMocks
    private LibroController libroController;

    @Mock
    private LibroService libroService;

    private Libro libro;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        libro = new Libro();
        libro.setIdLibro(1);
        libro.setDescripcion("Novelas");
        libro.setEdicion("Jose");
        libro.setEditorial("");
        libro.setIdioma("Conocoto");
        libro.setIdioma("0988329455");
        libro.setIsbn("juanHer35@gmail.com");
        libro.setNumEjemplares(11);
        libro.setNumPaginas(110);
        libro.setPortada("juanHer35@gmail.com");
        libro.setPrecio("juanHer35@gmail.com");
        libro.setPresentacion("");
        libro.setTitulo("Las intermitencias de la muerte");
        libro.setTipoPasta("juanHer35@gmail.com");
    }

    @Test
    public void testFindAll(){
        when(libroService.findAll()).thenReturn(List.of(libro));
        ResponseEntity<List<Libro>> respuesta = libroController.findALL();
        assertEquals(200,respuesta.getStatusCodeValue());
        assertEquals(1, respuesta.getBody().size());
        verify(libroService,times(1)).findAll();
    }

    @Test
    public void testFinOneExistente(){
        when(libroService.findOne(1)).thenReturn(libro);
        ResponseEntity<Libro> respuesta = libroController.findOne(1);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(libro.getTitulo(),respuesta.getBody().getTitulo());
        verify(libroService,times(1)).findOne(1);
    }

    @Test
    public void testFindOneNoExistente(){
        when(libroService.findOne(2)).thenReturn(null);
        ResponseEntity<Libro> respuesta = libroController.findOne(2);
        assertEquals(404, respuesta.getStatusCodeValue());
        //verify(clienteService,times(0)).findOne(2);
    }

    @Test
    public void testSave(){
        when(libroService.save(any(Libro.class))).thenReturn(libro);
        ResponseEntity<Libro> respuesta = libroController.save(libro);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals("Las intermitencias de la muerte",respuesta.getBody().getTitulo());
    }

    @Test
    public void testUpdateExistente(){
        when(libroService.update(eq(1),any(Libro.class))).thenReturn(libro);
        ResponseEntity<Libro> respuesta = libroController.update(1,libro);
        assertEquals(200,respuesta.getStatusCodeValue());
    }

    @Test
    public void testUpdateNoExistente(){
        when(libroService.update(eq(2),any(Libro.class))).thenReturn(null);
        ResponseEntity<Libro> respuesta = libroController.update(2,libro);
        assertEquals(404,respuesta.getStatusCodeValue());
    }

    @Test
    public void testDelete(){
        doNothing().when(libroService).delete(1);
        ResponseEntity<Void> respuesta = libroController.delete(1);
        assertEquals(204,respuesta.getStatusCodeValue());
        verify(libroService,times(1)).delete(1);
    }

}
