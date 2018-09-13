package com.dots.sockets.conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{

    String mensaje = "Hola";

    public Server(){

    }

    public void iniciar() {
        while (true) {
            try {
                ServerSocket servidor = new ServerSocket(10000);
                Socket cliente = servidor.accept();
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                salida.println(this.mensaje);
                //sleep(3000);
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
                this.mensaje = entrada.readLine();
                cliente.close();
            }catch (IOException a){
                System.out.println("Error recibiendo datos desde el servidor");
            }
        }
    }

    public static void main(String[] args){
        Server servidor = new Server();
        servidor.start();
        servidor.iniciar();
    }
}

