package com.sv.grupo10.tienda.ui;

import com.sv.grupo10.tienda.model.Categoria;
import com.sv.grupo10.tienda.model.Producto;
import com.sv.grupo10.tienda.service.TiendaService;
import com.sv.grupo10.tienda.service.TiendaServiceImplementacion;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TiendaService service = new TiendaServiceImplementacion();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n===== MENU TIENDA - GRUPO 10 =====");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Agregar producto");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Modificar producto");
            System.out.println("5. Contar productos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        // Lógica para MOSTRAR
                        List<Producto> lista = service.mostrar();
                        if (lista.isEmpty()) {
                            System.out.println("\n[!] La lista de productos está vacía.");
                        } else {
                            System.out.println("\n=========================================================================================");
                            System.out.println("                               CATÁLOGO DE PRODUCTOS                                     ");
                            System.out.println("=========================================================================================");
                            System.out.printf("%-6s | %-28s | %-12s | %-10s | %-6s\n", "ID", "NOMBRE", "CATEGORÍA", "PRECIO", "STOCK");
                            System.out.println("-----------------------------------------------------------------------------------------");
                            for (Producto p : lista) {
                                System.out.printf("%-6s | %-28s | %-12s | $%-9.2f | %-6d\n",
                                        p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio(), p.getStock());
                            }
                            System.out.println("=========================================================================================");
                        }
                        break;

                    case 2:
                        // Lógica para AGREGAR
                        System.out.println("\n--- REGISTRAR NUEVO PRODUCTO ---");
                        System.out.print("ID (formato P###, ej. P021): ");
                        String id = sc.nextLine();

                        System.out.print("Nombre (3 a 50 chars): ");
                        String nombre = sc.nextLine();

                        System.out.println("Categorías disponibles:");
                        for (Categoria c : Categoria.values()) {
                            System.out.println(" - " + c.name() + " (" + c.getEtiqueta() + ")");
                        }
                        System.out.print("Seleccione Categoría (Escriba el nombre exacto, ej. LIMPIEZA): ");
                        String catInput = sc.nextLine().toUpperCase();
                        Categoria categoria = Categoria.valueOf(catInput);

                        System.out.print("Precio ($): ");
                        double precio = Double.parseDouble(sc.nextLine());

                        System.out.print("Stock: ");
                        int stock = Integer.parseInt(sc.nextLine());

                        Producto nuevo = new Producto(id, nombre, categoria, precio, stock);
                        service.agregar(nuevo);
                        System.out.println("\n[✓] ¡Producto agregado exitosamente!");
                        break;

                    case 3:
                        // Lógica para BUSCAR (Luis Alonso)
                        System.out.println("\n--- BUSCAR PRODUCTO POR ID ---");
                        System.out.print("Ingrese el ID a buscar (formato P###, ej. P010): ");
                        String idBusqueda = sc.nextLine();

                        Producto encontrado = service.buscar(idBusqueda);
                        if (encontrado == null) {
                            System.out.println("\n[!] No se encontró ningún producto con el ID: " + idBusqueda.trim());
                        } else {
                            System.out.println("\n[✓] Producto encontrado:");
                            System.out.println(encontrado);
                        }
                        break;

                    case 4:
                        // Integración UI: conecta modificar() de Camila (service ya en main).
                        System.out.println("\n--- MODIFICAR PRODUCTO ---");
                        System.out.print("ID del producto a modificar (P###): ");
                        String idMod = sc.nextLine();

                        Producto actual = service.buscar(idMod);
                        if (actual == null) {
                            System.out.println("\n[!] No se encontró ningún producto con el ID: " + idMod.trim());
                            break;
                        }

                        System.out.println("Producto actual: " + actual);
                        System.out.print("Nuevo nombre (3 a 50 chars): ");
                        String nombreMod = sc.nextLine();

                        System.out.println("Categorías disponibles:");
                        for (Categoria c : Categoria.values()) {
                            System.out.println(" - " + c.name() + " (" + c.getEtiqueta() + ")");
                        }
                        System.out.print("Nueva categoría (ej. LIMPIEZA): ");
                        Categoria catMod = Categoria.valueOf(sc.nextLine().trim().toUpperCase());

                        System.out.print("Nuevo precio ($): ");
                        double precioMod = Double.parseDouble(sc.nextLine());

                        System.out.print("Nuevo stock: ");
                        int stockMod = Integer.parseInt(sc.nextLine());

                        service.modificar(idMod, nombreMod, catMod, precioMod, stockMod);
                        System.out.println("\n[✓] Producto modificado exitosamente.");
                        break;

                    case 5:
                        // Contar (Esmeralda)
                        int total = service.contar();
                        System.out.println("\n[i] Total de productos registrados: " + total);
                        break;

                    case 6:
                        System.out.println("\n¡Saliendo del sistema!");
                        break;

                    default:
                        System.out.println("\n[!] Opción no válida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n[✕] Error de validación: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n[✕] Error en la entrada de datos: " + e.getMessage());
            }

        } while (opcion != 6);

        sc.close();
    }
}
