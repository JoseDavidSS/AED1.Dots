package com.dots.client.lists.board;

public class NodoCuadros {

    public NodoCuadros next;
    public NodoCuadros prev;
    private int estado;

    public NodoCuadros() {
        this.next = null;
        this.prev = null;
        this.estado = 0;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
