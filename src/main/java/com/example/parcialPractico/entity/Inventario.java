package com.example.parcialPractico.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventario")
@Data
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "almacen_id", nullable = false)
    private Almacen almacen;

    @ManyToOne()
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private int cantidad;
}