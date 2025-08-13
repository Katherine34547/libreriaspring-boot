package com.distribuida.dao;

import com.distribuida.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Integer> {

}
