package com.distribuida.dao;

import com.distribuida.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor,Integer> {
    // Método personalizado para buscar autor por nombre
    Autor findByNombre(String nombre);

    // También podrías agregar otros métodos útiles como:
    Autor findByCorreo(String correo);
    Autor findByApellido(String apellido);

}
