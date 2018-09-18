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

    public boolean print(){
        if (this.first == null){
            return false;
        }
        else {
            Nodo temp = this.first;
            while (temp != null){
                System.out.println(temp.valor);
                temp = temp.next;
            }
            System.out.println("------------------------------------------------");
            return true;
        }
    }
}

