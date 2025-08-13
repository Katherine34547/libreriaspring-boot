package com.distribuida.dao;

import com.distribuida.model.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleRepositorio extends JpaRepository<FacturaDetalle,Integer> {

    //public  FacturaDetalle findByCedula(String cedula);
}