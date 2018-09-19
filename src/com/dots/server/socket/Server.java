package com.dots.server.socket;

import com.dots.server.board.Jugadores;
import com.dots.server.lists.lines.ListaLineas;
import com.dots.server.board.Tablero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import com.google.gson.Gson;
import javafx.scene.control.Tab;


public class Server extends Thread{

    public Server(){

    }

    public static void main(String[] args) {
        Server servidor = new Server();
        servidor.start();
    }


    public void iniciarT(Tablero tablero) {
        while (true) {
            try{
                ServerSocket servidor = new ServerSocket(10000);
                Socket cliente = servidor.accept();
                Jugadores jugadores = Jugadores.getInstance();
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                int b = 0;
                if (jugadores.getJ1() == ""){
                    jugadores.setM(tablero.getFilas_columnas());
                    tablero.setJugador("J1");
                    jugadores.setJ1("JI");
                    String tserial = new Gson().toJson(tablero);
                    System.out.println(tserial);
                    salida.println(tserial);
                    b = 1;
                    break;
                }
                if (b == 0){
                    tablero.setJugador("J2");
                    tablero.setFilas_columnas(jugadores.getM());
                    jugadores.setJ2("J2");
                    String tserial = new Gson().toJson(tablero);
                    salida.println(tserial);
                    break;
                }
            }catch (IOException a){
                System.out.println("Error enviando datos");
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
                String json = entrada.readLine();
                try{
                    Tablero tablero = new Gson().fromJson(json, Tablero.class);
                    System.out.println(tablero.getFilas_columnas());
                    if (tablero.getFilas_columnas() != 0){
                        iniciarT(tablero);
                        json = entrada.readLine();
                    }
                }catch(Exception e){
                    System.out.println("Error");
                }
                /*try{
                    ListaLineas ll = new Gson().fromJson(json, ListaLineas.class);
                    System.out.println(ll.getLargo());
                    if (ll.getLargo() != 0){
                        json = entrada.readLine();
                    }
                }catch(Exception e){
                    System.out.println("Error");
                }*/
                cliente.close();
                servidor.close();
            }catch (IOException a){
                System.out.println("Error recibiendo datos desde el servidor");
            }
        }
    }
}

