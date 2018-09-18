package com.dots.server.socket;

import com.dots.sockets.pruebas.ListaEnlazadaSimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import com.google.gson.Gson;


public class Server extends Thread{

    public Server(){

    }

    public static void main(String[] args) {
        Server servidor = new Server();
        servidor.start();
    }
    /*
    public void iniciar() {
        while (true) {
            try {
                ServerSocket servidor = new ServerSocket(10000);
                Socket cliente = servidor.accept();
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                String listaSerializada = new Gson().toJson(lista);
                salida.println(listaSerializada);
                cliente.close();
                servidor.close();
            } catch (IOException a) {
                System.out.println("Error enviando datos desde el servidor");
            }
        }
    }
    */

    @Override
    public void run(){
        while (true){
            try{
                ServerSocket servidor = new ServerSocket(10001);
                Socket cliente = servidor.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                String json = entrada.readLine();
                try {
                    Tablero tablero = new Gson().fromJson(json, Tablero.class);
                    System.out.println(tablero.getFilas_columnas());
                }catch (Exception e){
                    System.out.println("Error");
                }
                try {
                    ListaEnlazadaSimple lista = new Gson().fromJson(json, ListaEnlazadaSimple.class);
                    lista.print();
                }catch (Exception e){
                    System.out.println("Error");
                }
                cliente.close();
                servidor.close();
            }catch (IOException a){
                System.out.println("Error recibiendo datos desde el servidor");
            }
        }
    }
}

