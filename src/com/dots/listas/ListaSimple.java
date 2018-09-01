package com.dots.listas;

/**
 * Clase de listas simples
 */

public class ListaSimple {

    public ListaSimple next;
    public ListaSimple prev;
    private int largo;
    private Nodo head;

    /**
     * Constructor de la clase lista
     */

    public ListaSimple(){
        this.next = null;
        this.prev = null;
        this.largo = 0;
        this.head = null;
    }

    /**
     * Getters y setters de la clase
     */

    public int getLargo() {
        return this.largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    /**
     * Metodo que agrega un elemento a la lista
     * @param numNodo ingresa el dato que almacena el nodo
     */

    public void anadirElemento(int numNodo, int posx, int posy){
        if (this.head == null) {
            this.head = new Nodo(numNodo, posx, posy);
            this.largo++;
        }
        else{
            Nodo tmp = this.head;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Nodo(numNodo, posx, posy);
            tmp.next.prev = tmp;
            this.largo++;
        }
    }

    /**
     * Metodo para imprimir la lista
     */

    public void imprimirLista(){
        Nodo tmp = this.head;
        System.out.println("Cambio lista");
        while(tmp != null) {
            System.out.println("Nodo" + tmp.getNumNodo());
            System.out.println("Posx" + tmp.getPosx());
            System.out.println("Posy" + tmp.getPosy());
            tmp = tmp.next;
        }
    }

}
