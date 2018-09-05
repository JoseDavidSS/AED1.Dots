package com.dots.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class HiloServer extends Thread {
    BufferedReader entrada;
    PrintWriter salida;
    Socket socket;

    public HiloServer(Socket socket) {
        this.socket = socket;
        try {
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error IO ");
        }
    }

    @Override
    public void run() {
        int numero = 0;
        while (numero != 6969) {
            try {
                numero = Integer.parseInt(entrada.readLine());
                if (numero % 2 == 0) {
                    salida.println("Par");
                } else {
                    salida.println("Impar");
                }
            } catch (IOException | NumberFormatException a) {
                System.out.println("Error");
                salida.println("Error");
            }
            try {
                entrada.close();
                salida.close();
                socket.close();
            } catch (IOException a) {
                System.out.println("Error IO");
            }
        }
    }
}

