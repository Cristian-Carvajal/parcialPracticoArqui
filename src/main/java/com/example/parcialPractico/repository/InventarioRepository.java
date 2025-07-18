package com.example.parcialPractico.repository;

import com.example.parcialPractico.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    List<Inventario> findByAlmacenId(Long almacenId);
    Optional<Inventario> findByAlmacenIdAndProductoId(Long almacenId, Long productoId);
}