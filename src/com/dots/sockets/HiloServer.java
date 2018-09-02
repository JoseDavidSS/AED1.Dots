package com.dots.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class HiloServer extends Thread {
    BufferedReader entrada;
    PrintWriter salida;
    Socket socket;

    public HiloServer (Socket socket){
        this.socket = socket;
        try {
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(),true);
        }catch (IOException e){
            System.out.println("Mae se despicho la vara");
        }
    }

    @Override
    public void run() {
        int numero = 0;

        while (numero != 6969){
            System.out.println("El cliente " + socket.toString() + " envió un número.");
            try {
                numero = Integer.parseInt(entrada.readLine());
                if ( numero%2 == 0){
                    salida.println("Par");
                }
                else {
                    salida.println("Impar");
                }
            }catch (IOException e){
                System.out.println("Mae se despicho la vara");
            }
        }
        System.out.println("El cliente " + socket.toString() + " terminó la sesión" );
        try {
            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException e){
            System.out.println("Mae se despicho la vara");
        }
    }
}

