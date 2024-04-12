package com.softtek.modelo.ejercicio2;

public class ProductoSumaCantidades {
    private int productId;
    private int sumaCantidad;

    public ProductoSumaCantidades(int productId, int sumaCantidad) {
        this.productId = productId;
        this.sumaCantidad = sumaCantidad;
    }

    public int getProductId() {
        return productId;
    }

    public int getSumaCantidad() {
        return sumaCantidad;
    }
}