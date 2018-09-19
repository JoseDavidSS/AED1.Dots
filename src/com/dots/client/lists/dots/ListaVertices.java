package com.dots.client.lists.dots;

import com.dots.client.lists.lines.ListaLineas;

/**
 * Clase de listas simples
 */

public class ListaVertices {

    private static ListaVertices ListaVertices = new ListaVertices();
    private int largo = 0;
    public NodoVertices head = null;

    public static ListaVertices getInstance(){
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
        else if (this.head.getPosx() == posx && this.head.getPosy() == posy){
            System.out.println("Error");
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

    public void reiniciar(){
        ListaVertices = new ListaVertices();
    }

    /**
     * Metodo para imprimir la lista
     */

    public void imprimirLista(){
        NodoVertices tmp = this.head;
        System.out.println("Cambio lista");
        while(tmp != null) {
            System.out.println("Posx: " + tmp.getPosx());
            System.out.println("Posy: " + tmp.getPosy());
            tmp = tmp.next;
        }
    }

    public void ordenar2(){
        if (this.largo == 2){
            NodoVertices tmp = this.head;
            NodoVertices tmp2 = tmp.next;
            ListaLineas l = ListaLineas.getInstance();
            if (tmp.getPosy() == tmp2.getPosy()){
                if (tmp.getPosx() < tmp2.getPosx()){
                    l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                }else{
                    l.anadirElemento(tmp2.getPosx(), tmp.getPosx(), tmp.getPosy(), tmp2.getPosy());
                }
            }
            else if (tmp.getPosx() == tmp2.getPosx()){
                if (tmp.getPosy() < tmp2.getPosy()){
                    l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                }else{
                    l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp2.getPosy(), tmp.getPosy());
                }
            }else {
                if ((tmp.getPosx() < tmp2.getPosx()) && (tmp.getPosy() < tmp2.getPosy())) {
                    l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                } else if ((tmp.getPosx() < tmp2.getPosx()) && (tmp.getPosy() > tmp2.getPosy())) {
                    l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                }else{
                    l.anadirElemento(tmp2.getPosx(), tmp.getPosx(), tmp2.getPosy(), tmp.getPosy());
                }
            }

        }else{
            System.out.println("Error");
        }
    }


}
