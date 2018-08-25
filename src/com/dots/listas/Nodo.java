package com.dots.listas;

/**
 * Clase nodo, se utiliza en conjunto con listas para almacenar datos
 * @param <A> Tipo de dato, puede ser int, string, boolean, entre otros
 */

public class Nodo<A> {
    public Nodo<A> sigue;
    private A dato;

    /**
     * Contructor de la clase nodo
     * @param dato almacena el dato introducido por el usuario
     */

    public Nodo(A dato){
        this.dato = dato;
        this.sigue = null;
    }

    /**
     * Getters y Setters de la clase nodo
     */

    public A getDato() {
        return this.dato;
    }

    public void setDato(A dato) {
        this.dato = dato;
    }

    public Nodo<A> getSigue() {
        return this.sigue;
    }

    public void setSigue(Nodo<A> sigue) {
        this.sigue = sigue;
    }
}
