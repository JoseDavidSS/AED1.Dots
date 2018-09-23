package com.dots.server.lists.lines;

import com.dots.server.lists.figures.ListaFiguras;

/**
 * Clase de una lista enlazada que almacena líneas.
 */

public class ListaLineas {

    public static ListaLineas ListaLineas = new ListaLineas();
    public NodoLineas head = null;
    public NodoLineas tail = null;
    private int largo = 0;
    private boolean ultLinea = false;

    /**
     * Singleton de la clase.
     * @return instancia de la clase.
     */

    public static ListaLineas getInstance() {
        return ListaLineas;
    }

    public static void setInstance(ListaLineas lista){
        ListaLineas = lista;
    }

    public boolean isUltLinea() {
        return this.ultLinea;
    }

    public void setUltLinea(boolean ultLinea) {
        this.ultLinea = ultLinea;
    }

    /**
     * Método para obtener el largo de la lista.
     * @return entero con el largo de la lista.
     */

    public int getLargo() {
        return largo;
    }

    /**
     * Método para modificar el largo de la lista.
     * @param largo enteron con el nuevo largo.
     */

    public void setLargo(int largo) {
        this.largo = largo;
    }

    /**
     * Método para añadir una nueva linea.
     * @param posxi Eje x del vértice inicial de la lista.
     * @param posxf Eje x del vértice final de la lista.
     * @param posyi Eje y del vértice inicial de la lista.
     * @param posyf Eje y del vértice final de la lista.
     */

    public void anadirElemento(int posxi, int posxf, int posyi, int posyf) {
        if (this.head == null) {
            this.head = new NodoLineas(posxi, posxf, posyi, posyf);
            this.tail = this.head;
            this.largo++;
        } else {
            NodoLineas tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new NodoLineas(posxi, posxf, posyi, posyf);
            tmp.next.prev = tmp;
            this.tail = tmp.next;
            this.largo++;
        }
    }

    public void imprimirLista() {
        if (this.largo != 0) {
            NodoLineas tmp = this.head;
            while (tmp != null) {
                System.out.println("I: " + tmp.getPosxi() + ", " + tmp.getPosyi() + ". " + "F: " + tmp.getPosxf() + ", " + tmp.getPosyf());
                tmp = tmp.next;
            }
        } else {
            System.out.println("Error");
        }
    }

    /**
     * Método para comprobar si se forman figuras con las listas almacenadas.
     */

