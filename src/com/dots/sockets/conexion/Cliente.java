package com.dots.sockets.conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente extends Thread{
    public Cliente(){

    }

    public void solicitarInfo(){

        try{
            sleep(3000);
            Socket conexionServer = new Socket("192.168.1.144",10000);
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
            System.out.println(entradaDatos.readLine());
            conexionServer.close();
        } catch (IOException | InterruptedException a){
            System.out.println("Error recibiendo datos");
        }
    }

    public void enviarInfo(String mensaje){
        try {
            Socket conexionServer = new Socket("192.168.1.144",10001);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(),true);
            salida.println(mensaje);
            conexionServer.close();
        }catch (IOException a){
            System.out.println("Error enviando datos");
        }
    }

    public static void main(String[] args){
        Cliente c1 = new Cliente();
        c1.solicitarInfo();
        c1.enviarInfo("Mensaje cambiado");
        c1.solicitarInfo();
    }
}

