package com.dots.server.lists.board;

public class ListaCuadros {

    public ListaCuadros next;
    public ListaCuadros prev;
    private int largo;
    private NodoCuadros head;

    public ListaCuadros(){
        this.next = null;
        this.prev = null;
        this.largo = 0;
        this.head = null;
    }

    public int getLargo() {
        return this.largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void anadirElemento(int v1x, int v1y, int v2x, int v2y, int v3x, int v3y, int v4x, int v4y){
        if (this.head == null) {
            this.head = new NodoCuadros(v1x, v1y, v2x, v2y, v3x, v3y, v4x, v4y);
            this.largo++;
        }
        else{
            NodoCuadros tmp = this.head;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new NodoCuadros(v1x, v1y, v2x, v2y, v3x, v3y, v4x, v4y);
            tmp.next.prev = tmp;
            this.largo++;
        }
    }

    public void imprimirLista(){
        NodoCuadros tmp = this.head;
        while(tmp != null) {
            System.out.println("Nodo Estado: " + tmp.getEstado());
            tmp = tmp.next;
        }
    }

}
