package com.softtek.persistencia;

import com.softtek.modelo.ejercicio2.DetalleOrden;
import com.softtek.modelo.ejercicio2.ProductoSumaCantidades;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class AccesoDatos {

    private Connection miConexion;

    public AccesoDatos() {
        Conexion conexion = new Conexion();
        try {
            conexion.abrirConexion();
            miConexion = conexion.getMiConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DetalleOrden> consultarDetallesOrdenes() throws SQLException {
        List<DetalleOrden> detalles = new ArrayList<>();
        String query = "SELECT * FROM order_details";
        try (Statement stmt = miConexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                detalles.add(new DetalleOrden(rs.getInt("order_id"), rs.getInt("product_id"),
                        rs.getDouble("unit_price"), rs.getInt("quantity")));
            }
        }
        return detalles;
    }

    public List<DetalleOrden> obtenerDetallesMayor30() throws SQLException {
        return consultarDetallesOrdenes().stream()
                .filter(detalle -> detalle.getUnitPrice() > 30)
                .collect(Collectors.toList());
    }

    public List<DetalleOrden> ordenarPorPrecioDescendente() throws SQLException {
        return consultarDetallesOrdenes().stream()
                .sorted((detalle1, detalle2) -> Double.compare(detalle2.getUnitPrice(), detalle1.getUnitPrice()))
                .collect(Collectors.toList());
    }

    public DetalleOrden obtenerDetallePrecioMinimo() throws SQLException {
        return consultarDetallesOrdenes().stream()
                .min(Comparator.comparingDouble(DetalleOrden::getUnitPrice))
                .orElse(null);
    }

    public IntSummaryStatistics obtenerEstadisticasCantidad() throws SQLException {
        return consultarDetallesOrdenes().stream()
                .mapToInt(DetalleOrden::getQuantity)
                .summaryStatistics();
    }

    public List<ProductoSumaCantidades> obtenerSumaCantidadesPorProducto() throws SQLException {
        return consultarDetallesOrdenes().stream()
                .collect(Collectors.groupingBy(DetalleOrden::getProductId,
                        Collectors.summingInt(DetalleOrden::getQuantity)))
                .entrySet().stream()
                .map(entry -> new ProductoSumaCantidades(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
