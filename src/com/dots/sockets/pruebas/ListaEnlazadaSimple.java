package com.dots.sockets.pruebas;

public class ListaEnlazadaSimple {
    Nodo first = null;


    public Nodo getFirst() {
        return first;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }

    public  void add(int valor){
        if (this.first == null){
            this.first = new Nodo(valor);
        }
        else {
            Nodo temp = this.first;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Nodo(valor);
        }
    }

    public void print(){
        if (this.first == null){
            System.out.println("Lista vacía");
        }
        else {
            Nodo temp = this.first;
            while (temp != null){
                System.out.println(temp.valor);
                temp = temp.next;
            }
            System.out.println("------------------------------------------------");
        }
    }

    public static void main(String[] args){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.add(12);
        lista.add(13);
        lista.add(14);
        lista.add(15);
        lista.add(16);
        lista.add(17);
        lista.add(18);
        lista.print();
    }
}

