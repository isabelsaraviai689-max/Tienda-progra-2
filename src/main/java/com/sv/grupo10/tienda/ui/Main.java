package com.sv.grupo10.tienda.ui;

import com.sv.grupo10.tienda.service.TiendaService;
import com.sv.grupo10.tienda.service.TiendaServiceImplementacion;

import java.util.Scanner;

/**
 * Punto de entrada de la aplicacion.
 *
 * TODO (Isabel - SM): construir aqui el menu interactivo con Scanner.
 * "service" ya te da acceso a: agregar(), mostrar(), buscar(), modificar(),
 * contar() y convertirALista(). No necesitas tocar el service, solo
 * consumirlo desde este menu.
 *
 * Sugerencia de opciones (a confirmar con Marcos - PO, que define el alcance):
 * 1. Agregar producto
 * 2. Mostrar productos
 * 3. Buscar producto
 * 4. Modificar producto
 * 5. Contar productos
 * 6. Salir
 */
public class Main {

    public static void main(String[] args) {
        TiendaService service = new TiendaServiceImplementacion();
        Scanner sc = new Scanner(System.in);

        // TODO (Isabel - SM): reemplazar esto con el menu real.
        System.out.println("Sistema de Inventario - Tienda (Grupo 10)");
        System.out.println("Menu pendiente de implementar.");

        sc.close();
    }
}