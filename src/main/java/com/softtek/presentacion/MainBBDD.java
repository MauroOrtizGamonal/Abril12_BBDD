package com.softtek.presentacion;

import com.softtek.modelo.ejercicio2.DetalleOrden;
import com.softtek.modelo.ejercicio2.ProductoSumaCantidades;
import com.softtek.persistencia.AccesoDatos;

import java.sql.SQLException;
import java.util.List;

public class MainBBDD {

    public static void main(String[] args) {
        AccesoDatos accesoDatos = new AccesoDatos();
        try {
            List<DetalleOrden> detalles = accesoDatos.obtenerDetallesMayor30();
            // Mostrar detalles cuyo precio unitario sea mayor que 30
            for (DetalleOrden detalle : detalles) {
                System.out.println(detalle.getOrderId() + ", " + detalle.getProductId() + ", " +
                        detalle.getUnitPrice() + ", " + detalle.getQuantity());
            }

            DetalleOrden detalleMinimo = accesoDatos.obtenerDetallePrecioMinimo();
            // Mostrar detalle con precio mínimo
            if (detalleMinimo != null) {
                System.out.println("Detalle con precio mínimo: " + detalleMinimo.getOrderId() + ", " +
                        detalleMinimo.getProductId() + ", " + detalleMinimo.getUnitPrice() + ", " +
                        detalleMinimo.getQuantity());
            }

            List<ProductoSumaCantidades> sumaCantidadesPorProducto = accesoDatos.obtenerSumaCantidadesPorProducto();
            // Mostrar productos y la suma de sus cantidades
            for (ProductoSumaCantidades productoSuma : sumaCantidadesPorProducto) {
                System.out.println("Producto ID: " + productoSuma.getProductId() + ", Suma Cantidades: " +
                        productoSuma.getSumaCantidad());
            }

            // Otros ejercicios

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
