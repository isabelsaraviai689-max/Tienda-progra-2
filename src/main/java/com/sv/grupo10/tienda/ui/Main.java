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
            System.out.println("1. Mostrar productos (Anderson)");
            System.out.println("2. Agregar producto (Anderson)");
            System.out.println("3. Buscar producto por ID (Luis Alonso)");
            System.out.println("4. Modificar producto (Camila)");
            System.out.println("5. Contar productos (Esmeralda)");
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
                    case 4:
                    case 5:
                        System.out.println("\n[i] Módulo en desarrollo por otros integrantes.");
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