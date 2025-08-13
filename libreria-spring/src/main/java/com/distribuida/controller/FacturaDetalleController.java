package com.distribuida.controller;

import com.distribuida.model.FacturaDetalle;
import com.distribuida.service.FacturaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FacturaDetalles")
public class FacturaDetalleController {

    @Autowired
    private FacturaDetalleService facturaDetalleService;

    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> findALL(){
        List<FacturaDetalle>FacturaDetalles=facturaDetalleService.findAll();
        return ResponseEntity.ok(FacturaDetalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDetalle> findOne(@PathVariable int id){
        FacturaDetalle facturaDetalle= facturaDetalleService.findOne(id);
        if (facturaDetalle == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaDetalle);
    }

    @PostMapping
    public ResponseEntity<FacturaDetalle> save(@RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle facturaDetalleNuevo = facturaDetalleService.save(facturaDetalle);
        return ResponseEntity.ok(facturaDetalleNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaDetalle> update(@PathVariable int id , @RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle facturaDetalleActuralizado = facturaDetalleService.update(id, facturaDetalle);
        if (facturaDetalleActuralizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaDetalleActuralizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        facturaDetalleService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
