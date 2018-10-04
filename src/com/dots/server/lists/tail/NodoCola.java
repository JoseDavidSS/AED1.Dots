package com.dots.server.lists.tail;

public class NodoCola {

    public NodoCola next;
    private int ficha;

    public NodoCola(int ficha){
        this.next = null;
        this.ficha = ficha;
    }

    public int getFicha() {
        return this.ficha;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
    }
}
