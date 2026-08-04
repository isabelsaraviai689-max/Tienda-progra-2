package com.sv.grupo10.tienda.ui;

import com.sv.grupo10.tienda.service.TiendaService;
import com.sv.grupo10.tienda.service.TiendaServiceImplementacion;

import java.util.Scanner;

/**
 * Entrada de la app (capa UI).
 *
 * TODO (Isabel): menu con Scanner. Solo llama al service.
 *
 * Menu:
 * 1. Agregar producto
 * 2. Mostrar todos los productos
 * 3. Buscar producto (solo por ID)
 * 4. Modificar producto
 * 5. Contar productos registrados
 * 6. Salir
 *
 * UI: leer input, armar Producto, re-pedir si el parse falla.
 * Si buscar/modificar no encuentra: mensaje y seguir (no salir).
 * Si mostrar() viene vacia: informar "lista vacia" (no pantalla en blanco).
 * Negocio (unicidad, rangos, decimales, etc.): en service, no aqui.
 */
public class Main {

    public static void main(String[] args) {
        TiendaService service = new TiendaServiceImplementacion();
        Scanner sc = new Scanner(System.in);

        // TODO (Isabel): menu real (do/while + switch).
        // Opcion 2: si lista vacia -> mensaje; no dejar pantalla en blanco.
        System.out.println("===== MENU TIENDA - GRUPO 10 =====");
        System.out.println("Menu pendiente de implementar.");
        System.out.println("Productos seed cargados (via service): " + service.convertirALista().size());

        sc.close();
    }
}
