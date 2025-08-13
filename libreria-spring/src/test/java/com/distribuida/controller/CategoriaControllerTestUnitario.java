package com.distribuida.controller;

import com.distribuida.model.Categoria;
import com.distribuida.service.CategoriaService;
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

public class CategoriaControllerTestUnitario {
    @InjectMocks
    private CategoriaController categoriaController;

    @Mock
    private CategoriaService categoriaService;

    private Categoria categoria;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        categoria = new Categoria();
        categoria.setIdCategoria(1);
        categoria.setCategoria("Novela");
        categoria.setDescripcion("Realismo magico");
    }

    @Test
    public void testFindAll(){
        when(categoriaService.findAll()).thenReturn(List.of(categoria));
        ResponseEntity<List<Categoria>> respuesta = categoriaController.findAll();
        assertEquals(200,respuesta.getStatusCodeValue());
        assertEquals(1, respuesta.getBody().size());
        verify(categoriaService,times(1)).findAll();
    }

    @Test
    public void testFinOneExistente(){
        when(categoriaService.findOne(1)).thenReturn(categoria);
        ResponseEntity<Categoria> respuesta = categoriaController.findOne(1);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(categoria.getCategoria(),respuesta.getBody().getCategoria());
        verify(categoriaService,times(1)).findOne(1);
    }

    @Test
    public void testFindOneNoExistente(){
        when(categoriaService.findOne(2)).thenReturn(null);
        ResponseEntity<Categoria> respuesta = categoriaController.findOne(2);
        assertEquals(404, respuesta.getStatusCodeValue());
        //verify(clienteService,times(0)).findOne(2);
    }

    @Test
    public void testSave(){
        when(categoriaService.save(any(Categoria.class))).thenReturn(categoria);
        ResponseEntity<Categoria> respuesta = categoriaController.save(categoria);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals("Novela",respuesta.getBody().getCategoria());
    }

    @Test
    public void testUpdateExistente(){
        when(categoriaService.update(eq(1),any(Categoria.class))).thenReturn(categoria);
        ResponseEntity<Categoria> respuesta = categoriaController.update(1,categoria);
        assertEquals(200,respuesta.getStatusCodeValue());
    }

    @Test
    public void testUpdateNoExistente(){
        when(categoriaService.update(eq(2),any(Categoria.class))).thenReturn(null);
        ResponseEntity<Categoria> respuesta = categoriaController.update(2,categoria);
        assertEquals(404,respuesta.getStatusCodeValue());
    }

    @Test
    public void testDelete(){
        doNothing().when(categoriaService).delete(1);
        ResponseEntity<Void> respuesta = categoriaController.delete(1);
        assertEquals(204,respuesta.getStatusCodeValue());
        verify(categoriaService,times(1)).delete(1);
    }
}
