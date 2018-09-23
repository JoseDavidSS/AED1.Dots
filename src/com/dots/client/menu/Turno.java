package com.dots.client.menu;

import com.dots.client.board.Tablero;
import com.dots.client.lists.figures.ListaFiguras;
import com.dots.client.lists.lines.ListaLineas;
import com.dots.client.socket.Cliente;
import javafx.application.Platform;

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
        while(true){
            Cliente c = new Cliente();
            if (!Juego.tablero.getMiTurno()){
                this.esperar(15);
                boolean a = c.enviarTablero(Juego.tablero);
                if (!a){
                    Juego.tablero.setMiTurno(false);
                    Tablero.setInstance(Juego.tablero);
                }else{
                    Tablero t = c.solicitarTablero();
                    Tablero.setInstance(t);
                    Juego.tablero = t;
                    if (!t.getMiTurno()){
                        ListaLineas l = c.solicitarListaLineas();
                        ListaFiguras l2 = c.solicitarListaFiguras();
                        ListaLineas.setInstance(l);
                        ListaFiguras.setInstance(l2);
                        Platform.runLater(() -> Juego.juego.dibujar());
                    }
                }
            }
            else{
                ListaLineas l = c.solicitarListaLineas();
                ListaFiguras l2 = c.solicitarListaFiguras();
                ListaLineas.setInstance(l);
                ListaFiguras.setInstance(l2);
                System.out.println("MI TURNO");
                Platform.runLater(() -> Juego.juego.dibujar());
                Juego.turno = true;
                Juego.tablero.setMiTurno(false);
                Tablero.setInstance(Juego.tablero);
                break;
            }
        }
    }

    public void esperar(int seg){
        try{
            Thread.sleep(seg * 1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
