package com.dots.client.socket;

import com.dots.client.board.Tablero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.google.gson.Gson;

public class Cliente extends Thread{

    public Cliente(){
    }

    public static void main(String[] args){
        Cliente c1 = new Cliente();
        Tablero t = new Tablero();
    }

    /***
     * Metodo que solicita el estado del juego al servidor(Tablero)
     * @return
     */
    public Tablero solicitarTablero(){
        try{
            Socket conexionServer = new Socket("127.0.0.1",10000);
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
            String tserial = entradaDatos.readLine();
            System.out.println(tserial);
            Tablero tablero = new Gson().fromJson(tserial, Tablero.class);
            conexionServer.close();
            return tablero;
        } catch (IOException a){
            System.out.println("Error recibiendo datos");
        }
        return null;
    }

    /***
     *  Despues de terminado el turno, el jugador envia al servidor el tablero modificado.
     *  @param tablero Tablero modificado
     */
    public void enviarTablero(Tablero tablero) {
        try {
            Socket conexionServer = new Socket("127.0.0.1", 10001);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(), true);
            String tableroSerial = new Gson().toJson(tablero);
            System.out.println(tableroSerial);
            salida.println(tableroSerial);
            conexionServer.close();
        } catch (IOException a) {
            System.out.println("Error enviando datos");
        }
    }
}

