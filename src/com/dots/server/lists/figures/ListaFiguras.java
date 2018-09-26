package com.dots.server.lists.figures;

/**
 * Clase de una lista enlazada que almacena las figuaras del juego.
 */

public class ListaFiguras {

    private static ListaFiguras ListaFiguras = new ListaFiguras();
    private NodoFiguras head = null;
    private int largo = 0;

    /**
     * Singleton de la clase.
     * @return instancia de la clase.
     */

    public static ListaFiguras getInstance(){
        return ListaFiguras;
    }

    public static void reinicio(){
        ListaFiguras = new ListaFiguras();
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
     * @param largo entero con el nuevo largo de la lista.
     */

    public void setLargo(int largo) {
        this.largo = largo;
    }

    /**
     * Método para añadir una figura a la lista.
     * @param v1x Primer vértice en x.
     * @param v1y Primer vértice en y.
     * @param v2x Segundo vértice en x.
     * @param v2y Segundo vértice en y.
     * @param v3x Tercer vértice en x.
     * @param v3y Tercer vértice en y.
     * @param v4x Cuarto vértice en x, si es un triángulo será 0.
     * @param v4y Cuarto vértice en y, si es un triángulo será 0.
     */

    public void anadirElemento(int v1x, int v1y, int v2x, int v2y, int v3x, int v3y, int v4x, int v4y){
        if (this.head == null){
            this.head = new NodoFiguras(v1x, v1y, v2x, v2y, v3x, v3y, v4x, v4y);
            this.largo++;
        }
        else{
            NodoFiguras tmp = this.head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new NodoFiguras(v1x, v1y, v2x, v2y, v3x, v3y, v4x, v4y);
            this.largo++;
        }
    }

    /**
     * Método para imprimir la lista.
     */

    public void imprimirLista(){
        if (this.head != null){
            NodoFiguras tmp = this.head;
            while (tmp != null){
                System.out.println("******************************************");
                System.out.println("V1: " + tmp.getV1x() + ", " + tmp.getV1y());
                System.out.println("V2: " + tmp.getV2x() + ", " + tmp.getV2y());
                System.out.println("V3: " + tmp.getV3x() + ", " + tmp.getV3y());
                if (tmp.getV4x() != 0){
                    System.out.println("V4: " + tmp.getV4x() + ", " + tmp.getV4y());
                }
                tmp = tmp.next;
            }
        }
        else{
            System.out.println("Error");
        }
    }

    /**
     * Método para comprobar que no se repitan figuras en la lista.
     * @param v1x Primer vértice en x.
     * @param v1y Primer vértice en y.
     * @param v2x Segundo vértice en x.
     * @param v2y Segundo vértice en y.
     * @param v3x Tercer vértice en x.
     * @param v3y Tercer vértice en y.
     * @param v4x Cuarto vértice en x, si es un triángulo será 0.
     * @param v4y Cuarto vértice en y, si es un triángulo será 0.
     * @return boolean indicando si se repite o no.
     */

    public boolean comprobarCoincidencia(int v1x, int v1y, int v2x, int v2y, int v3x, int v3y, int v4x, int v4y){
        if (this.head != null){
            NodoFiguras tmp = this.head;
            while (tmp != null){
                if (v4x == 0){
                    if (tmp.getV4x() != 0){
                        tmp = tmp.next;
                    }
                    else{
                        if ((v1x == tmp.getV1x() || v1x == tmp.getV2x() || v1x == tmp.getV3x()) && (v2x == tmp.getV1x() || v2x == tmp.getV2x() || v2x == tmp.getV3x()) && (v3x == tmp.getV1x() || v3x == tmp.getV2x() || v3x == tmp.getV3x()) && (v1y == tmp.getV1y() || v1y == tmp.getV2y() || v1y == tmp.getV3y()) && (v2y == tmp.getV1y() || v2y == tmp.getV2y() || v2y == tmp.getV3y()) && (v3y == tmp.getV1y() || v3y == tmp.getV2y() || v3y == tmp.getV3y())){
                            return true;
                        }
                        else{
                            tmp = tmp.next;
                        }
                    }
                }
                else{
                    if (tmp.getV4x() == 0){
                        tmp = tmp.next;
                    }
                    else{
                        if ((v1x == tmp.getV1x() || v1x == tmp.getV2x() || v1x == tmp.getV3x() || v1x == tmp.getV4x()) && (v2x == tmp.getV1x() || v2x == tmp.getV2x() || v2x == tmp.getV3x() || v2x == tmp.getV4x()) && (v3x == tmp.getV1x() || v3x == tmp.getV2x() || v3x == tmp.getV3x() || v3x == tmp.getV4x()) && (v4x == tmp.getV1x() || v4x == tmp.getV2x() || v4x == tmp.getV3x() || v4x == tmp.getV4x()) && (v1y == tmp.getV1y() || v1y == tmp.getV2y() || v1y == tmp.getV3y() || v1y == tmp.getV4y()) && (v2y == tmp.getV1y() || v2y == tmp.getV2y() || v2y == tmp.getV3y() || v2y == tmp.getV4y()) && (v3y == tmp.getV1y() || v3y == tmp.getV2y() || v3y == tmp.getV3y() || v3y == tmp.getV4y()) && (v4y == tmp.getV1y() || v4y == tmp.getV2y() || v4y == tmp.getV3y() || v4y == tmp.getV4y())){
                            return true;
                        }
                        else{
                            tmp = tmp.next;
                        }
                    }
                }
            }
            return false;
        }
        else{
            return false;
        }
    }

}
