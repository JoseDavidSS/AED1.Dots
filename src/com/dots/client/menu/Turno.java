package com.dots.client.menu;

import com.dots.client.board.Tablero;
import com.dots.client.socket.Cliente;

/**
 * Clase que maneja los turnos del jugador
 */

public class Turno extends Thread {

    /**
     * Constructor de la clase.
     */

    public Turno(){}

    /**
     * Método para ejecutar el thread del cliente, se encarga de mantener en espera al jugador en caso de no sea su turno, y si lo es entra en una serie de métodos.
     */

    public void run(){
        Tablero t = Tablero.getInstance();
        System.out.println(t.getMiTurno());
        while(true){
            if (!t.getMiTurno()){
                this.esperar(20);
                Cliente c = new Cliente();
                c.enviarTablero(t);
                t = c.solicitarTablero();
                Tablero.setInstance(t);
            }
            else{
                System.out.println("MI TURNO");
                this.esperar(20);
            }
        }
    }

    /**
     * Método para hacer que el thread espere cierta cantidad de segundos antes de volver a conectarse al server.
     * @param seg entero con la cantidad de segundos  esperar.
     */

    private void esperar(int seg){
        try{
            Thread.sleep(seg * 1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
