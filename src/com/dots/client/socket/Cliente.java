package com.dots.client.socket;

import com.dots.client.lists.lines.ListaLineas;
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
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.add(100);
        lista.add(200);
        c1.enviarDatos(t, lista);
    }

    public void solicitarInfo(){
        try{
            sleep(3000);
            Socket conexionServer = new Socket("127.0.0.1",10000);
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
            String listRecibida = entradaDatos.readLine();
            ListaEnlazadaSimple l1 = new Gson().fromJson(listRecibida,ListaEnlazadaSimple.class);
            conexionServer.close();
            System.out.println("Lista que recibí:");
            l1.print();
        } catch (IOException | InterruptedException a){
            System.out.println("Error recibiendo datos");
        }
    }

    public void enviarDatos(Tablero tablero, ListaEnlazadaSimple lista) {
        try {
            Socket conexionServer = new Socket("127.0.0.1", 10001);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(), true);
            String tableroSerial = new Gson().toJson(tablero);
            salida.println(tableroSerial);
            //String listaSerializada = new Gson().toJson(lista);
            //salida.println(listaSerializada);
            ListaLineas l1 = new ListaLineas();
            l1.anadirElemento(1,1,2,3);
            String lf = new Gson().toJson(l1);
            salida.println(lf);
            conexionServer.close();
        } catch (IOException a) {
            System.out.println("Error enviando datos");
        }
    }
}