    public void comprobarAdyacentes(){
        if (this.largo > 2){
            ListaFiguras l = ListaFiguras.getInstance();
            NodoLineas tmp1 = this.head;
            NodoLineas tmp2 = tmp1;
            while(tmp1 != null){
                while (tmp2 != null){
                    if (tmp1 == tmp2){
                        tmp2 = tmp2.next;
                    }
                    else if (tmp1.getPosxf() == tmp2.getPosxi() && tmp1.getPosyf() == tmp2.getPosyi()){
                        NodoLineas tmp3 = this.head;
                        while (tmp3 != null){
                            if (tmp1 == tmp3 || tmp2 == tmp3){
                                tmp3 = tmp3.next;
                            }
                            else if (tmp2.getPosxf() == tmp3.getPosxf() && tmp2.getPosyf() == tmp3.getPosyf()){
                                if (tmp1.getPosxi() == tmp3.getPosxi() && tmp1.getPosyi() == tmp3.getPosyi()){
                                    if (this.tail == tmp1 || this.tail == tmp2 || this.tail == tmp3){
                                        if (l.comprobarCoincidencia(tmp1.getPosxi(), tmp1.getPosyi(), tmp2.getPosxi(), tmp2.getPosyi(), tmp3.getPosxf(), tmp3.getPosyf(), 0, 0)){
                                            tmp3 = tmp3.next;
                                        }
                                        else{
                                            this.ultLinea = true;
                                            System.out.println("Triangulo con ultima linea");
                                            System.out.println("V1: " + tmp1.getPosxi() + ", " + tmp1.getPosyi());
                                            System.out.println("V2: " + tmp1.getPosxf() + ", " + tmp1.getPosyf());
                                            System.out.println("V3: " + tmp2.getPosxf() + ", " + tmp2.getPosyf());
                                            l.anadirElemento(tmp1.getPosxi(), tmp1.getPosyi(), tmp2.getPosxi(), tmp2.getPosyi(), tmp3.getPosxf(), tmp3.getPosyf(), 0, 0);
                                            tmp3 = tmp3.next;
                                        }
                                    }
                                    else{
                                        this.ultLinea = false;
                                        System.out.println("Triangulo");
                                        System.out.println("V1: " + tmp1.getPosxi() + ", " + tmp1.getPosyi());
                                        System.out.println("V2: " + tmp1.getPosxf() + ", " + tmp1.getPosyf());
                                        System.out.println("V3: " + tmp2.getPosxf() + ", " + tmp2.getPosyf());
                                        l.anadirElemento(tmp1.getPosxi(), tmp1.getPosyi(), tmp2.getPosxi(), tmp2.getPosyi(), tmp3.getPosxf(), tmp3.getPosyf(), 0, 0);
                                        tmp3 = tmp3.next;
                                    }
                                }
                                else{
                                    NodoLineas tmp4 = this.head;
                                    while (tmp4 != null){
                                        if (tmp1 == tmp4 || tmp2 == tmp4 || tmp3 == tmp4){
                                            tmp4 = tmp4.next;
                                        }
                                        else if (tmp3.getPosxi() == tmp4.getPosxf() && tmp3.getPosyi() == tmp4.getPosyf()){
                                            if (tmp1.getPosxi() == tmp4.getPosxi() && tmp1.getPosyi() == tmp4.getPosyi()){
                                                if (this.tail == tmp1 || this.tail == tmp2 || this.tail == tmp3 || this.tail == tmp4){
                                                    if (l.comprobarCoincidencia(tmp1.getPosxi(), tmp1.getPosyi(), tmp2.getPosxi(), tmp2.getPosyi(), tmp3.getPosxf(), tmp3.getPosyf(), tmp4.getPosxf(), tmp4.getPosyf())){
                                                        tmp4 = tmp4.next;
                                                    }
                                                    else{
                                                        this.ultLinea = true;
                                                        System.out.println("Cuadrado con ultima linea");
                                                        System.out.println("V1: " + tmp1.getPosxi() + ", " + tmp1.getPosyi());
                                                        System.out.println("V2: " + tmp1.getPosxf() + ", " + tmp1.getPosyf());
                                                        System.out.println("V3: " + tmp2.getPosxf() + ", " + tmp2.getPosyf());
                                                        System.out.println("V4: " + tmp4.getPosxf() + ", " + tmp4.getPosyf());
                                                        l.anadirElemento(tmp1.getPosxi(), tmp1.getPosyi(), tmp2.getPosxi(), tmp2.getPosyi(), tmp3.getPosxf(), tmp3.getPosyf(), tmp4.getPosxf(), tmp4.getPosyf());
                                                        tmp4 = tmp4.next;
                                                    }
                                                }
                                                else{
                                                    this.ultLinea = false;
                                                    System.out.println("Cuadrado");
                                                    System.out.println("V1: " + tmp1.getPosxi() + ", " + tmp1.getPosyi());
                                                    System.out.println("V2: " + tmp1.getPosxf() + ", " + tmp1.getPosyf());
                                                    System.out.println("V3: " + tmp2.getPosxf() + ", " + tmp2.getPosyf());
                                                    System.out.println("V4: " + tmp4.getPosxf() + ", " + tmp4.getPosyf());
                                                    l.anadirElemento(tmp1.getPosxi(), tmp1.getPosyi(), tmp2.getPosxi(), tmp2.getPosyi(), tmp3.getPosxf(), tmp3.getPosyf(), tmp4.getPosxf(), tmp4.getPosyf());
                                                    tmp4 = tmp4.next;
                                                }
                                            }
                                            else{
                                                tmp4 = tmp4.next;
                                            }
                                        }
                                        else{
                                            tmp4 = tmp4.next;
                                        }
                                    }
                                    tmp3 = tmp3.next;
                                }
                            }
                            else{
                                tmp3 = tmp3.next;
                            }
                        }
                        tmp2 = tmp2.next;
                    }
                    else{
                        tmp2 = tmp2.next;
                    }
                }
                tmp1 = tmp1.next;
                tmp2 = this.head;
            }
        }
        else{
            System.out.println("Error");
        }
    }

    public boolean comprobarIgualdad(int posxi, int posxf, int posyi, int posyf){
        if (this.largo != 0){
            NodoLineas tmp = this.head;
            while (tmp != null){
                if (tmp.getPosxi() == posxi && tmp.getPosxf() == posxf && tmp.getPosyi() == posyi && tmp.getPosyf() == posyf){
                    return false;
                }else{
                    tmp = tmp.next;
                }
            }
            return true;
        }else{
            return true;
        }
    }
}
