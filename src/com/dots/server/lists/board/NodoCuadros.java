package com.dots.server.lists.board;

public class NodoCuadros {

    public NodoCuadros next;
    public NodoCuadros prev;
    private int estado;
    private int v1x;
    private int v1y;


    public NodoCuadros(int v1x, int v1y) {
        this.next = null;
        this.prev = null;
        this.estado = 0;
        this.v1x = v1x;
        this.v1y = v1y;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getV1x() {
        return this.v1x;
    }

    public void setV1x(int v1x) {
        this.v1x = v1x;
    }

    public int getV1y() {
        return this.v1y;
    }

    public void setV1y(int v1y) {
        this.v1y = v1y;
    }

}
