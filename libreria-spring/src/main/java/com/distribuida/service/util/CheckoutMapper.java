package com.distribuida.service.util;

import com.distribuida.model.Carrito;
import com.distribuida.model.CarritoItem;
import com.distribuida.model.Factura;
import com.distribuida.model.FacturaDetalle;

import java.util.Date;

public class CheckoutMapper {

    private CheckoutMapper(){ }

    public static Factura consturirFacturaDesdeCarrito(
            Carrito carrito, String numFactura, double tasaIva){

        Factura f = new Factura();
        f.setNumFactura(numFactura);
        f.setFecha(new Date());
        f.setCliente(carrito.getCliente());

        double subtotal = carrito.getItems().stream()
                .mapToDouble(i -> i.getTotal().doubleValue())
                .sum();

        double iva = Math.max(0, subtotal)*tasaIva;
        double total = subtotal + iva;

        f.setTotalNeto(subtotal);
        f.setIva(iva);
        f.setTotal(total);

        return f;
    }

    public static FacturaDetalle construirDetalle(Factura factura, CarritoItem item){
        FacturaDetalle d = new FacturaDetalle();
        d.setFactura(factura);
        d.setLibro(item.getLibro());
        d.setCantidad(item.getCantidad());
        d.setSubtotal(item.getTotal().floatValue());
        return d;
    }
}
