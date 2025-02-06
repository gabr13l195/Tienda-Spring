package com.spring_app.Tienda.Entidad;

import jakarta.persistence.*;
import lombok.Data;

//Este objeto se transformo en una tabla
@Data
@Entity
@Table(name="tabla-producto")
public class Producto {

    //Campo autoincrementable de la clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Este campo va a ser unico
    @Column(unique = true, nullable = false)
    private String nombre;


    private Double precio;

    private int stock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
