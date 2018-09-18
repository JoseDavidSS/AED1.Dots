package com.dots.server.lists.dots;

/**
 * Clase de listas simples
 */

public class ListaVertices {

    private static com.dots.server.lists.dots.ListaVertices ListaVertices = new ListaVertices();
    private int largo = 0;
    private NodoVertices head = null;

    public static com.dots.server.lists.dots.ListaVertices getInstance(){
        return ListaVertices;
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
     */

    public void anadirElemento(int posx, int posy){
        if (this.head == null) {
            this.head = new NodoVertices(posx, posy);
            this.largo++;
        }
        else{
            NodoVertices tmp = this.head;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new NodoVertices(posx, posy);
            this.largo++;
        }
    }

    /**
     * Metodo para imprimir la lista
     */

    public void imprimirLista(){
        NodoVertices tmp = this.head;
        System.out.println("Cambio lista");
        while(tmp != null) {
            System.out.println("Posx" + tmp.getPosx());
            System.out.println("Posy" + tmp.getPosy());
            tmp = tmp.next;
        }
    }

}
