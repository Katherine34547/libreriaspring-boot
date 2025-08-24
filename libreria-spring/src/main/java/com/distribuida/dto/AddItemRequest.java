package com.distribuida.dto;

public class AddItemRequest {
    private  int LibroId;
    private int cantidad;

    public int getLibroId() {
        return LibroId;
    }

    public void setLibroId(int libroId) {
        LibroId = libroId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
