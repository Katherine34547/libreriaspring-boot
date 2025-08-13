package com.distribuida.service;

import com.distribuida.dao.FacturaRepositorio;
import com.distribuida.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // esto es un bean para logica de negocio
public class FacturaServiceImpl implements FacturaService{

    @Autowired // esta anotacion permite INYECTAR BEANS (INYECCION DE DEPENDENCIAS)
    private FacturaRepositorio facturaRepositorio;


    @Override
    public List<Factura> findAll() {
        return facturaRepositorio.findAll();
    }

    @Override
    public Factura findOne(int id) {
        Optional<Factura> Factura= facturaRepositorio.findById(id);
        return Factura.orElse(null);
    }

    @Override
    public Factura save(Factura factura) {
        return facturaRepositorio.save(factura) ;
    }

    @Override
    public Factura update(int id, Factura factura) {
        Factura facturaExistente = findOne(id);

        if(facturaExistente == null){
            return null;
        }

        facturaExistente.setNumFactura(factura.getNumFactura());
        facturaExistente.setFecha(factura.getFecha());
        facturaExistente.setTotalNeto(factura.getTotalNeto());
        facturaExistente.setIva(factura.getIva());
        facturaExistente.setTotal(factura.getTotal());
        facturaExistente.setCliente(factura.getCliente());


        return facturaRepositorio.save(facturaExistente);
    }

    @Override
    public void delete(int id) {
        if(facturaRepositorio.existsById(id)){
            facturaRepositorio.deleteById(id);
        }

    }
}
