package com.dots.sockets.conexion;

import com.dots.sockets.pruebas.ListaEnlazadaSimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class Cliente extends Thread{

    ListaEnlazadaSimple lista;

    public Cliente(){

    }

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

    public void enviarInfo(){
        try {
            Socket conexionServer = new Socket("127.0.0.1",10001);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(),true);
            String listaSerializada = new Gson().toJson(this.lista);
            salida.println(listaSerializada);
            conexionServer.close();
        }catch (IOException a){
            System.out.println("Error enviando datos");
        }
    }

    public static void main(String[] args){
        Cliente c1 = new Cliente();
        c1.solicitarInfo();
        c1.lista.add(9);
        c1.enviarInfo();
        c1.solicitarInfo();
    }
}

