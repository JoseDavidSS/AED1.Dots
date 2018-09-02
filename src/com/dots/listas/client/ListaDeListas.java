package com.dots.listas.client;

public class ListaDeListas {

    private int largo;
    private ListaSimple head;
    public static ListaDeListas ListaLista;

    private ListaDeListas() {
        this.largo = 0;
        this.head = null;
    }

    public static ListaDeListas getLista(){
        if (ListaLista == null){
            ListaLista = new ListaDeListas();
        }
        else{
            return ListaLista;
        }
        return null;
    }

    public int getLargo() {
        return this.largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void anadirElemento(int filas_columnas, int numNodo, int posx, int posy) {
        if (filas_columnas > 2) {
            int filas = filas_columnas;
            int columnas = filas_columnas;
            int rposx = posx;
            while (filas != 0) {
                if (this.head == null) {
                    this.head = new ListaSimple();
                    while (columnas != 0){
                        this.head.anadirElemento(numNodo, posx, posy);
                        columnas--;
                        posx++;
                        numNodo++;
                    }
                    filas--;
                    posy++;
                    columnas = filas_columnas;
                    posx = rposx;
                    this.largo++;
                } else {
                    ListaSimple tmp = this.head;
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = new ListaSimple();
                    tmp.next.prev = tmp;
                    while (columnas != 0){
                        tmp.next.anadirElemento(numNodo, posx, posy);
                        columnas--;
                        posx++;
                        numNodo++;
                    }
                    filas--;
                    posy++;
                    columnas = filas_columnas;
                    posx = rposx;
                    this.largo++;
                }
            }
        } else {
            System.out.println("Error, el tamaño mínimo de la plantilla es de 3x3");
        }
    }

    public void imprimirLista(){
        ListaSimple tmp = this.head;
        while (tmp != null){
            tmp.imprimirLista();
            tmp = tmp.next;
        }
    }

}
