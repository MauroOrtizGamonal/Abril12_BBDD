package com.softtek.presentacion;
import com.softtek.modelo.ejercicio1.Factura;
import com.softtek.modelo.ejercicio1.IvaGeneral;
import com.softtek.modelo.ejercicio1.IvaSuperReducido;
import com.softtek.modelo.ejercicio1.Producto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instanciar productos
        Producto producto1 = new Producto("Producto 1", 10);
        Producto producto2 = new Producto("Producto 2", 20);

        // Inyectar la clase factura con el impuesto general
        Factura facturaIvaGeneral = new Factura(new IvaGeneral(), List.of(producto1, producto2));

        // Calcular factura con iva general
        System.out.println("Total factura con IVA general: " + facturaIvaGeneral.calcularTotalFactura());

        // Inyectar la clase factura con el impuesto super reducido
        Factura facturaIvaSuperReducido = new Factura(new IvaSuperReducido(), List.of(producto1, producto2));

        // Calcular factura con iva super reducido
        System.out.println("Total factura con IVA super reducido: " + facturaIvaSuperReducido.calcularTotalFactura());
    }
}
