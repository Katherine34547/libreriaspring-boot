package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.service.AutorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AutorController.class)
public class AutorControllerTestIntegracion {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AutorService autorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFinAll() throws Exception {
        Autor autor = new Autor(1,"Michael","Caiza","Ecuador","Tumbaco","0988389144","example@gmail.com");
        Mockito.when(autorService.findAll()).thenReturn(List.of(autor));

        mockMvc.perform(get("/autor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Michael"));

    }


    @Test
    public void testsave() throws  Exception {
        Autor autor = new Autor(0,"Michael","Caiza","Ecuador","Tumbaco","0988389144","example@gmail.com");

        Mockito.when(autorService.save(any(Autor.class))).thenReturn(autor);

        mockMvc.perform(post("/autor").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(autor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Michael"));

    }


    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/autor/1")).andExpect(status().isNoContent());
    }


}
