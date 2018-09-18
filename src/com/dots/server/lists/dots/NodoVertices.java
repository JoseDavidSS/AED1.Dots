package com.dots.server.lists.dots;

/**
 * Clase nodo, se utiliza en conjunto con listas para almacenar datos
 */

public class NodoVertices {

    public NodoVertices next;
    private int posx;
    private int posy;

    public NodoVertices(int posx, int posy) {
        this.next = null;
        this.posx = posx;
        this.posy = posy;
    }

    public int getPosx() {
        return this.posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return this.posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
}
