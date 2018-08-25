package com.dots.listas;

/**
 * Clase de listas simples
 * @param <A> Tipo de dato que almacena la lista
 */

public class ListaSimple<A> {
    private int largo;
    private Nodo<A> cabeza;

    /**
     * Constructor de la clase lista
     */

    public ListaSimple(){
        this.largo = 0;
        this.cabeza = null;
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
     * @param dato ingresa el dato que almacena el nodo
     */

    public void anadirElemento(A dato){
        if (this.cabeza == null)
            this.cabeza = new Nodo<>(dato);
        else{
            Nodo<A> tmp = this.cabeza;
            while(tmp.sigue != null)
                tmp = tmp.sigue;
            tmp.sigue = new Nodo<>(dato);
        }
    }

    /**
     * Metodo para imprimir la lista
     */

    public void imprimirLista(){
        Nodo<A> tmp = this.cabeza;
        while(tmp != null) {
            System.out.println(tmp.getDato());
            tmp = tmp.sigue;
        }
    }

}
