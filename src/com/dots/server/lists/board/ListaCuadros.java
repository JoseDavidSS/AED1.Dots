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

    public void anadirElemento(){
        if (this.head == null) {
            this.head = new NodoCuadros();
            this.largo++;
        }
        else{
            NodoCuadros tmp = this.head;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new NodoCuadros();
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
