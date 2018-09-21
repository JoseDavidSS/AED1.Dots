package com.dots.server.lists.board;

import com.dots.server.board.Jugadores;

/**
 * Clase que crea la lista de listas para la malla de juego.
 */

public class ListadeListasDeCuadros {

    public int largo = 0;
    public ListaCuadros head = null;
    private static ListadeListasDeCuadros lista = new ListadeListasDeCuadros();

    /**
     * Singleton de la clase.
     * @return instancia de la clase.
     */

    public static ListadeListasDeCuadros getInstance(){
        return lista;
    }

    /**
     * Método para obtener el largo de la lista.
     * @return entero con el largo de la lista.
     */

    public int getLargo() {
        return this.largo;
    }

    /**
     * Método para modificar el largo de la lista.
     * @param largo entero con el nuevo largo de la lista.
     */

    public void setLargo(int largo) {
        this.largo = largo;
    }

    /**
     * Método que crea la lista con todos los cuadros del juego apartir del tamaño del juego.
     * @param filas_columnas tamaño del tablero
     */

    public void anadirElemento(int filas_columnas) {
        int m = filas_columnas - 1;
        int multiplicacdor_y = 1;

        if ((m) >= 2) {
            int filas = m;
            int columnas = m;
            while (filas != 0) {
                if (this.head == null) {
                    this.head = new ListaCuadros();
                    while (columnas != 0){
                        this.head.anadirElemento(filas_columnas,250 + (350/filas_columnas),50);
                        columnas--;
                    }
                    filas--;
                    columnas = m;
                    this.largo++;
                } else {
                    ListaCuadros tmp = this.head;
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = new ListaCuadros();
                    tmp.next.prev = tmp;
                    while (columnas != 0){
                        tmp.next.anadirElemento(filas_columnas,250 + (350/filas_columnas),50 + (multiplicacdor_y*(350/filas_columnas)));
                        columnas--;
                    }
                    filas--;
                    multiplicacdor_y++;
                    columnas = m;
                    this.largo++;
                }
            }
        } else {
            System.out.println("Error, el tamaño mínimo de la plantilla es de 3x3");
        }
    }

    /**
     * Método para imprimir la lista.
     */

    public void imprimirLista(){
        ListaCuadros tmp = this.head;
        while (tmp != null){
            tmp.imprimirLista();
            tmp = tmp.next;
        }
    }

    /**
     * Método que verifica si en el tablero todavía hay cuadrados incompletos
     * @return Boolean indicando si el jeugo ha terminado
     */

    public boolean verificar(){
        ListaCuadros tmp = this.head;

        boolean juegoTerminado = true;

        while(tmp != null && juegoTerminado){
            NodoCuadros sub_tmp = tmp.head;
            while (sub_tmp != null && juegoTerminado){
                if (sub_tmp.getEstado() != 2){
                    juegoTerminado = false;
                }
                else {
                    sub_tmp = sub_tmp.next;
                }
            }
            tmp = tmp.next;
        }
        return juegoTerminado;
    }

    /**
     * Método que cambia el estado del cuadro, si no está el vertice superior derecho, se vuelve a llamar al metodo con un nuevo vertice generado automaticamente.
     * @param x1 X del Vertice superior izquierdo
     * @param y1 Y del Vertice superior izquierdo
     * @param x2 X del Vertice superior derecho
     * @param y2 Y del vertice superior derecho
     * @param estado estado al que se quiere cambiar
     */

    public void cambiarEstado(int x1, int y1, int x2,int y2, int estado) {

        if (x2 == 0 && y2 == 0) {
            Jugadores j = Jugadores.getInstance();
            cambiarEstado(x1, y1, x1+(350/j.getM()),y1,estado);
        } else {
            ListadeListasDeCuadros L1 = ListadeListasDeCuadros.getInstance();
            if (L1.largo != 0) {
                ListaCuadros tmp = L1.head;

                while (tmp != null) {
                    NodoCuadros sub_tmp = tmp.head;
                    while (sub_tmp != null) {
                        if (sub_tmp.get_x() == x2 && sub_tmp.get_y() == y2) {
                            sub_tmp.setEstado(estado);
                            break;
                        } else {
                            sub_tmp = sub_tmp.next;
                        }
                    }
                    tmp = tmp.next;
                }

            } else {
                System.out.println("Error, la lista está vacía");
            }

        }
    }

    public static void main(String[] args){
        /*ListadeListasDeCuadros L1 = ListadeListasDeCuadros.getInstance();
        L1.anadirElemento(5);
        L1.imprimirLista();
        L1.cambiarEstado(390,120,460,120,3);
        L1.imprimirLista();
        System.out.println(L1.head.next.next.next.next.next.head.getV1x());
        System.out.println(L1.head.next.next.next.next.next.head.getV1y());
        System.out.println(L1.verificar());
        L1.head.head.setEstado(2);
        L1.head.head.next.setEstado(2);
        L1.head.next.head.setEstado(2);
        L1.head.next.head.next.setEstado(1);
        L1.imprimirLista();
        System.out.println(L1.verificar());
        L1.head.next.head.next.setEstado(2);
        L1.imprimirLista();
        System.out.println(L1.verificar());*/
    }
}
