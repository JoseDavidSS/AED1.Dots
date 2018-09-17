package com.dots.sockets.pruebas;

public class Nodo {
    int valor;
    Nodo next;


    public Nodo(int valor){
        this.valor = valor;
        this.next = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}