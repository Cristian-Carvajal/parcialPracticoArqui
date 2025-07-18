package com.example.parcialPractico.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    private String categoria;
}