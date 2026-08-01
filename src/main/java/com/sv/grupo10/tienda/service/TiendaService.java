package com.sv.grupo10.tienda.service;

import com.sv.grupo10.tienda.model.Producto;
import java.util.List;

public interface TiendaService {

    void agregar(Producto producto);

    List<Producto> mostrar();

    Producto buscar(int id);

    void modificar(int id, String nombre, double precio, int stock);

    int contar();

    List<Producto> convertirALista(); // arrays → JCF
}
