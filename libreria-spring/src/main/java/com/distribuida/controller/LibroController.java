package com.distribuida.controller;

import com.distribuida.model.Libro;
import com.distribuida.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> findALL(){
        List<Libro>Libros=libroService.findAll();
        return ResponseEntity.ok(Libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> findOne(@PathVariable int id){
        Libro libro= libroService.findOne(id);
        if (libro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public ResponseEntity<Libro> save(@RequestBody Libro libro){
        Libro libroNuevo = libroService.save(libro);
        return ResponseEntity.ok(libroNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> update(@PathVariable int id , @RequestBody Libro libro){
        Libro libroActuralizado = libroService.update(id, libro);
        if (libroActuralizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libroActuralizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
