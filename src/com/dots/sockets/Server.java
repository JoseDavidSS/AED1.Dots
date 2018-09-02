package com.dots.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(10000);
        System.out.println("Inicio el servidor");
        while (true){
            Socket cliente = new Socket();
            cliente = server.accept();
            HiloServer hilo = new HiloServer(cliente);
            hilo.start();
        }
    }

}
