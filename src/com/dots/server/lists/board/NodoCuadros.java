package com.dots.server.lists.board;

/**
 * Clase que almacena un cuadro de juego.
 */

public class NodoCuadros {

    public NodoCuadros next;
    public NodoCuadros prev;
    private int estado;
    private int x;
    private int y;

    /**
     * Constructor de la clase.
     * @param x Atributo del eje superior derecho del cuadro.
     * @param y Atributo del eje superior derecho del cuadro.
     */

    public NodoCuadros(int x, int y) {
        this.next = null;
        this.prev = null;
        this.estado = 0;
        this.x = x;
        this.y = y;
    }

    /**
     * Método para obtener el estado del cuadro, varía entre 0, 1 y 2.
     * @return entero con el estado del cuadro.
     */

    public int getEstado() {
        return this.estado;
    }

    /**
     * Método para modificar el estado del cuadro.
     * @param estado entero con el nuevo estado.
     */

    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * Método para obtener el eje x superior derecho del cuadro.
     * @return entero con el eje.
     */

    public int get_x() {
        return this.x;
    }

    /**
     * Método para modificar el eje x superior derecho del cuadro.
     * @param v1x entero con el nuevo valor.
     */

    public void set_x(int v1x) {
        this.x = v1x;
    }

    /**
     * Método para obtener el eje y superior derecho del cuadro.
     * @return entero con el eje.
     */

    public int get_y() {
        return this.y;
    }

    /**
     * Método para modificar el eje y superior derecho del cuadro.
     * @param v1y entero con el nuevo valor.
     */

    public void set_y(int v1y) {
        this.y = v1y;
    }

}
