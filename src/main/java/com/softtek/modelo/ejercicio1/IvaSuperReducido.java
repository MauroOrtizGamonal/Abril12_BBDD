package com.softtek.modelo.ejercicio1;

public class IvaSuperReducido implements Impuesto {
    @Override
    public double calcularImpuesto(Producto producto) {
        // Supongamos que el impuesto super reducido es el 4%
        return producto.getPrecio() * 0.04;
    }
}
