package com.dots.server.lists.tail;

public class ListaDeCola {

    public static ListaDeCola lista = new ListaDeCola();
    public NodoCola head = null;
    private int largo = 0;

    public static ListaDeCola getInstance(){
        return lista;
    }

    public static void setInstance(ListaDeCola listan){
        lista = listan;
    }

    public static void reinicio(){
        lista = new ListaDeCola();
    }

    public int getLargo() {
        return this.largo;
    }

    public void anadirElemento(){
        if (this.head == null){
            this.largo++;
            this.head = new NodoCola(this.largo);
        }else{
            NodoCola tmp = this.head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            this.largo++;
            tmp.next = new NodoCola(this.largo);
        }
    }

    public void eliminar(int ficha){
        if (this.head == null){
            System.out.println("No hay nadie en cola");
        }
        else if (this.head.next == null){
            this.head.setFicha(0);
        }
        else{
            NodoCola tmp = this.head;
            while (tmp != null){
                if (tmp.getFicha() == ficha){
                    tmp.setFicha(0);
                    break;
                }
                tmp = tmp.next;
            }
        }
    }

    public boolean buscar(int jugador){
        if (this.head == null){
            return false;
        }
        else{
            NodoCola tmp = this.head;
            while (tmp.next != null){
                if (tmp.next.getFicha() == jugador && tmp.getFicha() == 0){
                    tmp.next.setFicha(0);
                    return true;
                }
                tmp = tmp.next;
            }
            return false;
        }
    }

}
