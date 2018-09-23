package com.dots.server.lists.dots;

import com.dots.server.board.Jugadores;
import com.dots.server.lists.lines.ListaLineas;

/**
 * Clase de una lista enlazada que almacena solamente dos nodos, osea dos vertices.
 */

public class ListaVertices {

    private static ListaVertices ListaVertices = new ListaVertices();
    private int largo = 0;
    public NodoVertices head = null;
    private boolean valido = false;

    /**
     * Método Singleton.
     * @return instancia de esta clase.
     */

    public static ListaVertices getInstance(){
        return ListaVertices;
    }

    public static void setInstance(ListaVertices lista){
        ListaVertices = lista;
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

    public boolean isValido() {
        return this.valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
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

    public void ordenar2(){
        if (this.largo == 2){
            NodoVertices tmp = this.head;
            NodoVertices tmp2 = tmp.next;
            ListaLineas l = ListaLineas.getInstance();
            int m = Jugadores.getInstance().getM();
            boolean a;
            if (tmp.getPosy() == tmp2.getPosy()){
                if (tmp.getPosx() < tmp2.getPosx()){
                    if (tmp2.getPosx() - tmp.getPosx() > 350 / m){
                        this.valido = false;
                    }else{
                        a = l.comprobarIgualdad(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                        if (a){
                            l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                            ListaLineas.setInstance(l);
                            this.valido = true;
                        }else{
                            this.valido = false;
                        }
                    }
                }else{
                    if (tmp.getPosx() - tmp2.getPosx() > 350 / m){
                        this.valido = false;
                    }else{
                        a = l.comprobarIgualdad(tmp2.getPosx(), tmp.getPosx(), tmp.getPosy(), tmp2.getPosy());
                        if (a){
                            l.anadirElemento(tmp2.getPosx(), tmp.getPosx(), tmp.getPosy(), tmp2.getPosy());
                            ListaLineas.setInstance(l);
                            this.valido = true;
                        }else{
                            this.valido = false;
                        }
                    }
                }
            }
            else if (tmp.getPosx() == tmp2.getPosx()){
                if (tmp.getPosy() < tmp2.getPosy()){
                    if (tmp2.getPosy() - tmp.getPosy() > 350 / m){
                        this.valido = false;
                    }else{
                        a = l.comprobarIgualdad(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                        if (a){
                            l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                            ListaLineas.setInstance(l);
                            this.valido = true;
                        }else{
                            this.valido = false;
                        }
                    }
                }else{
                    if (tmp.getPosy() - tmp2.getPosy() > 350 / m){
                        this.valido = false;
                    }else{
                        a = l.comprobarIgualdad(tmp.getPosx(), tmp2.getPosx(), tmp2.getPosy(), tmp.getPosy());
                        if (a){
                            l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp2.getPosy(), tmp.getPosy());
                            ListaLineas.setInstance(l);
                            this.valido = true;
                        }else{
                            this.valido = false;
                        }
                    }
                }
            }else {
                if ((tmp.getPosx() < tmp2.getPosx()) && (tmp.getPosy() < tmp2.getPosy())) {
                    if (((tmp2.getPosx() - tmp.getPosx() >= (350 / m)) && (tmp2.getPosy() - tmp.getPosy() != (350 / m))) || ((tmp2.getPosy() - tmp.getPosy() >= (350 / m)) && (tmp2.getPosx() - tmp.getPosx() != (350 / m)))){
                        this.valido = false;
                    }else{
                        a = l.comprobarIgualdad(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                        if (a){
                            l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                            ListaLineas.setInstance(l);
                            this.valido = true;
                        }else{
                            this.valido = false;
                        }
                    }
                } else if ((tmp.getPosx() < tmp2.getPosx()) && (tmp.getPosy() > tmp2.getPosy())) {
                    if (((tmp2.getPosx() - tmp.getPosx() >= (350 / m)) && (tmp.getPosy() - tmp2.getPosy() != (350 / m))) || ((tmp.getPosy() - tmp2.getPosy() >= (350 / m)) && (tmp2.getPosx() - tmp.getPosx() != (350 / m)))){
                        this.valido = false;
                    }else{
                        a = l.comprobarIgualdad(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                        if (a){
                            l.anadirElemento(tmp.getPosx(), tmp2.getPosx(), tmp.getPosy(), tmp2.getPosy());
                            ListaLineas.setInstance(l);
                            this.valido = true;
                        }else{
                            this.valido = false;
                        }
                    }
                }else if ((tmp.getPosx() > tmp2.getPosx()) && (tmp.getPosy() < tmp2.getPosy())){
                    if (((tmp.getPosx() - tmp2.getPosx() >= (350 / m)) && (tmp2.getPosy() - tmp.getPosy() != (350 / m))) || ((tmp2.getPosy() - tmp.getPosy() >= (350 / m)) && (tmp.getPosx() - tmp2.getPosx() != (350 / m)))){
                        this.valido = false;
                    }else{
                        a = l.comprobarIgualdad(tmp2.getPosx(), tmp.getPosx(), tmp2.getPosy(), tmp.getPosy());
                        if (a){
                            l.anadirElemento(tmp2.getPosx(), tmp.getPosx(), tmp2.getPosy(), tmp.getPosy());
                            ListaLineas.setInstance(l);
                            this.valido = true;
                        }else{
                            this.valido = false;
                        }
                    }
                }else{
                    if (((tmp.getPosx() - tmp2.getPosx() >= (350 / m)) && (tmp.getPosy() - tmp2.getPosy() != (350 / m))) || ((tmp.getPosy() - tmp2.getPosy() >= (350 / m)) && (tmp.getPosx() - tmp2.getPosx() != (350 / m)))){
                        this.valido = false;
                    }else{
                        a = l.comprobarIgualdad(tmp2.getPosx(), tmp.getPosx(), tmp2.getPosy(), tmp.getPosy());
                        if (a){
                            l.anadirElemento(tmp2.getPosx(), tmp.getPosx(), tmp2.getPosy(), tmp.getPosy());
                            ListaLineas.setInstance(l);
                            this.valido = true;
                        }else{
                            this.valido = false;
                        }
                    }
                }
            }

        }else{
            System.out.println("Error");
            this.valido = false;
        }
    }


}
