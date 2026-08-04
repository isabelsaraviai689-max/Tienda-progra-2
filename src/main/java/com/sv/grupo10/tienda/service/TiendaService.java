package com.sv.grupo10.tienda.service;

import com.sv.grupo10.tienda.model.Categoria;
import com.sv.grupo10.tienda.model.Producto;

import java.util.List;

/**
 * Contrato del inventario.
 * ID "P"+3 digitos | buscar por ID | no encontrado = null | array seed + List.
 */
public interface TiendaService {

    void agregar(Producto producto);

    List<Producto> mostrar();

    /** Busca por ID. Retorna null si no existe. */
    Producto buscar(String id);

    void modificar(String id, String nombre, Categoria categoria, double precio, int stock);

    int contar();

    /** Lista de trabajo (array -> JCF). */
    List<Producto> convertirALista();
}
