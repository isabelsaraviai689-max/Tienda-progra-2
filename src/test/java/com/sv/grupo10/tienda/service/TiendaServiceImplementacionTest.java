package com.sv.grupo10.tienda.service;

import com.sv.grupo10.tienda.model.Categoria;
import com.sv.grupo10.tienda.model.Producto;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Nomeclatura de Pruebas: AAA (Organizar, Actuar, Afirmar)

class TiendaServiceImplementacionTest {

    @Test
    void agregar_agregarProducto_PrductoSeAgregaAlaColleccion() {

        //(Preparar: Instanciar dependencias y variables)
        TiendaService service = new TiendaServiceImplementacion();
        List<Producto> lista = service.mostrar();
        String id = "P111";
        String nombre = "Papitas Lays";
        Categoria categoria = Categoria.SNACKS;
        double precio = 0.50;
        int stock = 7;
        Producto nuevo = new Producto(id, nombre, categoria, precio, stock);

        //(Actuar: Ejecutar el metodo a probar)
        service.agregar(nuevo);

        //Afirmar: Verificar que el resultado coincide con lo esperado
        assertEquals("P111", lista.get(20).getId());
        assertEquals("Papitas Lays", lista.get(20).getNombre());
        assertEquals(Categoria.SNACKS, lista.get(20).getCategoria());
        assertEquals(0.50, lista.get(20).getPrecio());
        assertEquals(7, lista.get(20).getStock());
    }

    @Test
    void mostrar_solicitarTodosLosProductos_mensajePorConsola() {
        System.out.println("Nada que validar, mensaje por consola");
    }

    @Test
    void buscar_BuscarProductoEspecifico_ProductoEncontrado() {

        //Preparar
        TiendaService service = new TiendaServiceImplementacion();
        List<Producto> lista = service.mostrar();
        String idTest = "P012";

        //Actuar
        String idProducto = service.buscar("P012").getId();

        //Afirmar
        assertEquals(idTest, idProducto);
    }

    @Test
    void modificar_CambiarValoresDeProducto_ProductoSeActualiza() {

        //Preparar
        TiendaService service = new TiendaServiceImplementacion();
        List<Producto> lista = service.mostrar();
        String id = "P005";
        String nombre = "Pan de Caja Grande";
        Categoria categoria = Categoria.PANADERIA;
        double precio = 3.10;
        int stock = 18;

        //Actuar
        service.modificar(id, nombre, categoria, precio, stock);

        //Afirmar
        assertEquals(id, lista.get(4).getId());
        assertEquals(nombre, lista.get(4).getNombre());
        assertEquals(categoria, lista.get(4).getCategoria());
        assertEquals(precio, lista.get(4).getPrecio());
        assertEquals(stock, lista.get(4).getStock());
    }

    @Test
    void contar_ContarTodosLosProductos_RetornaCantidadProductos() {

        //Preparar
        TiendaService service = new TiendaServiceImplementacion();
        List<Producto> lista = service.mostrar();

        //Actuar
        int totalProductos = service.contar();

        //Afirmar
        assertEquals(lista.size(), totalProductos);

    }
}