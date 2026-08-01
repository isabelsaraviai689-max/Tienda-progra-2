package com.sv.grupo10.tienda.service;

import com.sv.grupo10.tienda.model.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de TiendaService.
 *
 * IMPORTANTE PARA EL EQUIPO:
 * Cada quien trabaja en SU propia rama (branch) y solo dentro del metodo
 * que le corresponde, para evitar conflictos de merge en este archivo.
 * Ejemplo de flujo en git:
 *   git checkout -b feature/agregar-mostrar   (Anderson)
 *   git checkout -b feature/buscar            (Luis Alonso)
 *   git checkout -b feature/modificar         (Camila)
 *   git checkout -b feature/contar-validaciones (Esmeralda)
 * Al terminar, cada quien hace pull request y se revisa/mergea uno por uno.
 */

public class TiendaServiceImplementacion implements TiendaService {

    // Roberto (BA): aqui van los 20+ registros de prueba y las reglas de
    // validacion que definas (ej: precio > 0, stock >= 0, nombre no vacio, etc.)
    private Producto[] productosIniciales = {
            // TODO (Roberto - BA): reemplazar con los 20 registros reales
            // Ejemplo: new Producto(1, "Arroz 1lb", 0.75, 50),
    };

    private List<Producto> productos;

    public TiendaServiceImplementacion() {
        // Conversion array -> Collection (JCF). Ya viene resuelta, Roberto
        // solo necesita llenar el array de arriba con los 20 registros.
        this.productos = new ArrayList<>();
        for (Producto p : productosIniciales) {
            this.productos.add(p);
        }
    }

    @Override
    public void agregar(Producto producto) {
        // TODO (Anderson - Dev): agregar el producto a "productos".
        // Recuerda validar que el id no este repetido antes de agregar.
        throw new UnsupportedOperationException("Pendiente: Anderson");
    }

    @Override
    public List<Producto> mostrar() {
        // TODO (Anderson - Dev): retornar el listado completo de productos.
        throw new UnsupportedOperationException("Pendiente: Anderson");
    }

    @Override
    public Producto buscar(int id) {
        // TODO (Luis Alonso - Dev): recorrer "productos" y retornar el que
        // coincida con el id. Si no existe, se puede retornar null (y que
        // quien llame valide eso), o lanzar una excepcion controlada.
        throw new UnsupportedOperationException("Pendiente: Luis Alonso");
    }

    @Override
    public void modificar(int id, String nombre, double precio, int stock) {
        // TODO (Camila - Dev): buscar el producto por id y actualizar sus
        // datos con los setters de Producto. Si no existe, avisar que no
        // se encontro.
        throw new UnsupportedOperationException("Pendiente: Camila");
    }

    @Override
    public int contar() {
        // TODO (Esmeralda - Dev): retornar cuantos productos hay registrados.
        // Aqui tambien puedes centralizar metodos de validacion de entrada
        // si se decide ponerlos en esta clase.
        throw new UnsupportedOperationException("Pendiente: Esmeralda");
    }

    @Override
    public List<Producto> convertirALista() {
        // Ya resuelto: la conversion ocurre en el constructor. Este metodo
        // solo expone la lista ya convertida, por si QA quiere probarlo
        // directamente.
        return productos;
    }
}
