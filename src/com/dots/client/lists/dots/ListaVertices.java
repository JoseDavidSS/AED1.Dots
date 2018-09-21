package com.dots.client.lists.dots;

import com.dots.client.lists.lines.ListaLineas;
import com.dots.client.menu.Juego;

/**
 * Clase de una lista enlazada que almacena solamente dos nodos, osea dos vertices.
 */

public class ListaVertices {

    private static ListaVertices ListaVertices = new ListaVertices();
    private int largo = 0;
    public NodoVertices head = null;

    /**
     * Método Singleton.
     * @return instancia de esta clase.
     */

    public static ListaVertices getInstance(){
        return ListaVertices;
    }

    /**
     * Método para obtener el largo de la lista.
     * @return entero con el largo de la lista.
     */

    public int getLargo() {
        return this.largo;
    }

    /**
     * Método para modificar/cambiar el largo de la lista.
     * @param largo entero con el nuevo largo de la lista.
     */

    public void setLargo(int largo) {
        this.largo = largo;
    }

    /**
     * Método que agrega un vértice a la lista
     * @param posx Posición en x del vértice
     * @param posy Posición en y del vérice
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

    /**
     * Método para reiniciar el Singleton
     */

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

    /**
     * Método para ordenar los dos vértices de la lista de modo que cumplan el orden estipulado por nosotros, para que el algoritmo de realización de figuras funcione de manera adecuada.
     * @return booleans indicando si los vértices presionados son adyacentes.
     */

    public boolean ordenar2(){
        if (this.largo == 2){
            NodoVertices tmp = this.head;
            NodoVertices tmp2 = tmp.next;
            ListaLineas l = ListaLineas.getInstance();
            int m = Juego.columnas_filas;
            if (tmp.getPosy() == tmp2.getPosy()){
                if (tmp.getPosx() < tmp2.getPosx()){
                    if (tmp2.getPosx() - tmp.getPosx() > 350 / m){
                        System.out.println(tmp2.getPosx() - tmp.getPosx());
                        System.out.println(350 / m);
                        System.out.println("NO1");
                        return false;
                    }else{
                        l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                        System.out.println("SI");
                        return true;
                    }
                }else{
                    if (tmp.getPosx() - tmp2.getPosx() > 350 / m){
                        System.out.println("NO2");
                        return false;
                    }else{
                        l.anadirElemento(tmp2.getPosx(), tmp.getPosx(), tmp.getPosy(), tmp2.getPosy());
                        System.out.println("SI");
                        return true;
                    }
                }
            }
            else if (tmp.getPosx() == tmp2.getPosx()){
                if (tmp.getPosy() < tmp2.getPosy()){
                    if (tmp2.getPosy() - tmp.getPosy() > 350 / m){
                        System.out.println("NO3");
                        return false;
                    }else{
                        l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                        System.out.println("SI");
                        return true;
                    }
                }else{
                    if (tmp.getPosy() - tmp2.getPosy() > 350 / m){
                        System.out.println("NO4");
                        return false;
                    }else{
                        l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp2.getPosy(), tmp.getPosy());
                        System.out.println("SI");
                        return true;
                    }
                }
            }else {
                if ((tmp.getPosx() < tmp2.getPosx()) && (tmp.getPosy() < tmp2.getPosy())) {
                    if (tmp2.getPosx() - tmp.getPosx() > (350 / m) + 50){
                        System.out.println("NO5");
                        return false;
                    }else{
                        l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                        System.out.println("SI");
                        return true;
                    }
                } else if ((tmp.getPosx() < tmp2.getPosx()) && (tmp.getPosy() > tmp2.getPosy())) {
                    if (tmp2.getPosx() - tmp.getPosx() > (350 / m) + 50){
                        System.out.println("NO6");
                        return false;
                    }else{
                        l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                        System.out.println("SI");
                        return true;
                    }
                }else{
                    if (tmp.getPosx() - tmp2.getPosx() > (350 / m) + 50){
                        System.out.println("NO7");
                        return false;
                    }else{
                        l.anadirElemento(tmp2.getPosx(), tmp.getPosx(), tmp2.getPosy(), tmp.getPosy());
                        System.out.println("SI");
                        return true;
                    }
                }
            }

        }else{
            System.out.println("Error");
            return false;
        }
    }


}
