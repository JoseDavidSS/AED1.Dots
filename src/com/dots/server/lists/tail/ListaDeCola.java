package com.dots.server.lists.tail;

public class ListaDeCola {

    public static ListaDeCola lista = new ListaDeCola();
    public NodoCola head = null;
    private int largo = 0;

    public static ListaDeCola getInstance(){
        return lista;
    }

    public static void setInstance(ListaDeCola listan){
        lista = listan;
    }

    public static void reinicio(){
        lista = new ListaDeCola();
    }

    public int getLargo() {
        return this.largo;
    }

    public void anadirElemento(){
        if (this.head == null){
            this.largo++;
            this.head = new NodoCola(this.largo);
        }else{
            NodoCola tmp = this.head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            this.largo++;
            tmp.next = new NodoCola(this.largo);
        }
    }

}
