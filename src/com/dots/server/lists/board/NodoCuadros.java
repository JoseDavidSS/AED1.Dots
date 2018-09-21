package com.dots.server.lists.board;

public class NodoCuadros {

    public NodoCuadros next;
    public NodoCuadros prev;
    private int estado;
    private int x;
    private int y;


    public NodoCuadros(int x, int y) {
        this.next = null;
        this.prev = null;
        this.estado = 0;
        this.x = x;
        this.y = y;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int get_x() {
        return this.x;
    }

    public void set_x(int v1x) {
        this.x = v1x;
    }

    public int get_y() {
        return this.y;
    }

    public void set_y(int v1y) {
        this.y = v1y;
    }

}
