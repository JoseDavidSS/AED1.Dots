package com.dots.listas.client;

/**
 * Clase nodo, se utiliza en conjunto con listas para almacenar datos
 */

public class Nodo{

    public Nodo next;
    public Nodo prev;
    private int numNodo;
    private int posx;
    private int posy;

    public Nodo(int numNodo, int posx, int posy) {
        this.next = null;
        this.prev = null;
        this.numNodo = numNodo;
        this.posx = posx;
        this.posy = posy;
    }

    public int getNumNodo() {
        return this.numNodo;
    }

    public void setNumNodo(int numNodo) {
        this.numNodo = numNodo;
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
