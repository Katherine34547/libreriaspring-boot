package com.distribuida.controller;

import com.distribuida.model.Factura;
import com.distribuida.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<Factura>> findAll(){
        List<Factura> facturas = facturaService.findAll();
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> findOne(@PathVariable int id){
        Factura factura = facturaService.findOne(id);
        return ResponseEntity.ok(factura);
    }

    @PostMapping
    public ResponseEntity<Factura> save(@RequestBody Factura factura){
        Factura facturaGuardad = facturaService.save(factura);
        return ResponseEntity.ok(facturaGuardad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> update(@PathVariable int id, @RequestBody Factura factura){

        Factura facturaActualizada = facturaService.update(id,factura);
        if (facturaActualizada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaActualizada);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        facturaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
