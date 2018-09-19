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
        t.setFilas_columnas(3);
    }

    public Tablero solicitarTablero(){
        try{
            Socket conexionServer = new Socket("127.0.0.1",10000);
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
            String tserial = entradaDatos.readLine();
            Tablero tablero = new Gson().fromJson(tserial, Tablero.class);
            conexionServer.close();
            return tablero;
        } catch (IOException a){
            System.out.println("Error recibiendo datos");
        }
        return null;
    }

    public void enviarTablero(Tablero tablero) {
        try {
            Socket conexionServer = new Socket("127.0.0.1", 10001);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(), true);
            String tableroSerial = new Gson().toJson(tablero);
            salida.println(tableroSerial);
            conexionServer.close();
        } catch (IOException a) {
            System.out.println("Error enviando datos");
        }
    }
}

