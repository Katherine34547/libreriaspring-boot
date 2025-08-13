package com.distribuida.controller;

import com.distribuida.model.Factura;
import com.distribuida.service.FacturaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class FacturaControllerTestUnitario {

    @InjectMocks
    private FacturaController facturaController;

    @Mock
    private FacturaService facturaService;

    private Factura factura;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        factura = new Factura();
        factura.setIdFactura(1);
        factura.setNumFactura("FAC-001");
        factura.setIva(15.00);
        factura.setFecha(new Date());
        factura.setTotal(15.99);
        factura.setTotalNeto(15.99);
    }

    @Test
    public void testFindAll(){
        when(facturaService.findAll()).thenReturn(List.of(factura));
        ResponseEntity<List<Factura>> respuesta = facturaController.findAll();
        assertEquals(200,respuesta.getStatusCodeValue());
        assertEquals(1, respuesta.getBody().size());
        verify(facturaService,times(1)).findAll();
    }

    @Test
    public void testFinOneExistente(){
        when(facturaService.findOne(1)).thenReturn(factura);
        ResponseEntity<Factura> respuesta =facturaController.findOne(1);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(factura.getNumFactura(),respuesta.getBody().getNumFactura());
        verify(facturaService,times(1)).findOne(1);
    }

    @Test
    public void testFindOneNoExistente(){
        when(facturaService.findOne(2)).thenReturn(null);
        ResponseEntity<Factura> respuesta = facturaController.findOne(2);
        assertEquals(404, respuesta.getStatusCodeValue());
        //verify(clienteService,times(0)).findOne(2);
    }

    @Test
    public void testSave(){
        when(facturaService.save(any(Factura.class))).thenReturn(factura);
        ResponseEntity<Factura> respuesta = facturaController.save(factura);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals("FAC-001",respuesta.getBody().getNumFactura());
    }

    @Test
    public void testUpdateExistente(){
        when(facturaService.update(eq(1),any(Factura.class))).thenReturn(factura);
        ResponseEntity<Factura> respuesta = facturaController.update(1,factura);
        assertEquals(200,respuesta.getStatusCodeValue());
    }

    @Test
    public void testUpdateNoExistente(){
        when(facturaService.update(eq(2),any(Factura.class))).thenReturn(null);
        ResponseEntity<Factura> respuesta = facturaController.update(2,factura);
        assertEquals(404,respuesta.getStatusCodeValue());
    }

    @Test
    public void testDelete(){
        doNothing().when(facturaService).delete(1);
        ResponseEntity<Void> respuesta = facturaController.delete(1);
        assertEquals(204,respuesta.getStatusCodeValue());
        verify(facturaService,times(1)).delete(1);
    }

}
