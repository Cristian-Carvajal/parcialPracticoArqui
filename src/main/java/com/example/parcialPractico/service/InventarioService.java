package com.example.parcialPractico.service;

import com.example.parcialPractico.dto.ProductoNuevo;
import com.example.parcialPractico.entity.Almacen;
import com.example.parcialPractico.entity.Inventario;
import com.example.parcialPractico.entity.Producto;
import com.example.parcialPractico.repository.AlmacenRepository;
import com.example.parcialPractico.repository.InventarioRepository;
import com.example.parcialPractico.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final InventarioRepository inventarioRepository;
    private ProductoRepository productoRepository;
    private AlmacenRepository almacenRepository;

    public List<Inventario> obtenerInventarioPorSede(Long id) {
        return inventarioRepository.findByAlmacenId(id);
    }

    public Inventario registrarProductoEnInventario(ProductoNuevo productoNuevo,
                                                    Long AlmacenId, int cantidadInicial) {
        Almacen almacen = almacenRepository.findById(AlmacenId)
                .orElseThrow(() -> new RuntimeException("No existe el almacen"));

        Producto producto = productoRepository.findByNombre(productoNuevo.getNombre())
                .orElseGet(() -> {
                    Producto nuevoProducto = new Producto();
                    nuevoProducto.setNombre(productoNuevo.getNombre());
                    nuevoProducto.setPrecioUnitario(productoNuevo.getPrecioUnitario());
                    nuevoProducto.setCategoria(productoNuevo.getCategoria());
                    nuevoProducto.setDescripcion(productoNuevo.getDescripcion());
                    return productoRepository.save(nuevoProducto);
                });

        Optional<Inventario> inventarioOpt = inventarioRepository.findByAlmacenIdAndProductoId(
                almacen.getId(),
                producto.getId());

        Inventario inventario;
        if (inventarioOpt.isPresent()) {
            inventario = inventarioOpt.get();
            inventario.setCantidad(inventario.getCantidad() + cantidadInicial);
        } else {
            inventario = new Inventario();
            inventario.setAlmacen(almacen);
            inventario.setProducto(producto);
            inventario.setCantidad(cantidadInicial);
        }

        return inventarioRepository.save(inventario);
    }

}
