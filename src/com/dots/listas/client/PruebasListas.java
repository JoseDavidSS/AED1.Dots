package com.dots.listas.client;

import com.dots.listas.server.ListaSimpleLineas;

/**
 * Clase temporal para pruebas de listas
 */

public class PruebasListas {
    public static void main(String [ ] args){

        ListaSimpleLineas.getLista();
        ListaSimpleLineas l1 = ListaSimpleLineas.getLista();
        l1.anadirElemento(2, 2, 1, 2);
        l1.anadirElemento(1, 2, 1, 2);
        l1.anadirElemento(1,2,1,1);


        l1.comprobarAdyacentes();

    }
}
