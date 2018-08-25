package com.dots.listas;

/**
 * Clase temporal para pruebas de listas
 */

public class PruebasListas {
    public static void main(String [ ] args){
        ListaSimple<Integer> l1 = new ListaSimple<>();
        l1.anadirElemento(3);
        l1.anadirElemento(4);
        l1.imprimirLista();
    }
}
