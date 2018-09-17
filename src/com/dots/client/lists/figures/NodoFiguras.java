package com.dots.listas.server;

public class NodoFiguras {

    public NodoFiguras next;
    private NodoLineas l1;
    private NodoLineas l2;
    private NodoLineas l3;
    private NodoLineas l4;

    public NodoFiguras(NodoLineas l1, NodoLineas l2, NodoLineas l3, NodoLineas l4) {
        this.next = null;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;
    }

    public NodoLineas getL1() {
        return this.l1;
    }

    public void setL1(NodoLineas l1) {
        this.l1 = l1;
    }

    public NodoLineas getL2() {
        return this.l2;
    }

    public void setL2(NodoLineas l2) {
        this.l2 = l2;
    }

    public NodoLineas getL3() {
        return this.l3;
    }

    public void setL3(NodoLineas l3) {
        this.l3 = l3;
    }

    public NodoLineas getL4() {
        return this.l4;
    }

    public void setL4(NodoLineas l4) {
        this.l4 = l4;
    }
}
