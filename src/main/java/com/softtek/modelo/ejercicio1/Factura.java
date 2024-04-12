package com.softtek.modelo.ejercicio1;

import java.util.List;

public class Factura {
    private Impuesto impuesto;
    private List<Producto> productos;

    public Factura(Impuesto impuesto, List<Producto> productos) {
        this.impuesto = impuesto;
        this.productos = productos;
    }

    public double calcularTotalFactura() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() + impuesto.calcularImpuesto(producto);
        }
        return total;
    }
}
