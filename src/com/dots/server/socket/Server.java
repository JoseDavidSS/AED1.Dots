package com.dots.sockets.conexion;

import com.dots.sockets.pruebas.ListaEnlazadaSimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import com.google.gson.Gson;


import com.dots.sockets.pruebas.Nodo;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Server extends Thread{

    ListaEnlazadaSimple lista;

    public Server(ListaEnlazadaSimple lista){

        this.lista = lista;

    }

    public void iniciar() {
        while (true) {
            try {
                ServerSocket servidor = new ServerSocket(10000);
                Socket cliente = servidor.accept();
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                String listaSerializada = new Gson().toJson(lista);
                salida.println(listaSerializada);
                cliente.close();
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
                String listaRecibida = entrada.readLine();
                this.lista = new Gson().fromJson(listaRecibida,ListaEnlazadaSimple.class);
                cliente.close();
            }catch (IOException a){
                System.out.println("Error recibiendo datos desde el servidor");
            }
        }
    }

    public static void main(String[] args) {
        ListaEnlazadaSimple Lista = new ListaEnlazadaSimple();
        Lista.add(1);
        Lista.add(2);
        Lista.add(3);
        Lista.add(4);
        Lista.add(5);
        Lista.add(6);
        Lista.add(7);
        Lista.add(8);
        Server servidor = new Server(Lista);
        servidor.start();
        servidor.iniciar();
    }
}

