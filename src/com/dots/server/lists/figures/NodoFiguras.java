package com.dots.server.lists.figures;

/**
 * Clase que almacena una figura
 */

public class NodoFiguras {

    public NodoFiguras next;
    private int v1x;
    private int v1y;
    private int v2x;
    private int v2y;
    private int v3x;
    private int v3y;
    private int v4x;
    private int v4y;

    /**
     * Constructor de la clase.
     * @param v1x Primer vértice en x.
     * @param v1y Primer vértice en y.
     * @param v2x Segundo vértice en x.
     * @param v2y Segundo vértice en y.
     * @param v3x Tercer vértice en x.
     * @param v3y Tercer vértice en y.
     * @param v4x Cuarto vértice en x, si es un triángulo será 0.
     * @param v4y Cuarto vértice en y, si es un triángulo será 0.
     */

    public NodoFiguras(int v1x, int v1y, int v2x, int v2y, int v3x, int v3y, int v4x, int v4y) {
        this.next = null;
        this.v1x = v1x;
        this.v1y = v1y;
        this.v2x = v2x;
        this.v2y = v2y;
        this.v3x = v3x;
        this.v3y = v3y;
        this.v4x = v4x;
        this.v4y = v4y;
    }

    /**
     * Método para obtener el eje x del primer vértice.
     * @return entero con el eje x del vértice.
     */

    public int getV1x() {
        return this.v1x;
    }

    /**
     * Método para modificar el eje x del primer vértice.
     * @param v1x entero con el nuevo eje.
     */

    public void setV1x(int v1x) {
        this.v1x = v1x;
    }

    /**
     * Método para obtener el eje y del primer vértice.
     * @return entero con el eje y del vértice.
     */

    public int getV1y() {
        return this.v1y;
    }

    /**
     * Método para modificar el eje y del primer vértice.
     * @param v1y entero con el nuevo eje.
     */

    public void setV1y(int v1y) {
        this.v1y = v1y;
    }

    /**
     * Método para obtener el eje x del segundo vértice.
     * @return entero con el eje x del vértice.
     */

    public int getV2x() {
        return this.v2x;
    }

    /**
     * Método para modificar el eje x del segundo vértice.
     * @param v2x entero con el nuevo eje.
     */

    public void setV2x(int v2x) {
        this.v2x = v2x;
    }

    /**
     * Método para obtener el eje y del segundo vértice.
     * @return entero con el eje y del vértice.
     */

    public int getV2y() {
        return this.v2y;
    }

    /**
     * Método para modificar el eje y del segundo vértice.
     * @param v2y entero con el nuevo eje.
     */

    public void setV2y(int v2y) {
        this.v2y = v2y;
    }

    /**
     * Método para obtener el eje x del tercer vértice.
     * @return entero con el eje x del vértice.
     */

    public int getV3x() {
        return this.v3x;
    }

    /**
     * Método para modificar el eje x del tercer vértice.
     * @param v3x entero con el nuevo eje.
     */

    public void setV3x(int v3x) {
        this.v3x = v3x;
    }

    /**
     * Método para obtener el eje y del tercer vértice.
     * @return entero con el eje y del vértice.
     */

    public int getV3y() {
        return this.v3y;
    }

    /**
     * Método para modificar el eje x del tercer vértice.
     * @param v3y entero con el nuevo eje.
     */

    public void setV3y(int v3y) {
        this.v3y = v3y;
    }

    /**
     * Método para obtener el eje x del cuarto vértice.
     * @return entero con el eje x del vértice.
     */

    public int getV4x() {
        return this.v4x;
    }

    /**
     * Método para modificar el eje x del cuarto vértice.
     * @param v4x entero con el nuevo eje.
     */

    public void setV4x(int v4x) {
        this.v4x = v4x;
    }

    /**
     * Método para obtener el eje y del cuarto vértice.
     * @return entero con el eje y del vértice.
     */

    public int getV4y() {
        return this.v4y;
    }

    /**
     * Método para modificar el eje y del cuarto vértice.
     * @param v4y entero con el nuevo eje.
     */

    public void setV4y(int v4y) {
        this.v4y = v4y;
    }
}
