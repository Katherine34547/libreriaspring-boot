package com.distribuida.dao;

import com.distribuida.model.Carrito;
import com.distribuida.model.CarritoItem;
import com.distribuida.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarritoItemRepositorio extends JpaRepository<CarritoItem, Long> {
    Optional<CarritoItem> findByCarritoAndLibro (Carrito carrito, Libro libro);
    List<CarritoItem> findByCarrito (Carrito carrito);
}
