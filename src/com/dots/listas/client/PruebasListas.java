package com.dots.listas.client;

import com.dots.listas.server.ListaFiguras;
import com.dots.listas.server.ListaLineas;

/**
 * Clase temporal para pruebas de listas
 */

public class PruebasListas {
    public static void main(String [ ] args){

        ListaLineas.getLista(false);
        ListaLineas l1 = ListaLineas.getLista(false);

        ListaFiguras.getLista(false);
        ListaFiguras l2 = ListaFiguras.getLista(false);

        l1.anadirElemento(1,2,1,1);
        l1.anadirElemento(1,2,2,1);
        l1.anadirElemento(1,1,1,2);
        l1.anadirElemento(2,2,1,2);
        l1.anadirElemento(2,3,1,1);
        l1.anadirElemento(3,3,1,2);
        l1.anadirElemento(2,3,2,2);

        l1.comprobarAdyacentes();

    }
}
