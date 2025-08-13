package com.distribuida.controller;


import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Cliente;
import com.distribuida.model.Libro;
import com.distribuida.service.LibroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibroController.class)
public class LibroControllerTestIntegracion {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private LibroService libroService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFinAll() throws Exception {
        Libro libro = new Libro(1,"Las intermitencias de la muerte","Editorial Canminho",214,"Primera Edicion","Esp",new Date(),"Realismo Magico","Pasta blanda","ISBN 001",1000,"Las intermitencias de la muerte","ds","15.99",new Categoria(),new Autor());
        Mockito.when(libroService.findAll()).thenReturn(List.of(libro));

        mockMvc.perform(get("/Libros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Las intermitencias de la muerte"));

    }


    @Test
    public void testsave() throws  Exception {
        Libro libro = new Libro(1,"Las intermitencias de la muerte","Editorial Canminho",214,"Primera Edicion","Esp",new Date(),"Realismo Magico","Pasta blanda","ISBN 001",1000,"Las intermitencias de la muerte","ds","15.99",new Categoria(),new Autor());
        Mockito.when(libroService.save(any(Libro.class))).thenReturn(libro);

        mockMvc.perform(post("/Libros").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(libro)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Las intermitencias de la muerte"));

    }


    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/Libros/1")).andExpect(status().isNoContent());
    }
}
