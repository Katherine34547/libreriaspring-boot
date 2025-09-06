package com.distribuida.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name= "carrito_item",
              uniqueConstraints = @UniqueConstraint(columnNames = {"id_carrito","id_libro"}))
public class CarritoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito_item")
    private Long idCarritoItem;


    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;


    @JsonIgnoreProperties({"autor","categoria"})
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_libro")
    private Libro libro;


    @Column(name = "cantidad")
    private Integer cantidad;


    @Column(name = "precio_unitario", precision = 12, scale = 2)
    private BigDecimal precioUnitario;


    @Column(name = "total", precision = 12, scale = 2)
    private BigDecimal total;


    @PrePersist @PreUpdate
    public void jpaCalcTotal(){
        calcTotal();
    }

    public void calcTotal(){
        if (precioUnitario == null) precioUnitario = BigDecimal.ZERO;
        if (cantidad == null) cantidad = 0;
        total = precioUnitario.multiply(BigDecimal.valueOf(cantidad))
                .setScale(2, RoundingMode.HALF_UP);
    }


    //getters and setters

    public Long getIdCarritoItem() {
        return idCarritoItem;
    }

    public void setIdCarritoItem(Long idCarritoItem) {
        this.idCarritoItem = idCarritoItem;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
