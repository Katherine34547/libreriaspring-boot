package com.distribuida.service;

import com.distribuida.dao.LibroRepositorio;
import com.distribuida.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // esto es un bean para logica de negocio
public class LibroServiceImpl implements LibroService{

    @Autowired // esta anotacion permite INYECTAR BEANS (INYECCION DE DEPENDENCIAS)
    private LibroRepositorio libroRepositorio;


    @Override
    public List<Libro> findAll() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro findOne(int id) {
        Optional<Libro> Libro= libroRepositorio.findById(id);
        return Libro.orElse(null);
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepositorio.save(libro) ;
    }

    @Override
    public Libro update(int id, Libro libro) {
        Libro libroExistente = findOne(id);

        if(libroExistente == null){
            return null;
        }

        libroExistente.setIdLibro(libro.getIdLibro());
        libroExistente.setAutor(libro.getAutor());
        libroExistente.setCategoria(libro.getCategoria());
        libroExistente.setIdioma(libro.getIdioma());
        libroExistente.setDescripcion(libro.getDescripcion());
        libroExistente.setEditorial(libro.getEditorial());
        libroExistente.setIsbn(libro.getIsbn());
        libroExistente.setNumEjemplares(libro.getNumEjemplares());
        libroExistente.setNumPaginas(libro.getNumPaginas());
        libroExistente.setPortada(libro.getPortada());
        libroExistente.setPrecio(libro.getPrecio());
        libroExistente.setPresentacion(libro.getPresentacion());
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setTipoPasta(libro.getTipoPasta());
        libroExistente.setEdicion(libro.getEdicion());


        return libroRepositorio.save(libroExistente);
    }

    @Override
    public void delete(int id) {
        if(libroRepositorio.existsById(id)){
            libroRepositorio.deleteById(id);
        }

    }
}
