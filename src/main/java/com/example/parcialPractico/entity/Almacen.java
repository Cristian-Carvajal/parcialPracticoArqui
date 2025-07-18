package com.example.parcialPractico.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "almacenes")
@Data
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;
}