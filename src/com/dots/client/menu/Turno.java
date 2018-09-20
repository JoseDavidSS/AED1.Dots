package com.dots.client.menu;

import com.dots.client.board.Tablero;
import com.dots.client.socket.Cliente;

public class Turno extends Thread {

    public Turno(){}

    public void run(){
        Tablero t = Tablero.getInstance();
        System.out.println(t.getMiTurno());
        while(true){
            if (!t.getMiTurno()){
                this.esperese(20);
                Cliente c = new Cliente();
                c.enviarTablero(t);
                t = c.solicitarTablero();
                Tablero.setInstance(t);
            }
            else{
                System.out.println("MI TURNO");
                this.esperese(20);
            }
        }
    }

    private void esperese(int seg){
        try{
            Thread.sleep(seg * 1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }


}
