package com.distribuida.service;

import com.distribuida.dao.CarritoRepositorio;
import com.distribuida.dao.FacturaDetalleRepositorio;
import com.distribuida.dao.FacturaRepositorio;
import com.distribuida.dao.LibroRepositorio;
import com.distribuida.model.Factura;
import com.distribuida.service.util.CheckoutMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class GuestCheckoutServiceImpl implements GuestCheckoutService {

    private final CarritoRepositorio carritoRepositorio;
    private final FacturaRepositorio facturaRepositorio;
    private final FacturaDetalleRepositorio facturaDetalleRepositorio;
    private final LibroRepositorio libroRepositorio;

    private static final double IVA= 0.15;

    public GuestCheckoutServiceImpl(CarritoRepositorio carritoRepositorio,
                                    FacturaRepositorio facturaRepositorio,
                                    FacturaDetalleRepositorio facturaDetalleRepositorio,
                                    LibroRepositorio libroRepositorio
            ){
        this.carritoRepositorio= carritoRepositorio;
        this.facturaRepositorio= facturaRepositorio;
        this.facturaDetalleRepositorio= facturaDetalleRepositorio;
        this.libroRepositorio=libroRepositorio;
    }


    @Override
    @Transactional
    public Factura checkoutByToken(String token) {
        var carrito = carritoRepositorio.findByToken(token)
                .orElseThrow(() -> new IllegalStateException("No existe carrito para el token"));

        if (carrito.getItems() == null || carrito.getItems().isEmpty()){
            throw new IllegalStateException("El carrito esta vacio. ");
        }

        for(var item: carrito.getItems()){
            var libro = item.getLibro();
            if (libro.getNumEjemplares()< item.getCantidad()){
                throw new IllegalStateException("stock insuficiente para: "+ libro.getTitulo());
            }
        }

        for(var item: carrito.getItems()){
            var libro = item.getLibro();
            libro.setNumEjemplares( libro.getNumEjemplares() - item.getCantidad());
            libroRepositorio.save(libro);
        }

        String numFactura = "F-" + DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
                .format(LocalDateTime.now());

        var factura = CheckoutMapper.consturirFacturaDesdeCarrito(carrito,numFactura, IVA);

        factura = facturaRepositorio.save(factura);

        for (var item: carrito.getItems()){
            var det = CheckoutMapper.construirDetalle(factura,item);
            facturaDetalleRepositorio.save(det);
        }

        carrito.getItems().clear();
        carritoRepositorio.save(carrito);
        return factura;
    }
}
