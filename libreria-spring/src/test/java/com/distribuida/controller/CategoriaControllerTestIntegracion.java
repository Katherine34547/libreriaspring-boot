package com.distribuida.controller;

import com.distribuida.model.Categoria;
import com.distribuida.service.CategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoriaController.class)
public class CategoriaControllerTestIntegracion {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CategoriaService categoriaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFinAll() throws Exception {
        Categoria categoria = new Categoria(1,"Novelas","Novelas romanticas");
        Mockito.when(categoriaService.findAll()).thenReturn(List.of(categoria));

        mockMvc.perform(get("/api/Categorias"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].categoria").value("Novelas"));

    }


    @Test
    public void testsave() throws  Exception {
        Categoria categoria = new Categoria(0,"Novelas","Novelas romanticas");
        Mockito.when(categoriaService.save(any(Categoria.class))).thenReturn(categoria);

        mockMvc.perform(post("/api/Categorias").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(categoria)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoria").value("Novelas"));

    }


    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/api/Categorias/1")).andExpect(status().isNoContent());
    }
}

