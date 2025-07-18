package com.example.parcialPractico.entity;
import jakarta.persistence.*;
import lombok.Data;

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