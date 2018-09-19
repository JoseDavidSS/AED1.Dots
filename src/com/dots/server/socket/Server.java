package com.dots.server.socket;

import com.dots.server.board.Jugadores;
import com.dots.server.board.Tablero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import com.google.gson.Gson;


public class Server extends Thread{

    public static void main(String[] args) {
        Server servidor = new Server();
        servidor.start();
    }

    public void iniciarT(Tablero t) {
        while (true) {
            try {
                ServerSocket servidor = new ServerSocket(10000);
                Socket cliente = servidor.accept();
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                String tSerializada = new Gson().toJson(t);
                salida.println(tSerializada);
                cliente.close();
                servidor.close();
            } catch (IOException a) {
                System.out.println("Error enviando datos desde el servidor");
            }
        }
    }

    @Override
    public void run(){
        while (true){
            try{
                ServerSocket servidor = new ServerSocket(10001);
                Socket cliente = servidor.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                Jugadores J = Jugadores.getInstance();
                if (!J.getJ1()){
                    String tRecibida = entrada.readLine();
                    cliente.close();
                    servidor.close();
                    Tablero t = new Gson().fromJson(tRecibida, Tablero.class);
                    J.setM(t.getFilas_columnas());
                    t.setJugador("J1");
                    iniciarT(t);
                }
            }catch (IOException a){
                System.out.println("Error recibiendo datos desde el servidor");
            }
        }
    }
}

