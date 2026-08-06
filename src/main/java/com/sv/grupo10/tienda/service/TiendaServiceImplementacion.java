package com.sv.grupo10.tienda.service;

import com.sv.grupo10.tienda.model.Categoria;
import com.sv.grupo10.tienda.model.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de TiendaService.
 *
 * Cada quien trabaja en su branch y solo en su método:
 *   feature/agregar-mostrar        (Anderson)
 *   feature/buscar                 (Luis Alonso)
 *   feature/modificar              (Camila)
 *   feature/contar-validaciones    (Esmeralda)
 *
 * Array = seed (20 registros). List = store de trabajo.
 * Validaciones de negocio aquí. Re-pedir input inválido en UI.
 * Helpers de validación solo al final (zona HELPERS).
 */
public class TiendaServiceImplementacion implements TiendaService {

    // Seed BA: 20 productos. No cambiar IDs sin acuerdo.
    private final Producto[] productosIniciales = {
            new Producto("P001", "Arroz San Francisco 1Kg", Categoria.GRANOS, 1.35, 45),
            new Producto("P002", "Azúcar Morena 1Kg", Categoria.GRANOS, 1.20, 38),
            new Producto("P003", "Café Listo 250g", Categoria.BEBIDAS, 3.50, 25),
            new Producto("P004", "Leche Entera 1L", Categoria.LACTEOS, 1.55, 30),
            new Producto("P005", "Pan de Caja", Categoria.PANADERIA, 2.10, 18),
            new Producto("P006", "Galletas Chocolate", Categoria.SNACKS, 1.80, 40),
            new Producto("P007", "Refresco Cola 2L", Categoria.BEBIDAS, 2.35, 22),
            new Producto("P008", "Agua Purificada 600ml", Categoria.BEBIDAS, 0.60, 60),
            new Producto("P009", "Aceite Vegetal 900ml", Categoria.COCINA, 3.95, 16),
            new Producto("P010", "Pasta Espagueti", Categoria.PASTAS, 1.15, 35),
            new Producto("P011", "Salsa de Tomate", Categoria.COCINA, 1.40, 20),
            new Producto("P012", "Atún en Lata", Categoria.ENLATADOS, 2.25, 27),
            new Producto("P013", "Jabón de Baño", Categoria.HIGIENE, 0.95, 55),
            new Producto("P014", "Shampoo 400ml", Categoria.HIGIENE, 4.80, 14),
            new Producto("P015", "Papel Higiénico 4 rollos", Categoria.LIMPIEZA, 3.25, 19),
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
        // ASIGNACION (Anderson): agregar a "productos" con validaciones de negocio.
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }

        // Validar formato de ID (P seguido de 3 dígitos)
        if (producto.getId() == null || !producto.getId().matches("^P\\d{3}$")) {
            throw new IllegalArgumentException("El ID debe tener el formato 'P' seguido de 3 dígitos (Ej: P021).");
        }

        // Validar ID único
        if (buscar(producto.getId()) != null) {
            throw new IllegalArgumentException("Ya existe un producto registrado con el ID: " + producto.getId());
        }

        // Validar Nombre (3 a 50 caracteres)
        if (producto.getNombre() == null || producto.getNombre().trim().length() < 3 || producto.getNombre().trim().length() > 50) {
            throw new IllegalArgumentException("El nombre debe contener entre 3 y 50 caracteres.");
        }

        // Validar Categoría
        if (producto.getCategoria() == null) {
            throw new IllegalArgumentException("Debe seleccionar una categoría válida.");
        }

        // Validar Precio (> 0)
        if (producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser un número mayor a 0.");
        }

        // Validar Stock (>= 0)
        if (producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock debe ser un número entero igual o mayor a 0.");
        }

        // Si pasa todas las validaciones, se agrega a la lista compartida
        this.productos.add(producto);
    }

    @Override
    public List<Producto> mostrar() {
        // ASIGNACION (Anderson): retornar la lista de trabajo (store).
        return this.productos;
    }

    @Override
    public Producto buscar(String id) {
        // (Luis Alonso) Busqueda secuencial por ID sobre la lista de trabajo (JCF).
        if (id == null || id.trim().isEmpty()) {
            return null; // Regla: entrada invalida / no encontrado -> null (la UI informa)
        }

        String idBuscado = id.trim();
        for (Producto producto : productos) {
            if (producto.getId().equalsIgnoreCase(idBuscado)) {
                return producto; // Encontrado: se retorna la instancia
            }
        }
        return null; // Sin coincidencias
    }

    @Override
    public void modificar(String id, String nombre, Categoria categoria, double precio, int stock) {
        // ASIGNACION (Camila): buscar por ID y actualizar con los setters de la clase Producto.
        // 1. Buscar el producto por su ID
        Producto p = buscar(id);

        // 2. Verificar existencia
        if (p == null) {
            throw new IllegalArgumentException("No existe un producto registrado con el ID: " + id);
        }

        // 3. Revalidacion de datos de entrada
        if (nombre == null || nombre.trim().length() < 3 || nombre.trim().length() > 50) {
            throw new IllegalArgumentException("El nombre debe contener entre 3 y 50 caracteres.");
        }

        if (categoria == null) {
            throw new IllegalArgumentException("Debe seleccionar una categoria valida.");
        }

        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser un numero mayor a 0.");
        }

        if (stock < 0) {
            throw new IllegalArgumentException("El stock debe ser un numero entero igual o mayor a 0.");
        }

        // 4. Actualizar mediante setters
        p.setNombre(nombre.trim());
        p.setCategoria(categoria);
        p.setPrecio(precio);
        p.setStock(stock);
    }

    @Override
    public int contar() {
        // ASIGNACION (Esmeralda): retornar la cantidad total de productos registrados en "productos".
        // Utilizar el método size() sobre el ArrayList de trabajo.
        throw new UnsupportedOperationException("Pendiente: Esmeralda");
    }

    @Override
    public List<Producto> convertirALista() {
        // Ya resuelto en el constructor.
        return productos;
    }

    // -------------------------------------------------------------------------
    // HELPERS DE VALIDACION (Esmeralda; reusar en agregar/modificar)
    // Solo métodos private aquí. No meterlos entre los CRUD.
    // Reglas SM:
    // - ID: no vacío, único, formato "P" + 3 dígitos (P001)
    // - Nombre: 3-50 caracteres
    // - Categoría: enum != null
    // - Precio: > 0, máximo 2 decimales
    // - Stock: entero >= 0
    // -------------------------------------------------------------------------
}
