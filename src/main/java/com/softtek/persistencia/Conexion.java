package com.softtek.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection miConexion;

    public void abrirConexion() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/northwind", "postgres", "root");
            System.out.println("Conexión abierta");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador de la base de datos: " + e.getMessage());
            throw new SQLException("Error al abrir la conexión", e);
        }
    }

    public Connection getMiConexion() {
        return miConexion;
    }

    public void cerrarConexion() {
        if (miConexion != null) {
            try {
                miConexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
