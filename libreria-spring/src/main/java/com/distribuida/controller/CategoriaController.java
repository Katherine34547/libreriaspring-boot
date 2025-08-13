package com.distribuida.controller;

import com.distribuida.model.Categoria;
import com.distribuida.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findOne(@PathVariable int id){
        Categoria categoria = categoriaService.findOne(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria Categoria){
        Categoria categoriaGuardad = categoriaService.save(Categoria);
        return ResponseEntity.ok(categoriaGuardad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable int id, @RequestBody Categoria Categoria){

        Categoria categoriaActualizada = categoriaService.update(id,Categoria);
        if (categoriaActualizada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaActualizada);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
