package com.dots.server.lists.board;

public class ListaCuadros {

    public ListaCuadros next;
    public ListaCuadros prev;
    public int largo;
    public NodoCuadros head;

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

    public void anadirElemento(int v1x, int v1y){
        if (this.head == null) {
            this.head = new NodoCuadros(v1x, v1y);
            this.largo++;
        }
        else{
            NodoCuadros tmp = this.head;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new NodoCuadros(v1x, v1y);
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
