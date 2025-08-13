package com.distribuida.service;

import com.distribuida.dao.AutorRepositorio;
import com.distribuida.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // esto es un bean para logica de negocio
public class AutorServiceImpl implements AutorService{

    @Autowired // esta anotacion permite INYECTAR BEANS (INYECCION DE DEPENDENCIAS)
    private AutorRepositorio autorRepositorio;


    @Override
    public List<Autor> findAll() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor findOne(int id) {
        Optional<Autor> Autor= autorRepositorio.findById(id);
        return Autor.orElse(null);
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepositorio.save(autor) ;
    }

    @Override
    public Autor update(int id, Autor autor) {
        Autor autorExistente = findOne(id);

        if(autorExistente == null){
            return null;
        }

        autorExistente.setIdAutor(autor.getIdAutor());
        autorExistente.setApellido(autor.getApellido());
        autorExistente.setCorreo(autor.getCorreo());
        autorExistente.setDireccion(autor.getDireccion());
        autorExistente.setTelefono(autor.getTelefono());
        autorExistente.setPais(autor.getPais());
        autorExistente.setNombre(autor.getNombre());

        return autorRepositorio.save(autorExistente);
    }

    @Override
    public void delete(int id) {
        if(autorRepositorio.existsById(id)){
            autorRepositorio.deleteById(id);
        }

    }
}
