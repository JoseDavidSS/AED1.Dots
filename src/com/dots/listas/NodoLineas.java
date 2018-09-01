package com.dots.listas;

public class NodoLineas {

    public NodoLineas next;
    public NodoLineas prev;
    private int posxi;
    private int posxf;
    private int posyi;
    private int posyf;

    public NodoLineas(int posxi, int posxf, int posyi, int posyf) {
        this.next = null;
        this.prev = null;
        this.posxi = posxi;
        this.posxf = posxf;
        this.posyi = posyi;
        this.posyf = posyf;
    }

    public int getPosxi() {
        return this.posxi;
    }

    public void setPosxi(int posxi) {
        this.posxi = posxi;
    }

    public int getPosxf() {
        return this.posxf;
    }

    public void setPosxf(int posxf) {
        this.posxf = posxf;
    }

    public int getPosyi() {
        return this.posyi;
    }

    public void setPosyi(int posyi) {
        this.posyi = posyi;
    }

    public int getPosyf() {
        return this.posyf;
    }

    public void setPosyf(int posyf) {
        this.posyf = posyf;
    }
}
