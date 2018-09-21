package com.dots.server.lists.lines;

/**
 * Clase que almacena una línea.
 */

public class NodoLineas {

    public NodoLineas next;
    public NodoLineas prev;
    private int posxi;
    private int posxf;
    private int posyi;
    private int posyf;

    /**
     * Constructor de la clase.
     * @param posxi Eje x del vértice inicial de la lista.
     * @param posxf Eje x del vértice final de la lista.
     * @param posyi Eje y del vértice inicial de la lista.
     * @param posyf Eje y del vértice final de la lista.
     */

    public NodoLineas(int posxi, int posxf, int posyi, int posyf) {
        this.next = null;
        this.prev = null;
        this.posxi = posxi;
        this.posxf = posxf;
        this.posyi = posyi;
        this.posyf = posyf;
    }

    /**
     * Método para obtener la posición en x inicial de la línea.
     * @return entero con la posición.
     */

    public int getPosxi() {
        return this.posxi;
    }

    /**
     * Método para modificar la posición en x inicial de la línea.
     * @param posxi entero con la nueva posición.
     */

    public void setPosxi(int posxi) {
        this.posxi = posxi;
    }

    /**
     * Método para obtener la posición en x final de la línea.
     * @return entero con la posición.
     */

    public int getPosxf() {
        return this.posxf;
    }

    /**
     * Método para modificar la posición en x final de la línea.
     * @param posxf entero con la nueva posición.
     */

    public void setPosxf(int posxf) {
        this.posxf = posxf;
    }

    /**
     * Método para obtener la posición en y inicial de la línea.
     * @return entero con la posición.
     */

    public int getPosyi() {
        return this.posyi;
    }

    /**
     * Método para modificar la posición en y inicial de la línea.
     * @param posyi entero con la nueva posición.
     */

    public void setPosyi(int posyi) {
        this.posyi = posyi;
    }

    /**
     * Método para obtener la posición en y final de la línea.
     * @return entero con la posición.
     */

    public int getPosyf() {
        return this.posyf;
    }

    /**
     * Método para modificar la posición en y final de la línea.
     * @param posyf entero con la nueva posición.
     */

    public void setPosyf(int posyf) {
        this.posyf = posyf;
    }
}
