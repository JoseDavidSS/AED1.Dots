package com.dots.server.lists.board;

public class ListadeListasDeCuadros {

    public int largo = 0;
    public ListaCuadros head = null;
    private static ListadeListasDeCuadros lista = new ListadeListasDeCuadros();

    public static ListadeListasDeCuadros getInstance(){
        return lista;
    }

    public int getLargo() {
        return this.largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void anadirElemento(int filas_columnas, int v1x, int v1y) {
        if (filas_columnas >= 2) {
            int filas = filas_columnas;
            int columnas = filas_columnas;
            while (filas != 0) {
                if (this.head == null) {
                    this.head = new ListaCuadros();
                    while (columnas != 0){
                        this.head.anadirElemento(v1x, v1y);
                        columnas--;
                    }
                    filas--;
                    columnas = filas_columnas;
                    this.largo++;
                } else {
                    ListaCuadros tmp = this.head;
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = new ListaCuadros();
                    tmp.next.prev = tmp;
                    while (columnas != 0){
                        tmp.next.anadirElemento(v1x, v1y);
                        columnas--;
                    }
                    filas--;
                    columnas = filas_columnas;
                    this.largo++;
                }
            }
        } else {
            System.out.println("Error, el tamaño mínimo de la plantilla es de 3x3");
        }
    }

    public void imprimirLista(){
        ListaCuadros tmp = this.head;
        while (tmp != null){
            tmp.imprimirLista();
            tmp = tmp.next;
        }
    }

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

    public static void main(String[] args){
        ListadeListasDeCuadros L1 = ListadeListasDeCuadros.getInstance();
        L1.anadirElemento(2,250,50);
        L1.imprimirLista();
        System.out.println(L1.verificar());
        L1.head.head.setEstado(2);
        L1.head.head.next.setEstado(2);
        L1.head.next.head.setEstado(2);
        L1.head.next.head.next.setEstado(1);
        L1.imprimirLista();
        System.out.println(L1.verificar());
        L1.head.next.head.next.setEstado(2);
        L1.imprimirLista();
        System.out.println(L1.verificar());
    }
}
