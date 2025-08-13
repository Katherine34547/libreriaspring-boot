package com.distribuida.service;

import com.distribuida.dao.FacturaDetalleRepositorio;
import com.distribuida.model.Factura;
import com.distribuida.model.FacturaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // esto es un bean para logica de negocio
public class FacturaDetalleServiceImpl implements FacturaDetalleService{

    @Autowired // esta anotacion permite INYECTAR BEANS (INYECCION DE DEPENDENCIAS)
    private FacturaDetalleRepositorio facturaDetalleRepositorio;


    @Override
    public List<FacturaDetalle> findAll() {
        return facturaDetalleRepositorio.findAll();
    }

    @Override
    public FacturaDetalle findOne(int id) {
        Optional<FacturaDetalle> FacturaDetalle= facturaDetalleRepositorio.findById(id);
        return FacturaDetalle.orElse(null);
    }

    @Override
    public FacturaDetalle save(FacturaDetalle facturaDetalle) {
        return facturaDetalleRepositorio.save(facturaDetalle) ;
    }

    @Override
    public FacturaDetalle update(int id, FacturaDetalle facturaDetalle) {
        FacturaDetalle facturaDetalleExistente = findOne(id);

        if(facturaDetalleExistente == null){
            return null;
        }

        facturaDetalleExistente.setIdFacturaDetalle(facturaDetalle.getIdFacturaDetalle());
        facturaDetalleExistente.setCantidad(facturaDetalle.getCantidad());
        facturaDetalleExistente.setFactura(facturaDetalle.getFactura());
        facturaDetalleExistente.setLibro(facturaDetalle.getLibro());
        facturaDetalleExistente.setSubtotal(facturaDetalle.getSubtotal());

        return facturaDetalleRepositorio.save(facturaDetalleExistente);
    }

    @Override
    public void delete(int id) {
        if(facturaDetalleRepositorio.existsById(id)){
            facturaDetalleRepositorio.deleteById(id);
        }

    }
}
