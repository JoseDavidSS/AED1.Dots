package com.dots.listas;

public class ListaSimpleLineas {

    private NodoLineas head;
    private int largo;
    private static ListaSimpleLineas ListaLineas;

    private ListaSimpleLineas() {
        this.head = null;
        this.largo = 0;
    }

    public static ListaSimpleLineas getLista(){
        if (ListaLineas == null){
            ListaLineas = new ListaSimpleLineas();
        }
        else{
            return ListaLineas;
        }
        return null;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void anadirElemento(int posxi, int posxf, int posyi, int posyf){
        if (this.head == null){
            this.head = new NodoLineas(posxi, posxf, posyi, posyf);
            this.largo++;
        }
        else{
            NodoLineas tmp = this.head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new NodoLineas(posxi, posxf, posyi, posyf);
            tmp.next.prev = tmp;
            this.largo++;
        }
    }

}
