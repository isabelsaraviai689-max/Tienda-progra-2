package com.sv.grupo10.tienda.service;

import com.sv.grupo10.tienda.model.Categoria;
import com.sv.grupo10.tienda.model.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de TiendaService.
 *
 * Cada quien trabaja en su branch y solo en su metodo:
 *   feature/agregar-mostrar        (Anderson)
 *   feature/buscar                 (Luis Alonso)
 *   feature/modificar              (Camila)
 *   feature/contar-validaciones    (Esmeralda)
 *
 * Array = seed (20 registros). List = store de trabajo.
 * Validaciones de negocio aqui. Re-pedir input invalido en UI.
 * Helpers de validacion solo al final (zona HELPERS).
 */
public class TiendaServiceImplementacion implements TiendaService {

    // Seed BA: 20 productos. No cambiar IDs sin acuerdo.
    private final Producto[] productosIniciales = {
            new Producto("P001", "Arroz San Francisco 1Kg", Categoria.GRANOS, 1.35, 45),
            new Producto("P002", "Azucar Morena 1Kg", Categoria.GRANOS, 1.20, 38),
            new Producto("P003", "Cafe Listo 250g", Categoria.BEBIDAS, 3.50, 25),
            new Producto("P004", "Leche Entera 1L", Categoria.LACTEOS, 1.55, 30),
            new Producto("P005", "Pan de Caja", Categoria.PANADERIA, 2.10, 18),
            new Producto("P006", "Galletas Chocolate", Categoria.SNACKS, 1.80, 40),
            new Producto("P007", "Refresco Cola 2L", Categoria.BEBIDAS, 2.35, 22),
            new Producto("P008", "Agua Purificada 600ml", Categoria.BEBIDAS, 0.60, 60),
            new Producto("P009", "Aceite Vegetal 900ml", Categoria.COCINA, 3.95, 16),
            new Producto("P010", "Pasta Espagueti", Categoria.PASTAS, 1.15, 35),
            new Producto("P011", "Salsa de Tomate", Categoria.COCINA, 1.40, 20),
            new Producto("P012", "Atun en Lata", Categoria.ENLATADOS, 2.25, 27),
            new Producto("P013", "Jabon de Bano", Categoria.HIGIENE, 0.95, 55),
            new Producto("P014", "Shampoo 400ml", Categoria.HIGIENE, 4.80, 14),
            new Producto("P015", "Papel Higienico 4 rollos", Categoria.LIMPIEZA, 3.25, 19),
            new Producto("P016", "Detergente en Polvo", Categoria.LIMPIEZA, 5.60, 11),
            new Producto("P017", "Cloro 1L", Categoria.LIMPIEZA, 1.50, 24),
            new Producto("P018", "Cepillo Dental", Categoria.HIGIENE, 1.75, 33),
            new Producto("P019", "Desodorante Spray", Categoria.HIGIENE, 4.25, 17),
            new Producto("P020", "Chocolate en Barra", Categoria.DULCES, 0.90, 50)
    };

    private final List<Producto> productos;

    public TiendaServiceImplementacion() {
        // Array seed -> ArrayList (JCF).
        this.productos = new ArrayList<>();
        for (Producto p : productosIniciales) {
            this.productos.add(p);
        }
    }

    @Override
    public void agregar(Producto producto) {
        // TODO (Anderson): agregar a "productos".
        // Validar via helpers: ID unico "P"+3 digitos, nombre 3-50, categoria,
        // precio > 0 con max 2 decimales, stock >= 0.
        throw new UnsupportedOperationException("Pendiente: Anderson");
    }

    @Override
    public List<Producto> mostrar() {
        // TODO (Anderson): retornar la lista (puede ir vacia).
        // UI informa "lista vacia" si size == 0; aqui no imprimir.
        throw new UnsupportedOperationException("Pendiente: Anderson");
    }

    @Override
    public Producto buscar(String id) {
        // TODO (Luis Alonso): buscar por id. Si no hay, return null.
        throw new UnsupportedOperationException("Pendiente: Luis Alonso");
    }

    @Override
    public void modificar(String id, String nombre, Categoria categoria, double precio, int stock) {
        // TODO (Camila): buscar por id y actualizar con setters.
        // Si no existe, no tumbar la app (UI muestra "no encontrado").
        // Revalidar: nombre 3-50, categoria, precio > 0 max 2 decimales, stock >= 0.
        throw new UnsupportedOperationException("Pendiente: Camila");
    }

    @Override
    public int contar() {
        // TODO (Esmeralda): retornar cantidad registrada + helpers abajo.
        throw new UnsupportedOperationException("Pendiente: Esmeralda");
    }

    @Override
    public List<Producto> convertirALista() {
        // Ya resuelto en el constructor.
        return productos;
    }

    // -------------------------------------------------------------------------
    // HELPERS DE VALIDACION (Esmeralda; reusar en agregar/modificar)
    // Solo metodos private aqui. No meterlos entre los CRUD.
    // Reglas SM:
    // - ID: no vacio, unico, formato "P" + 3 digitos (P001)
    // - Nombre: 3-50 caracteres
    // - Categoria: enum != null
    // - Precio: > 0, maximo 2 decimales
    // - Stock: entero >= 0
    // -------------------------------------------------------------------------
}
