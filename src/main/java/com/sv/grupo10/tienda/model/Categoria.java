package com.sv.grupo10.tienda.model;

/** Categorias validas del sistema. */
public enum Categoria {
    GRANOS("Granos"),
    BEBIDAS("Bebidas"),
    LACTEOS("Lacteos"),
    PANADERIA("Panaderia"),
    SNACKS("Snacks"),
    COCINA("Cocina"),
    PASTAS("Pastas"),
    ENLATADOS("Enlatados"),
    HIGIENE("Higiene"),
    LIMPIEZA("Limpieza"),
    DULCES("Dulces");

    private final String etiqueta;

    Categoria(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}
