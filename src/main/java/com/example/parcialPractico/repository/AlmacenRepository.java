package com.example.parcialPractico.repository;

import com.example.parcialPractico.entity.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long> {
}