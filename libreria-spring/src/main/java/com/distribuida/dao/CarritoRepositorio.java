package com.distribuida.dao;

import com.distribuida.model.Carrito;
import com.distribuida.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarritoRepositorio extends JpaRepository<Carrito, Long> {
    Optional<Carrito> findByCliente(Cliente cliente);
    Optional<Carrito> finByToken(String token);
}
