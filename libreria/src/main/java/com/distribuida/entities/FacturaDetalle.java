package com.distribuida.entities;

public class FacturaDetalle {
    private int idFacturaDetalle;
    private int Cantidad;
    private Float Subtotal;

    private Factura factura;
    private Libro libro;

    public FacturaDetalle() {
    }

    public FacturaDetalle(int idFacturaDetalle, int cantidad, Float subtotal) {
        this.idFacturaDetalle = idFacturaDetalle;
        Cantidad = cantidad;
        Subtotal = subtotal;
        this.factura = factura;
        this.libro = libro;
    }

    public int getIdFacturaDetalle() { return idFacturaDetalle; }

    public void setIdFacturaDetalle(int idFacturaDetalle) { this.idFacturaDetalle = idFacturaDetalle; }

    public int getCantidad() { return Cantidad; }

    public void setCantidad(int cantidad) { Cantidad = cantidad; }

    public Float getSubtotal() { return Subtotal; }

    public void setSubtotal(Float subtotal) { Subtotal = subtotal; }

    public Factura getFactura() { return factura; }

    public void setFactura(Factura factura) { this.factura = factura; }

    public Libro getLibro() { return libro; }

    public void setLibro(Libro libro) { this.libro = libro; }

    @Override
    public String toString() {
        return "FacturaDetalle{" +
                "idFacturaDetalle=" + idFacturaDetalle +
                ", Cantidad=" + Cantidad +
                ", Subtotal=" + Subtotal +
                ", factura=" + factura +
                ", libro=" + libro +
                '}';
    }
}
