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

    /***
     *
     * @param filas_columnas tamaño del tablero
     * @param x Posicion en x del vertice superior derecho del cuadro
     * @param y Posicion en y del vertice superior derecho del cuadro
     */

    public void anadirElemento(int filas_columnas,int x,int y){
        if (this.head == null) {
            this.head = new NodoCuadros(x,y);
            this.largo++;
        }
        else{
            NodoCuadros tmp = this.head;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new NodoCuadros(tmp.get_x()+(350/filas_columnas),y);
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
