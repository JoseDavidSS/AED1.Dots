package com.dots.server.lists.dots;

/**
 * Clase para almacenar un vértice (un botón que presiona el usuario)
 */

public class NodoVertices {

    public NodoVertices next;
    private int posx;
    private int posy;

    /**
     * Constructor de la clase.
     * @param posx Atributo que almacena la posición en x del vértice.
     * @param posy Atributo que almacena la posición en y del vértice.
     */

    public NodoVertices(int posx, int posy) {
        this.next = null;
        this.posx = posx;
        this.posy = posy;
    }

    /**
     * Método para obtener la posición en x del vértice.
     * @return entero con la posición en x del vértice.
     */

    public int getPosx() {
        return this.posx;
    }

    /**
     * Método para modificar la posición en x del vértice.
     * @param posx entero con la nueva posición en x.
     */

    public void setPosx(int posx) {
        this.posx = posx;
    }

    /**
     * Método para obtener la posición en y del vértice.
     * @return entero con la posición en y del vértice.
     */

    public int getPosy() {
        return this.posy;
    }

    /**
     * Método para modificar la posición en y del vértice.
     * @param posy entero con la nueva posición en y.
     */

    public void setPosy(int posy) {
        this.posy = posy;
    }

}
