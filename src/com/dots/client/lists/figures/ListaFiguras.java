package com.dots.listas.server;

public class ListaFiguras {

    private static ListaFiguras ListaFiguras;
    private NodoFiguras head;
    private int largo;

    private ListaFiguras() {
        this.head = null;
        this.largo = 0;
    }

    public static ListaFiguras getLista(boolean reinicio){
        if (ListaFiguras == null){
            ListaFiguras = new ListaFiguras();
        }
        else if (reinicio){
            ListaFiguras = new ListaFiguras();
        }
        else{
            return ListaFiguras;
        }
        return null;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void anadirElemento(NodoLineas l1, NodoLineas l2, NodoLineas l3, NodoLineas l4){
        if (this.head == null){
            this.head = new NodoFiguras(l1, l2, l3, l4);
            this.largo++;
        }
        else{
            NodoFiguras tmp = this.head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new NodoFiguras(l1, l2, l3, l4);
            this.largo++;
        }
    }

    public void imprimirLista(){
        if (this.head != null){
            NodoFiguras tmp = this.head;
            while (tmp != null){
                System.out.println("V1: " + tmp.getL1().getPosxi() + ", " + tmp.getL1().getPosyi() + " V2 : " + tmp.getL1().getPosxf() + ", " + tmp.getL1().getPosyf());
                System.out.println("V3: " + tmp.getL2().getPosxi() + ", " + tmp.getL2().getPosyi() + " V4 : " + tmp.getL2().getPosxf() + ", " + tmp.getL2().getPosyf());
                System.out.println("V5: " + tmp.getL3().getPosxi() + ", " + tmp.getL3().getPosyi() + " V6 : " + tmp.getL3().getPosxf() + ", " + tmp.getL3().getPosyf());
                if (tmp.getL4() != null){
                    System.out.println("V7: " + tmp.getL4().getPosxi() + ", " + tmp.getL4().getPosyi() + " V8 : " + tmp.getL4().getPosxf() + ", " + tmp.getL4().getPosyf());
                }
                tmp = tmp.next;
            }
        }
        else{
            System.out.println("Error");
        }
    }

    public boolean comprobarCoincidencia(NodoLineas l1, NodoLineas l2, NodoLineas l3, NodoLineas l4){
        if (this.head != null){
            NodoFiguras tmp = this.head;
            while (tmp != null){
                if (l4 == null){
                    if (tmp.getL4() != null){
                        tmp = tmp.next;
                    }
                    else{
                        if ((l1 == tmp.getL1() || l1 == tmp.getL2() || l1 == tmp.getL3()) && (l2 == tmp.getL1() || l2 == tmp.getL2() || l2 == tmp.getL3()) && (l3 == tmp.getL1() || l3 == tmp.getL2() || l3 == tmp.getL3())){
                            return true;
                        }
                        else{
                            tmp = tmp.next;
                        }
                    }
                }
                else{
                    if ((l1 == tmp.getL1() || l1 == tmp.getL2() || l1 == tmp.getL3() || l1 == tmp.getL4()) && (l2 == tmp.getL1() || l2 == tmp.getL2() || l2 == tmp.getL3() || l2 == tmp.getL4()) && (l3 == tmp.getL1() || l3 == tmp.getL2() || l3 == tmp.getL3() || l3 == tmp.getL4()) && (l4 == tmp.getL1() || l4 == tmp.getL2() || l4 == tmp.getL3() || l4 == tmp.getL4())){
                        return true;
                    }
                    else{
                        tmp = tmp.next;
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
