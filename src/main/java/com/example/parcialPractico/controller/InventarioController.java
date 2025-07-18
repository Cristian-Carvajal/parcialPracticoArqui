package com.example.parcialPractico.controller;

import com.example.parcialPractico.dto.ProductoNuevo;
import com.example.parcialPractico.entity.Inventario;
import com.example.parcialPractico.service.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class InventarioController {

    private final InventarioService inventarioService;

    @QueryMapping
    public List<Inventario> inventarioPorSede(@Argument Long sedeId) {
        return inventarioService.obtenerInventarioPorSede(sedeId);
    }

    @MutationMapping
    public Inventario registrarProductoEnInventario(
            @Argument("producto")ProductoNuevo productoNuevo,
            @Argument Long AlmacenId,
            @Argument int cantidadInicial) {
        return inventarioService.registrarProductoEnInventario(productoNuevo, AlmacenId, cantidadInicial);
    }
}
