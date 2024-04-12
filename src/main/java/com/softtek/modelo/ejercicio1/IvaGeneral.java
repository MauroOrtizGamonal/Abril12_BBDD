package com.softtek.modelo.ejercicio1;

public class IvaGeneral implements Impuesto {
    @Override
    public double calcularImpuesto(Producto producto) {
        // Supongamos que el impuesto general es el 21%
        return producto.getPrecio() * 0.21;
    }
}
