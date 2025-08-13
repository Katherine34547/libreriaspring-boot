package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Autors")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> findALL(){
        List<Autor>autors=autorService.findAll();
        return ResponseEntity.ok(autors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> findOne(@PathVariable int id){
        Autor autor= autorService.findOne(id);
        if (autor == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autor);
    }

    @PostMapping
    public ResponseEntity<Autor> save(@RequestBody Autor autor){
        Autor autorNuevo = autorService.save(autor);
        return ResponseEntity.ok(autorNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> update(@PathVariable int id , @RequestBody Autor autor){
        Autor autorActuralizado = autorService.update(id, autor);
        if (autorActuralizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autorActuralizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
