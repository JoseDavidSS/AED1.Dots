package com.dots.client.socket;

import com.dots.sockets.pruebas.ListaEnlazadaSimple;

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
        c1.enviarNum(t);
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.add(1);
        lista.add(2);
        lista.print();
        c1.enviarLista(lista);
    }

    /*
    public void solicitarInfo(){

        try{
            sleep(3000);
            Socket conexionServer = new Socket("127.0.0.1",10000);
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
            String listRecibida = entradaDatos.readLine();
            this.lista = new Gson().fromJson(listRecibida,ListaEnlazadaSimple.class);
            conexionServer.close();
            System.out.println("Lista que recibí:");
            lista.print();
        } catch (IOException | InterruptedException a){
            System.out.println("Error recibiendo datos");
        }
    }
    */

    public void enviarLista(ListaEnlazadaSimple lista){
        try {
            Socket conexionServer = new Socket("127.0.0.1",10001);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(),true);
            String listaSerializada = new Gson().toJson(lista);
            salida.println(listaSerializada);
            conexionServer.close();
        }catch (IOException a){
            System.out.println("Error enviando datos");
        }
    }

    public void enviarNum(Tablero tablero){
        try {
            Socket conexionServer = new Socket("127.0.0.1",10001);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(),true);
            String tableroSerial = new Gson().toJson(tablero);
            salida.println(tableroSerial);
            conexionServer.close();
        }catch (IOException a){
            System.out.println("Error enviando datos");
        }
    }

}

