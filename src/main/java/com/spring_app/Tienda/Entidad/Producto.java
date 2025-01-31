package com.spring_app.Tienda.Entidad;

import jakarta.persistence.*;
import lombok.Data;


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
}
